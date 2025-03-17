package dev.runo.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.runo.home.R
import dev.runo.home.databinding.FragmentHomeBinding


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recycleViewCourse: RecyclerView

    private val courseViewModel by viewModels<CourseViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        recycleViewCourse = binding.coursesList
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.sortButton.setOnClickListener {  }

        recycleViewCourse.layoutManager = LinearLayoutManager(context)
        val adapter = CourseAdapter { openCourseListener(it) }
        recycleViewCourse.adapter = adapter

        courseViewModel.coursesList.observeForever {
            adapter.submitList(it)
        }
    }

    private fun openCourseListener(id: Int) {
        // логика открытия курса
    }


}