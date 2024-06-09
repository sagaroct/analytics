package com.example.modularanalytics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.modularanalytics.ui.theme.ModularAnalyticsTheme
import com.sagar.analytics.base.ActionEvent
import com.sagar.analytics.base.AnalyticsProvider
import com.sagar.analytics.base.NavigatePageEvent
import com.sagar.analytics.base.UserProperty
import com.sagar.analytics.constants.AnalyticConstants
import com.sagar.analytics.contracts.AnalyticSender
import com.sagar.analytics.impl.AdobeAnalyticsImpl
import com.sagar.analytics.impl.AnalyticsSenderImpl
import com.sagar.analytics.impl.FacebookAnalyticsImpl
import com.sagar.analytics.impl.FirebaseAnalyticsImpl

class MainActivity : ComponentActivity() {

	private val analyticSender: AnalyticSender = AnalyticsSenderImpl(
		firebaseAnalytics = FirebaseAnalyticsImpl(this, true),
		adobeAnalytics = AdobeAnalyticsImpl(this.application, "dummy key", true),
		facebookAnalytics = FacebookAnalyticsImpl(this, true)
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ModularAnalyticsTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					Greeting("Android")
				}
			}
		}
		sendDashboardContainerNavigationState()
		sendDummyNotificationAllowActionEvent()
		sendDummyActionEventWithMultipleAnalyticProviders()
		setDummyVehicleCountUserProperty()
	}


	fun sendDashboardContainerNavigationState() {
		val navigatePageEventToDashboardContainer = NavigatePageEvent(
			toScreen = AnalyticConstants.Page.DASHBOARD,
			fromScreen = AnalyticConstants.Page.STARTUP_SCREEN,
			department = AnalyticConstants.Department.DASHBOARD
		)
		analyticSender.sendPageNavigationEvent(navigatePageEventToDashboardContainer)
	}

	//TODO: Sending a dummy event/action here, which is just for reference and should be deleted later.
	fun sendDummyNotificationAllowActionEvent() {
		val dummyNotificationAllowActionEvent = ActionEvent(
			action = AnalyticConstants.Action.NOTIFICATION_OPT_IN_ALLOW,
			pageName = AnalyticConstants.Page.NOTIFICATION_OPT_IN_POPUP,
			department = AnalyticConstants.Department.STARTUP_SCREEN
		)
		dummyNotificationAllowActionEvent.params[AnalyticConstants.ContextDataKey.LINK_NAME] =
			AnalyticConstants.Action.NOTIFICATION_OPT_IN_ALLOW.value
		analyticSender.sendActionEvent(dummyNotificationAllowActionEvent)
	}

	fun sendDummyActionEventWithMultipleAnalyticProviders() {
		val dummyActionEvent = ActionEvent(
			action = AnalyticConstants.Action.NOTIFICATION_OPT_IN_ALLOW,
			pageName = AnalyticConstants.Page.NOTIFICATION_OPT_IN_POPUP,
			department = AnalyticConstants.Department.STARTUP_SCREEN
		)
		dummyActionEvent.params[AnalyticConstants.ContextDataKey.LINK_NAME] =
			AnalyticConstants.Action.NOTIFICATION_OPT_IN_ALLOW.value
		dummyActionEvent.providers.apply {
			add((AnalyticsProvider.FIREBASE_ANALYTICS))
			add((AnalyticsProvider.ADOBE_ANALYTICS))
		}
		analyticSender.sendActionEvent(dummyActionEvent)
	}

	fun setDummyVehicleCountUserProperty() {
		val dummyUserProperty = UserProperty(key = AnalyticConstants.PropertyKey.PROPERY_1, value = 5)
		analyticSender.setUserProperty(dummyUserProperty)
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	ModularAnalyticsTheme {
		Greeting("Android")
	}
}