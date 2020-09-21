package id.hardianadi.movieandshowlist.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.ui.list.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, HomeActivity::class.java)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            this@SplashActivity.finish()
        }, 2000)
    }
}