package com.sagar.analytics.utils

import android.os.Bundle
import com.sagar.analytics.constants.AnalyticConstants
import org.json.JSONObject

fun Map<AnalyticConstants.ContextDataKey, Any?>.toBundle(): Bundle {
    val bundle = Bundle()
    filter { (_, value) -> value != null }
        .forEach { (key, value) -> bundle.putString(key.value, value.toString()) }
    return bundle
}

fun Map<AnalyticConstants.ContextDataKey, Any>.toStringKeyMap(): Map<String, Any> {
    val extraDataWithKeyAsStrings = HashMap<String, Any>()
    extraDataWithKeyAsStrings.putAll(entries.map { entry -> entry.key.value to entry.value})
    return extraDataWithKeyAsStrings
}

fun Map<AnalyticConstants.ContextDataKey, Any>.toStringKeyValueMap(): Map<String, String> {
    val extraData = HashMap<String, String>()
    extraData.putAll(entries.map { entry -> entry.key.value to entry.value.toString()})
    return extraData
}

fun Map<String, Any?>.toJson(): JSONObject {
    val jsonObject = JSONObject()
    filter { (_, value) -> value != null }
        .forEach { (key, value) -> jsonObject.put(key, value) }
    return jsonObject
}