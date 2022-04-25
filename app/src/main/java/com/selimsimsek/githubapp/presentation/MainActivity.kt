package com.selimsimsek.githubapp.presentation


import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.selimsimsek.githubapp.R
import com.selimsimsek.githubapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)


        binding.apply {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.splashFragment -> bottomNavigationView.isVisible = false
                    R.id.loginFragment -> bottomNavigationView.isVisible = false
                    R.id.webViewFragment -> bottomNavigationView.isVisible = false
                    R.id.searchFragment -> bottomNavigationView.isVisible = false

                    else -> {
                        bottomNavigationView.isVisible = true
                    }
                }


            }
        }


    }

    private fun loading() {
        dialog = Dialog(this)
        dialog!!.setContentView(R.layout.dialog_loading)
        dialog!!.setCancelable(true)
        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

    fun showDialog() {
        if (dialog == null) {
            loading()
        }
        dialog?.show()
    }

//    override fun onBackPressed() {
//        if (navController.currentBackStackEntry?.destination?.id == R.id.homeFragment &&
//            navController.previousBackStackEntry?.destination?.id == R.id.fragmentSplash ||
//            navController.previousBackStackEntry?.destination?.id == R.id.fragmentLogin
//        ) {
//
//            finish()
//        }
//        super.onBackPressed()
//    }
}