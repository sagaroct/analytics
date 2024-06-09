package com.sagar.analytics.contracts

interface FacebookAnalytics: Analytics {
	fun initFacebookSdk()

	fun disableFacebookSdk()
}