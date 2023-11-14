package book.egypt.advanture.data

import android.content.Context
import book.egypt.advanture.EgyptViewModel
import book.egypt.advanture.ui.theme.Constants
import com.onesignal.OneSignal

class TrackProvider(context: Context) {

    val appsData = AppsData(context)
    val fbData = FBData(context)
    val google = GoogleData(context)

    suspend fun createLink(egyptViewModel: EgyptViewModel){
        val a = appsData.getApps()
        val f = fbData.getFacebook()
        val g = google.getGaid()

        OneSignal.setExternalUserId(g)

        val subsList : List<String> = f.substringAfter("://")
            .split('_')
            .filter { it.startsWith("sub") }
            .map { it.substringAfter("=") }


        val af_channel: String = a?.getOrDefault(Constants.listOfNamesApps[0], "null").toString()
        val adset: String = a?.getOrDefault(Constants.listOfNamesApps[1], "null").toString()
        val media_source: String = a?.getOrDefault(Constants.listOfNamesApps[2], "null").toString()
        val af_status: String = a?.getOrDefault(Constants.listOfNamesApps[3], "null").toString()
        val af_ad: String = a?.getOrDefault(Constants.listOfNamesApps[4], "null").toString()
        val campaign_id: String = a?.getOrDefault(Constants.listOfNamesApps[5], "null").toString()
        val adset_id: String = a?.getOrDefault(Constants.listOfNamesApps[6], "null").toString()
        val ad_id: String = a?.getOrDefault(Constants.listOfNamesApps[7], "null").toString()

        //Send Tag to the Signal
        val sub1 = subsList.getOrNull(0) ?: "null"
        OneSignal.sendTag("sub1", sub1)

        val sub2 = subsList.getOrNull(1)

        val mainPart = Constants.oneList[4]+Constants.oneList[5]+Constants.oneList[6]+Constants.oneList[7]
        val sb = StringBuilder(mainPart)

        if (sub2 != null && af_status != "Organic"){
            sb.append("$sub2?")
            sb.append("af_channel=$af_channel&")
            sb.append("adset=$adset&")
            sb.append("media_source=$media_source&")
            sb.append("af_status=$af_status&")
            sb.append("af_ad=$af_ad&")
            sb.append("campaign_id=$campaign_id&")
            sb.append("adset_id=$adset_id&")
            sb.append("ad_id=$ad_id&")
            sb.append("sub3=${subsList.getOrNull(2)}")
            sb.append("sub4=${subsList.getOrNull(3)}")
            sb.append("sub5=${subsList.getOrNull(4)}")
            sb.append("sub6=${subsList.getOrNull(5)}")
            sb.append("sub7=${subsList.getOrNull(6)}")
            sb.append("sub8=${subsList.getOrNull(7)}")
            sb.append("sub9=${subsList.getOrNull(8)}")
            sb.append("sub10=${subsList.getOrNull(9)}")

            egyptViewModel.addDataIntoTheViewModel(sb.toString())

        } else if(sub2 == null && af_status != "Organic"){
            sb.append(Constants.oneList[8])
            egyptViewModel.addDataIntoTheViewModel(sb.toString())
        } else {
            egyptViewModel.addDataIntoTheViewModel(Constants.oneList[3])
        }
    }
}