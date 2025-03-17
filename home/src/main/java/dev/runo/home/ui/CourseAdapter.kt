package dev.runo.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.runo.home.R
import dev.runo.home.databinding.CourseElementBinding

class CourseAdapter(
    private val listener: OnOpenCourseListener
) : ListAdapter<CourseUiState, CourseAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: CourseElementBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(courseUiState: CourseUiState) {
            binding.courseName.text = courseUiState.title
            binding.rating.text = courseUiState.rate
            binding.date.text = courseUiState.startDate
            binding.courseDescription.text = courseUiState.description
            binding.btnAddFav.setOnClickListener { listener }

            if (courseUiState.hasLike) {
                binding.btnAddFav.setColorFilter(R.color.green)
            }
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<CourseUiState>() {
        override fun areItemsTheSame(oldItem: CourseUiState, newItem: CourseUiState): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CourseUiState, newItem: CourseUiState): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CourseElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

fun interface OnOpenCourseListener {
    fun onOpenCourse(position: Int)
}