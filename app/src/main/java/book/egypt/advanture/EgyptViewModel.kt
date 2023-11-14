package book.egypt.advanture

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import book.egypt.advanture.data.TrackProvider
import book.egypt.advanture.ui.theme.Constants
import kotlinx.coroutines.launch

class EgyptViewModel : ViewModel() {

    val destination: MutableLiveData<String> = MutableLiveData(Constants.appsDevList[0])

    fun addDataIntoTheViewModel(data: String){
        destination.value = data
    }

    fun buildLink(context: Context) {
        val trackProvider = TrackProvider(context)
        viewModelScope.launch {
            trackProvider.createLink(this@EgyptViewModel)
        }
    }
}