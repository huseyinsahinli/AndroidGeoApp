package com.hsynshnl.geometriccalculation.Polygon

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
import kotlinx.android.synthetic.main.activity_main_polygon.*
import kotlinx.android.synthetic.main.activity_main_polygon.calculate2
import kotlinx.android.synthetic.main.activity_main_polygon.text_view_number_a
import kotlinx.android.synthetic.main.activity_main_polygon.text_view_result2
import kotlinx.android.synthetic.main.activity_main_quadrilateral.*
import kotlinx.android.synthetic.main.activity_main_trapezoid.*
import kotlinx.android.synthetic.main.activity_main_triangle.*
import kotlinx.android.synthetic.main.activity_main_triangle.toolbar
import kotlin.math.tan
import kotlinx.android.synthetic.main.activity_main_trapezoid.text_view_number_a as text_view_number_a1

class MainPolygonActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_polygon)
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
        text_view_result2.text = getString(R.string.Area) + ": \n"+getString(R.string.Perimeter)+": "
        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toIntOrNull()
            var number_n = text_view_number_n.text.toString().toIntOrNull()

            var result_are:Double?=null
            var result_perimeter:Int?=null
            if (number_a!=null&&number_n!=null){
                result_perimeter=number_a*number_n
                result_are=(number_n.toDouble()*Math.pow(number_a.toDouble(),2.0))/(4* tan(Math.toRadians(180/number_n.toDouble())))
                text_view_result2.text = "a=${number_a}\tn=${number_n}\n"+getString(R.string.Area) + ": ${result_are.toInt()}\n"+getString(R.string.Perimeter)+": ${result_perimeter}"
                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_n.text = Editable.Factory.getInstance().newEditable("")
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