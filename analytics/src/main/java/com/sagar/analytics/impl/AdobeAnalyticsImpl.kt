package com.sagar.analytics.impl

import android.app.Activity
import android.app.Application
import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty
import com.sagar.analytics.contracts.AdobeAnalytics

//TODO: Uncomment after adding the dependencies.
class AdobeAnalyticsImpl(
	private val application: Application,
	private val adobeKey: String,
	override var analyticsEnabled: Boolean
) : AdobeAnalytics {

	fun initAdobeAnalytics() {
		if (analyticsEnabled) {
			/*MobileCore.setApplication(application)
			MobileCore.setLogLevel(LoggingMode.DEBUG)

			try {
				AdobeBranchExtension.registerExtension(application.baseContext)
				com.adobe.marketing.mobile.Analytics.registerExtension()
				Assurance.registerExtension()
				com.adobe.marketing.mobile.edge.identity.Identity.registerExtension()
				Identity.registerExtension()
				Lifecycle.registerExtension()
				Signal.registerExtension()
				UserProfile.registerExtension()

				MobileCore.start {
					MobileCore.configureWithAppID(adobeKey)
				}
			} catch (e: InvalidInitException) {
				Timber.e(e, "InvalidInitException in registering Adobe Mobile Core")
			} catch (e: Exception) {
				Timber.e(e, "Unknown exception in registering Adobe Mobile Core")
			}*/
		}
	}


	override fun sendActionEvent(event: AnalyticsEvent) {
		if (analyticsEnabled) {
			/*Timber.d("TrackEvent: eventKey=${event.eventName} bundle=${event.params}")
			MobileCore.trackAction(event.eventName, event.params.toStringKeyValueMap())*/
		}
	}

	override fun sendPageNavigationEvent(event: AnalyticsEvent) {
		if (analyticsEnabled) {
			/*val extraDataWithValuesAsStrings = HashMap<String, String>().also {
				it.putAll(event.params.entries.map { entry -> entry.key.value to entry.value.toString() })
			}
			MobileCore.trackState(event.eventName, extraDataWithValuesAsStrings)*/
		}
	}

	override fun setUserProperty(property: AnalyticsProperty) {}

	override fun collectLifecycleData(activity: Activity) {
		if (analyticsEnabled) {
			/*Timber.d("onResume - resume collecting lifecycle data on activity=$activity")
			MobileCore.lifecycleStart(null)*/
		}
	}

	override fun pauseCollectingLifecycleData(activity: Activity) {
		if (analyticsEnabled) {
			/*Timber.d("onPause - pause collecting lifecycle data on activity=$activity")
			MobileCore.lifecyclePause()*/
		}
	}

}