package book.egypt.advanture

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import book.egypt.advanture.ui.theme.Constants
import book.egypt.advanture.ui.theme.NavigationBlock
import book.egypt.advanture.ui.theme.NewBookOfEgyptTheme

class MainActivity : ComponentActivity() {

    private val egyptViewModel by viewModels<EgyptViewModel>()

    val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        //do some work
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermission()
        setContent {
            NewBookOfEgyptTheme {
                NavigationBlock(egyptViewModel)
            }
        }
    }

    private fun requestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission = android.Manifest.permission.POST_NOTIFICATIONS
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                //do some work
            } else requestPermissionLauncher.launch(permission)
        } else {
            //do some work
        }
    }

    companion object{
        fun navigateToAddActivity(context: Context, destination: String){
            val intent = Intent(context, AddActivity::class.java)
            intent.putExtra(Constants.fbToken[0], destination)
            context.startActivity(intent)
        }
    }
}

