package com.sagar.analytics.impl

import android.content.Context
import com.facebook.BuildConfig
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsLogger
import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty
import com.sagar.analytics.contracts.FacebookAnalytics

class FacebookAnalyticsImpl(
	context: Context,
	override var analyticsEnabled: Boolean
): FacebookAnalytics {

	private val fbTracker: AppEventsLogger = AppEventsLogger.newLogger(context)

	override fun initFacebookSdk() {
		FacebookSdk.setAutoLogAppEventsEnabled(true)
		FacebookSdk.setAdvertiserIDCollectionEnabled(true)
		FacebookSdk.setAutoInitEnabled(true)
		FacebookSdk.fullyInitialize()

		if (BuildConfig.DEBUG) {
			/*
			* Enable debug logs to verify App Event usage from the client side.
			* The debug logs contain detailed requests and JSON responses. */
			FacebookSdk.setIsDebugEnabled(true)
			FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS)
		} else {
			FacebookSdk.setIsDebugEnabled(false)
		}
	}

	override fun disableFacebookSdk() {
		FacebookSdk.setAutoLogAppEventsEnabled(false)
		FacebookSdk.setAdvertiserIDCollectionEnabled(false)
		FacebookSdk.setAutoInitEnabled(false)
		FacebookSdk.setIsDebugEnabled(false)
	}

	override fun sendActionEvent(event: AnalyticsEvent) {
		if(analyticsEnabled) {
			fbTracker.logEvent(event.eventName)
		}
	}

	override fun setUserProperty(property: AnalyticsProperty) {}


}