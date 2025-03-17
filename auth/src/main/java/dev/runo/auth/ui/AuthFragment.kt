package dev.runo.auth.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.runo.auth.R
import dev.runo.auth.databinding.FragmentAuthBinding
import dev.runo.core.navigation.NavigationHelper
import dev.runo.core.navigation.Routes
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_auth) {

    private lateinit var binding: FragmentAuthBinding

    @Inject lateinit var navigationHelper: NavigationHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVk.setOnClickListener { vkButtonAction() }
        binding.btnOk.setOnClickListener { okButtonAction() }
        binding.btnEnter.setOnClickListener { enterButtonAction() }
    }

    private fun vkButtonAction() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://vk.com")
        }
        startActivity(intent)
    }

    private fun okButtonAction() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://ok.ru")
        }
        startActivity(intent)
    }

    private fun enterButtonAction() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (email.isNotBlank() && password.isNotBlank()) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                navigationHelper.navigateTo(Routes.HOME, findNavController())
            }
            else {
                Toast.makeText(context, R.string.not_validate_email, Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(context, R.string.not_filled, Toast.LENGTH_SHORT).show()
        }
    }
}