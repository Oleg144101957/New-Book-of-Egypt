package book.egypt.advanture.data

import android.content.Context
import book.egypt.advanture.ui.theme.Constants
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AppsData(private val context: Context) {

    suspend fun getApps(): MutableMap<String, Any>? = suspendCoroutine { continuation ->

        val devKey = Constants.appsDevList[0]+Constants.appsDevList[1]+Constants.appsDevList[2]+Constants.appsDevList[3]

        AppsFlyerLib.getInstance()
            .init(devKey, CustomAppsListener{
                continuation.resume(it)
            }, context).start(context)
    }
}

class CustomAppsListener(private val onReceiveValue : (MutableMap<String, Any>?) -> Unit) :
    AppsFlyerConversionListener {
    override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
        onReceiveValue(data)
    }

    override fun onConversionDataFail(p0: String?) {
        onReceiveValue(null)
    }

    override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        onReceiveValue(null)
    }

    override fun onAttributionFailure(p0: String?) {
        onReceiveValue(null)
    }
}