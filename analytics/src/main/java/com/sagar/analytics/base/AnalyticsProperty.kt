package com.sagar.analytics.base

import com.sagar.analytics.constants.AnalyticConstants


abstract class AnalyticsProperty(
    val key: AnalyticConstants.PropertyKey,
    val value: Any,
    val providers: ArrayList<AnalyticsProvider>
)
