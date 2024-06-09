package com.sagar.analytics.contracts

import android.app.Application
import com.sagar.analytics.base.AnalyticsEvent

interface ApptentiveAnalytics: Analytics {
	override fun sendActionEvent(event: AnalyticsEvent)

	fun register(application: Application, key: String, signature: String)

}