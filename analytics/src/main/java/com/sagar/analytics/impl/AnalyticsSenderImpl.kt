package com.sagar.analytics.impl

import android.app.Activity
import android.util.Log
import com.sagar.analytics.contracts.AdobeAnalytics
import com.sagar.analytics.contracts.AnalyticSender
import com.sagar.analytics.contracts.FacebookAnalytics
import com.sagar.analytics.base.AnalyticsEvent
import com.sagar.analytics.base.AnalyticsProperty
import com.sagar.analytics.base.AnalyticsProvider
import com.sagar.analytics.contracts.FirebaseAnalytics

class AnalyticsSenderImpl(
    private val firebaseAnalytics: FirebaseAnalytics,
    private val adobeAnalytics: AdobeAnalytics,
    private val facebookAnalytics: FacebookAnalytics,
): AnalyticSender {

    override fun sendActionEvent(event: AnalyticsEvent) {
        Log.d("AnalyticsSenderImpl","Event was sent: ${event.eventName}. Params: ${event.params}. Providers: ${event.providers}")
        if (event.providers.contains(AnalyticsProvider.FIREBASE_ANALYTICS)) {
            firebaseAnalytics.sendActionEvent(event)
        }
        if (event.providers.contains(AnalyticsProvider.ADOBE_ANALYTICS)) {
            adobeAnalytics.sendActionEvent(event)
        }
        if (event.providers.contains(AnalyticsProvider.FACEBOOK_ANALYTICS)) {
            facebookAnalytics.sendActionEvent(event)
        }
    }

    /**
     * The sendState(trackState) method needs to be called every time a new state is displayed in your application.
     * For example, when a user navigates from Garage to Dashboard.
     */
    override fun sendPageNavigationEvent(event: AnalyticsEvent) {
        Log.d("AnalyticsSenderImpl","Sate was sent: ${event.eventName}. Params: ${event.params}. Providers: ${event.providers}")
        if (event.providers.contains(AnalyticsProvider.ADOBE_ANALYTICS)) {
            adobeAnalytics.sendPageNavigationEvent(event)
        }
    }

    override fun setUserProperty(property: AnalyticsProperty) {
        Log.d("AnalyticsSenderImpl","Property was set: ${property.key}. Params: ${property.value}. Providers: ${property.providers}")
        if (property.providers.contains(AnalyticsProvider.FIREBASE_ANALYTICS)) {
            firebaseAnalytics.setUserProperty(property)
        }
        if (property.providers.contains(AnalyticsProvider.ADOBE_ANALYTICS)) {
            adobeAnalytics.setUserProperty(property)
        }
    }

    /** Should be called when base activity resumes */
    override fun collectLifecycleData(activity: Activity){
        adobeAnalytics.collectLifecycleData(activity)
    }

    /** Should be called when base activity goes to onPause */
    override fun pauseCollectingLifecycleData(activity: Activity){
        adobeAnalytics.pauseCollectingLifecycleData(activity)
    }

    override fun setAnalyticsCollectionEnabled(enabled: Boolean) {
        firebaseAnalytics.setAnalyticsCollectionEnabled(enabled)
    }

    override fun enableFacebookAnalytics() {
        facebookAnalytics.analyticsEnabled = true
        facebookAnalytics.initFacebookSdk()
    }

    override fun disableFacebookAnalytics() {
        facebookAnalytics.analyticsEnabled = false
        facebookAnalytics.disableFacebookSdk()
    }

}