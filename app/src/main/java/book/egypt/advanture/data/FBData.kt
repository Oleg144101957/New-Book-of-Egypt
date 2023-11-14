package book.egypt.advanture.data

import android.content.Context
import com.facebook.applinks.AppLinkData
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FBData(private val context: Context){

    suspend fun getFacebook() : String = suspendCoroutine { continuation ->
        AppLinkData.fetchDeferredAppLinkData(context){
            continuation.resume(it?.targetUri.toString())
        }
    }


}