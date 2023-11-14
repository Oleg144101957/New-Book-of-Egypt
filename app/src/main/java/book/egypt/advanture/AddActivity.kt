package book.egypt.advanture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import book.egypt.advanture.databinding.ActivityAddBinding
import book.egypt.advanture.ui.theme.Constants

class AddActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraFromIntent = intent.getStringExtra(Constants.fbToken[0]) ?: "empty intent"

        binding.tvElement.text = extraFromIntent
    }

}