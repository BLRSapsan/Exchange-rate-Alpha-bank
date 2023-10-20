package com.exchangeratealphabank.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.exchangeratealphabank.R
import com.exchangeratealphabank.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

const val TAGExchangeRate = "logirovanie"
class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity:ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)
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
            Snackbar.make(bindingMainActivity.mainSale, R.string.no_connection, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.repeat) {
                    connectionCheck()
                }
                .show()
        } else {
            viewPager = findViewById(R.id.pager)
            viewPager.adapter = ViewPagerFragments(this)
            TabLayoutMediator(bindingMainActivity.tabMode, bindingMainActivity.pager) { tab, position ->
                when (position) {
                    0 -> tab.setText(R.string.rate_alpha)
                    1 -> tab.setText(R.string.rate_national_bank)
                }
            }.attach()
        }
    }
}