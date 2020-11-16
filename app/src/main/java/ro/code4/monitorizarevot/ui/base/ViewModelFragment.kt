package ro.code4.monitorizarevot.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.ext.android.inject
import ro.code4.monitorizarevot.helper.clearUserPrefs
import ro.code4.monitorizarevot.helper.startActivityWithoutTrace
import ro.code4.monitorizarevot.interfaces.Layout
import ro.code4.monitorizarevot.interfaces.ViewModelSetter
import ro.code4.monitorizarevot.ui.login.LoginActivity

abstract class ViewModelFragment<out T : BaseViewModel> : BaseAnalyticsFragment(), Layout,
    ViewModelSetter<T> {
    lateinit var mContext: Context

    private val sharedPreferences: SharedPreferences by inject()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    fun handleAuthenticationError() {
        sharedPreferences.clearUserPrefs()

        activity?.startActivityWithoutTrace(activity = LoginActivity::class.java)
    }
}