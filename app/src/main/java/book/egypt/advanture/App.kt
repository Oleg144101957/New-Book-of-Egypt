package book.egypt.advanture

import android.app.Application
import book.egypt.advanture.ui.theme.Constants
import com.onesignal.OneSignal

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val one = Constants.oneList[0]+Constants.oneList[1]+Constants.oneList[2]

        OneSignal.initWithContext(this)
        OneSignal.setAppId(one)
    }
}