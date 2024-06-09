package com.sagar.analytics.contracts

import android.app.Activity
import com.sagar.analytics.base.AnalyticsEvent

interface AdobeAnalytics : Analytics {
	fun collectLifecycleData(activity: Activity)

	fun sendPageNavigationEvent(event: AnalyticsEvent)

	fun pauseCollectingLifecycleData(activity: Activity)
}