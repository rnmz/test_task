package dev.runo.testtask

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.runo.core.navigation.NavigationHelper
import dev.runo.core.navigation.Routes
import dev.runo.testtask.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationHelper: NavigationHelper
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        navController = findNavController(R.id.nav_fragment_container)
        navController.graph = navigationHelper.createNavGraph(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.label != Routes.HOME) {
                binding.bottomNavBar.visibility = View.GONE
            }
            else {
                binding.bottomNavBar.visibility = View.VISIBLE
            }
        }
    }


}