package com.exchangeratealphabank.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.exchangeratealphabank.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

const val TAGExchangeRate = "logirovanie"
class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectionCheck()
    }

    //проверка соединения с WiFi или Internet с возвратом true/false
    fun isOnline(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true
    }

    fun connectionCheck() {
        if (!isOnline()) {
            Snackbar.make(main_sale, R.string.no_connection, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.repeat) {
                    connectionCheck()
                }
                .show()
        } else {
            viewPager = findViewById(R.id.pager)
            viewPager.adapter = ViewPagerFragments(this)
            TabLayoutMediator(tabMode, pager) { tab, position ->
                when (position) {
                    0 -> tab.setText(R.string.rate_alpha)
                    1 -> tab.setText(R.string.rate_national_bank)
                }
            }.attach()
        }
    }
}