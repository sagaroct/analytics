package com.sagar.analytics.base

import com.sagar.analytics.constants.AnalyticConstants
import java.util.*
import kotlin.collections.ArrayList

/**
 * Super class for all the analytic events and analytic states.
 */
//TODO: Maybe we can rename this to PageEvent and create 1 more class as ActionEvent.
// This will allow us to convert eventName to specific enums like PageEvent and ActionEvent. Discuss with team.
abstract class AnalyticsEvent(
    val eventName: String,  // Name of the event
    val params: EnumMap<AnalyticConstants.ContextDataKey, Any> = EnumMap(AnalyticConstants.ContextDataKey::class.java), // Key values pair of params, where key- is a name of event
    val providers: ArrayList<AnalyticsProvider>
)
