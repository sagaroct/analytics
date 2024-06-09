package com.sagar.analytics.impl

import android.content.Context
import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty
import com.sagar.analytics.contracts.FirebaseAnalytics
import com.sagar.analytics.utils.toBundle

/**
 * Concrete implementation of the Firebase Analytics.
 */
class FirebaseAnalyticsImpl(
	context: Context,
	override var analyticsEnabled: Boolean
): FirebaseAnalytics {

	private val firebaseAnalytics = com.google.firebase.analytics.FirebaseAnalytics.getInstance(context)

	override fun sendActionEvent(event: AnalyticsEvent) {
//		Timber.d("TrackEvent: enabled=$analyticsEnabled eventKey=${event.eventName} bundle=${event.params}")
		if (analyticsEnabled) {
			firebaseAnalytics.logEvent(event.eventName, event.params.toBundle())
		}
	}

	override fun setUserProperty(property: AnalyticsProperty) {
		if(analyticsEnabled){
			firebaseAnalytics.setUserProperty(property.key.value, property.value.toString())
		}
	}

	override
	fun setAnalyticsCollectionEnabled(enabled: Boolean) {
		firebaseAnalytics.setAnalyticsCollectionEnabled(enabled)
	}

}