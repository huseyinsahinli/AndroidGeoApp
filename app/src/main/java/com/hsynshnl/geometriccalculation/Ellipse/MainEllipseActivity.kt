package com.hsynshnl.geometriccalculation.Ellipse

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
import kotlinx.android.synthetic.main.activity_main_trapezoid.*
import kotlinx.android.synthetic.main.activity_main_triangle.*
import kotlinx.android.synthetic.main.activity_main_triangle.toolbar

class MainEllipseActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ellipse)
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
            } else {
                setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
            }
        }
        text_view_result2.text =
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Perimeter) + ": "
        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_b = text_view_number_b.text.toString().toDoubleOrNull()

            var result_are: Double? = null
            var result_perimeter: Double? = null
            if (number_a != null && number_b != null) {
                result_are = number_a * number_b * 3.14
                result_perimeter =
                    3.14 * (3 * (number_a + number_b)) - Math.sqrt((3 * number_a + number_b) * (number_a + 3 * number_b))
                text_view_result2.text =
                    "π=3.14\na=${number_a}\tb=${number_b}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(
                        R.string.Perimeter
                    ) + ": ${result_perimeter.format(1)}"
                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
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