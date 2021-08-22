package com.hsynshnl.geometriccalculation.Parallel

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
import kotlinx.android.synthetic.main.activity_main_parallel.*
import kotlinx.android.synthetic.main.activity_main_trapezoid.*
import kotlinx.android.synthetic.main.activity_main_trapezoid.calculate2
import kotlinx.android.synthetic.main.activity_main_trapezoid.text_view_number_a
import kotlinx.android.synthetic.main.activity_main_trapezoid.text_view_number_b
import kotlinx.android.synthetic.main.activity_main_trapezoid.text_view_result2
import kotlinx.android.synthetic.main.activity_main_triangle.*
import kotlinx.android.synthetic.main.activity_main_triangle.toolbar

class MainParallelActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {


        fun Double.format(digits: Int) = "%.${digits}f".format(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_parallel)
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
            getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": \n" + getString(R.string.Diagonal) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": "
        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_b = text_view_number_b.text.toString().toDoubleOrNull()
            var number_c = text_view_number_c.text.toString().toDoubleOrNull()

            var result_are: Double? = null
            var result_diagonal: Double? = null
            var result_diagonal1: Double? = null
            var result_diagonal2: Double? = null
            var result_diagonal3: Double? = null
            var result_volume: Int? = null
            if (number_a != null && number_b != null && number_c != null) {
                result_are =
                    2 * ((number_a * number_b) + (number_b * number_c) + (number_a * number_c))
                result_volume = number_a.toInt() * number_b.toInt() * number_c.toInt()
                result_diagonal = Math.sqrt(
                    Math.pow(number_a, 2.0) + Math.pow(number_b, 2.0) + Math.pow(
                        number_c,
                        2.0
                    )
                )
                result_diagonal1 = Math.sqrt(Math.pow(number_a, 2.0) + Math.pow(number_c, 2.0))
                result_diagonal2 = Math.sqrt(Math.pow(number_b, 2.0) + Math.pow(number_c, 2.0))
                result_diagonal3 = Math.sqrt(Math.pow(number_a, 2.0) + Math.pow(number_b, 2.0))

                text_view_result2.text =
                    "a=${number_a}\tb=${number_b}\tc=${number_c}\n" + getString(R.string.Area) + ": ${result_are}\n" + getString(
                        R.string.Volume
                    ) + ": ${result_volume}\n" + getString(R.string.Diagonal) + " D: ${result_diagonal.format(2)}\n" + getString(
                        R.string.Diagonal
                    ) + " d1: ${result_diagonal1.format(2)}\n" + getString(R.string.Diagonal) + " d2: ${result_diagonal2.format(2)}\n" + getString(
                        R.string.Diagonal
                    ) + " d3: ${result_diagonal3.format(2)}"
                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_b.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_c.text = Editable.Factory.getInstance().newEditable("")
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