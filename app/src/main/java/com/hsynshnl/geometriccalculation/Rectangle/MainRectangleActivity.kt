package com.hsynshnl.geometriccalculation.Rectangle

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.activity_main_rectangle.*
import kotlinx.android.synthetic.main.activity_main_rectangle.calculate2
import kotlinx.android.synthetic.main.activity_main_rectangle.text_view_number_a
import kotlinx.android.synthetic.main.activity_main_rectangle.text_view_result2
import kotlinx.android.synthetic.main.activity_main_trapezoid.*
import kotlinx.android.synthetic.main.activity_main_triangle.*
import kotlinx.android.synthetic.main.activity_main_triangle.toolbar
import kotlinx.android.synthetic.main.activity_main_rectangle.text_view_number_b as text_view_number_b1

class MainRectangleActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_rectangle)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)

            // show back button on toolbar
            // on back button press, it will navigate to parent activity
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        toolbar.navigationIcon?.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                colorFilter = BlendModeColorFilter(Color.WHITE, BlendMode.SRC_IN)
            }else{
                setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
            }
        }
        text_view_result2.text = getString(R.string.Area) + ": \n"+getString(R.string.Perimeter)+": \n"+getString(R.string.Diagonal)+": "
        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toIntOrNull()
            var number_b = text_view_number_b.text.toString().toIntOrNull()

            var result_are:Int?=null
            var result_diagonal:Double?=null
            var result_perimeter:Int?=null
            if (number_a!=null&&number_b!=null){
                result_are=number_a*number_b
                result_diagonal=Math.sqrt((number_a*number_a).toDouble()+(number_b*number_b).toDouble())
                result_perimeter=2*(number_a+number_b)
                text_view_result2.text ="a=${number_a}\tb=${number_b}\n"+getString(R.string.Area) + ": ${result_are}\n"+getString(R.string.Perimeter)+": ${result_perimeter}\n"+getString(R.string.Diagonal)+": ${result_diagonal.toInt()}√2"
                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_b.text = Editable.Factory.getInstance().newEditable("")
            }else{
                Toast.makeText(this, getString(R.string.PythagoreanSentenceFive), Toast.LENGTH_SHORT).show()
            }
        }
        MobileAds.initialize(this) {
            mAdView = findViewById(R.id.adView)
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)

        }
    }
}