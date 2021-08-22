package com.hsynshnl.geometriccalculation.Cylinder

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
import kotlinx.android.synthetic.main.activity_main_cylinder.*
import kotlinx.android.synthetic.main.activity_main_triangle.toolbar

class MainCylinderActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cylinder)
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
        text_view_result2.text =
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": "
        calculate2.setOnClickListener {
            var number_r = text_view_number_r.text.toString().toDoubleOrNull()
            var number_h = text_view_number_h.text.toString().toDoubleOrNull()

            var result_are: Double? = null
            var result_volume: Double? = null
            if (number_r != null&&number_h!=null) {
                result_are = 2 *3.14* number_r*(number_h+number_r)
                result_volume = 3.14*Math.pow(number_r,2.0)*number_h
                text_view_result2.text =
                    "π=3.14\nr=${number_r}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(
                        R.string.Volume
                    ) + ": ${result_volume.format(1)}"
                text_view_number_r.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_h.text = Editable.Factory.getInstance().newEditable("")
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.PythagoreanSentenceFive),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        MobileAds.initialize(this) {
            mAdView = findViewById(R.id.adView)
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)

        }
    }
}