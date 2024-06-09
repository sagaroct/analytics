package com.sagar.analytics.contracts

import android.app.Activity
import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty

interface AnalyticSender {

	/**
	 * We can also use this for trackAction events.
	 */
	fun sendActionEvent(event: AnalyticsEvent)

	/**
	 * The sendState(trackState) method needs to be called every time a new state is displayed in your application.
	 * For example, when a user navigates from Garage to Dashboard.
	 */
	fun sendPageNavigationEvent(event: AnalyticsEvent)

	fun setUserProperty(property: AnalyticsProperty)

	//TODO: Below functions are known to be called only for specific analytic sdk, hence we are not passing a parameter like AnalyticsEvent or AnalyticsProperty.
	fun collectLifecycleData(activity: Activity)

	fun pauseCollectingLifecycleData(activity: Activity)

	fun setAnalyticsCollectionEnabled(enabled: Boolean)

	fun enableFacebookAnalytics()

	fun disableFacebookAnalytics()
}