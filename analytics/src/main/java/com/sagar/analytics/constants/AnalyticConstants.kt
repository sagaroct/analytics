package com.sagar.analytics.constants


object AnalyticConstants {

	enum class Page(val value: String) {
		STARTUP_SCREEN("Main Page"),
		DASHBOARD("Dashboard"),
		NOTIFICATION_OPT_IN_POPUP("notification_opt_in_popup"),

	}

	enum class Department(val value: String) {
		DASHBOARD("Dashboard"),
		STARTUP_SCREEN("Main Page"),
	}

	enum class Action(val value: String) {
		NOTIFICATION_OPT_IN_ALLOW("notificationoptinclick"),
	}

	enum class ContextDataKey(val value: String) {
		APP("app"),
		DEPARTMENT("department"),
		PAGE_NAME("pagename"),
		PREVIOUS_PAGE("previouspage"),
		SET_EVENT("setevent"),
		LINK_NAME("linkname"),
	}

	enum class ContextDataValue(val value: String) {
		APP("App - Android"),
	}

	enum class PropertyKey(val value: String) {
		PROPERY_1("propery_1")
	}

}