package book.egypt.advanture.data

import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GoogleData(private val context: Context){
    suspend fun getGaid() : String = withContext(Dispatchers.IO){
        AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
    }
}