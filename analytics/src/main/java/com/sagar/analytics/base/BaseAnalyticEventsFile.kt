package com.sagar.analytics.base

import com.sagar.analytics.constants.AnalyticConstants

/**
 * Use this to construct a NavigateState object which can then be sent using AnalyticSender,
 * @param toScreen this is a state/screen name where we are navigated to.
 * @param fromScreen this is a state/screen name where we have navigated from, its known as previousPage in old code.
 * @param department its the department of the currently navigated screen.
 */
class NavigatePageEvent(
	toScreen: AnalyticConstants.Page,
	fromScreen: AnalyticConstants.Page? = null,
	department: AnalyticConstants.Department
) : AnalyticsEvent(
	eventName = toScreen.value,
	providers = arrayListOf(AnalyticsProvider.ADOBE_ANALYTICS)
) {
	//In the init block we can add all the base params which needs to be sent in along with all the events.
	init {
		fromScreen?.let {
			params[AnalyticConstants.ContextDataKey.PREVIOUS_PAGE] = it
		}
		params[AnalyticConstants.ContextDataKey.DEPARTMENT] = department.value
		params[AnalyticConstants.ContextDataKey.APP] = AnalyticConstants.ContextDataValue.APP.value
		params[AnalyticConstants.ContextDataKey.SET_EVENT] = toScreen.value
	}
}

class ActionEvent(
	action: AnalyticConstants.Action,
	pageName: AnalyticConstants.Page? = null,
	department: AnalyticConstants.Department? = null
) : AnalyticsEvent(
	eventName = action.value,
	providers = arrayListOf(AnalyticsProvider.ADOBE_ANALYTICS)
) {
	init {
		pageName?.let {
			params[AnalyticConstants.ContextDataKey.PAGE_NAME] = it
		}
		department?.let {
			params[AnalyticConstants.ContextDataKey.DEPARTMENT] = department.value
		}
	}
}

class UserProperty(
	key: AnalyticConstants.PropertyKey,
	value: Any,
	department: AnalyticConstants.Department? = null
) : AnalyticsProperty(
	key,
	value,
	providers = arrayListOf(AnalyticsProvider.FIREBASE_ANALYTICS)
)
