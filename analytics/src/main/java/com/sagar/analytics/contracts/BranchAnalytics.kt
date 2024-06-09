package com.sagar.analytics.contracts

import com.sagar.analytics.base.AnalyticsEvent

interface BranchAnalytics: Analytics {
	override fun sendActionEvent(event: AnalyticsEvent)
}