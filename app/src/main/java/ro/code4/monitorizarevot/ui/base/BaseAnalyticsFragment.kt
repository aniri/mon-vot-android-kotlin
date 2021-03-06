package ro.code4.monitorizarevot.ui.base

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.android.inject
import ro.code4.monitorizarevot.R
import ro.code4.monitorizarevot.interfaces.AnalyticsScreenName

abstract class BaseAnalyticsFragment<out T : BaseViewModel> : BaseFragment<T>(), AnalyticsScreenName {

    private val firebaseAnalytics: FirebaseAnalytics by inject()

    override fun onResume() {
        super.onResume()

        firebaseAnalytics.setCurrentScreen(activity!!, getString(screenName), null)
    }

    fun logAnalyticsEvent(event: String, eventData: Bundle) {
        firebaseAnalytics.logEvent(event, eventData)
    }
}