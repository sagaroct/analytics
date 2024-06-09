package com.sagar.analytics.contracts


interface FirebaseAnalytics : Analytics {

	/**
	 * Sets whether analytics collection is enabled for this app on this device. This setting is persisted across app
	 * sessions. By default it is enabled.
	 *
	 * @param enabled The [Boolean] expression of whether to enable or disabled tracking
	 *
	 * @see [FirebaseAnalytics.setAnalyticsCollectionEnabled]
	 */
	fun setAnalyticsCollectionEnabled(enabled: Boolean)
}