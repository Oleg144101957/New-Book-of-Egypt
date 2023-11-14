package book.egypt.advanture.data

import android.content.Context
import book.egypt.advanture.ui.theme.Constants

class EgyptStorage(context: Context) {

    private val sp = context.getSharedPreferences(Constants.SHARED, Context.MODE_PRIVATE)

    fun saveData(data: String){
        sp.edit().putString(Constants.fbApIdList[0], data).apply()
    }

    fun readData(): String{
        return sp.getString(Constants.fbApIdList[0], Constants.appsDevList[0]) ?: Constants.appsDevList[0]
    }
}