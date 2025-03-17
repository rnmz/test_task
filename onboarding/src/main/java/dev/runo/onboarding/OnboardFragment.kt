package dev.runo.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.runo.core.navigation.NavigationHelper
import dev.runo.core.navigation.Routes
import dev.runo.onboarding.databinding.FragmentOnboardBinding
import javax.inject.Inject


val Context.settingsStore by preferencesDataStore(name = "settings")

@AndroidEntryPoint
class OnboardFragment : Fragment(R.layout.fragment_onboard) {

    private lateinit var binding: FragmentOnboardBinding

    @Inject lateinit var navigationHelper: NavigationHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel by viewModels<OnboardViewModel>()
        if (viewmodel.isFirstEnter.value) {
            viewmodel.updateFirstEnter()
            navigationHelper.navigateTo(Routes.AUTH, findNavController())
        }
        binding.buttonNext.setOnClickListener {
            navigationHelper.navigateTo(Routes.AUTH, findNavController())
        }
    }
}