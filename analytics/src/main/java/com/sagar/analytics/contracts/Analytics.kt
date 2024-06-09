package com.sagar.analytics.contracts

import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty

interface Analytics {
	var analyticsEnabled: Boolean

	fun sendActionEvent(event: AnalyticsEvent)

	fun setUserProperty(property: AnalyticsProperty)

}