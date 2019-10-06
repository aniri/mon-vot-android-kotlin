package ro.code4.monitorizarevot.ui.splashscreen

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import ro.code4.monitorizarevot.R
import ro.code4.monitorizarevot.helper.getToken
import ro.code4.monitorizarevot.ui.base.BaseActivity
import ro.code4.monitorizarevot.ui.login.LoginActivity
import ro.code4.monitorizarevot.ui.main.MainActivity

class SplashscreenActivity: BaseActivity<SplashscreenViewModel>()  {
    private val sharedPreferences: SharedPreferences by inject()

    override val layout: Int
        get() = R.layout.activity_splashscreen
    override val viewModel: SplashscreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is logged in or not
        if (sharedPreferences.getToken() != null) {
            startMainActivity()
        } else {
            startLoginActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}