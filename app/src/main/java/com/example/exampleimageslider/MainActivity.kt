package com.example.exampleimageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.exampleimageslider.databinding.ActivityMainBinding
import com.google.android.material.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            ImageData(
                "https://plus.unsplash.com/premium_photo-1674916018213-5948cfbe03c0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=921&q=80"
            )
        )
        list.add(
            ImageData(
                "https://images.unsplash.com/photo-1682686580186-b55d2a91053c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=775&q=80"
            )
        )
        list.add(
            ImageData(
                "https://images.unsplash.com/photo-1683918075940-d50beff75d16?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })

    }

    private fun selectedDot(position: Int) {
        for (i in 0 until list.size) {
            if (i == position)
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.design_default_color_primary))
            else
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.design_default_color_secondary))

        }

    }

    private fun setIndicator() {
        for (i in 0 until list.size) {
            dots.add(TextView(this))
            dots[i].text= Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()

            dots[i].textSize = 18f
            binding.indicator.addView(dots[i])
        }

    }
}