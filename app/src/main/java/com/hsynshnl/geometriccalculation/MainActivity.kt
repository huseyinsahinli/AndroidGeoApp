package com.hsynshnl.geometriccalculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.hsynshnl.geometriccalculation.Circle.MainCircleActivity
import com.hsynshnl.geometriccalculation.Cube.MainCubeActivity
import com.hsynshnl.geometriccalculation.Cylinder.MainCylinderActivity
import com.hsynshnl.geometriccalculation.Ellipse.MainEllipseActivity
import com.hsynshnl.geometriccalculation.EquilateralQuadrangle.MainEquilateralQuadrangleActivity
import com.hsynshnl.geometriccalculation.Parallel.MainParallelActivity
import com.hsynshnl.geometriccalculation.Parallelogram.MainParallelogramActivity
import com.hsynshnl.geometriccalculation.Polygon.MainPolygonActivity

import com.hsynshnl.geometriccalculation.Quadrilateral.MainQuadrilateralActivity
import com.hsynshnl.geometriccalculation.Rectangle.MainRectangleActivity
import com.hsynshnl.geometriccalculation.Sphere.MainSphereActivity
import com.hsynshnl.geometriccalculation.Square.MainSquareActivity
import com.hsynshnl.geometriccalculation.Trapezoid.MainTrapezoidActivity
import com.hsynshnl.geometriccalculation.Triangle.MainTriangleActivity
import com.hsynshnl.geometriccalculation.adapters.LanguageAdapter
import com.hsynshnl.geometriccalculation.model.LanguageItem
import kotlinx.android.synthetic.main.activity_main_triangle.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var arrayList: ArrayList<LanguageItem>? = null
    private var gridView: GridView? = null

    private var languageAdapters: LanguageAdapter? = null
    lateinit var mAdView: AdView

    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"
    private var counter:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter = 0
        loadIADS()
        setSupportActionBar(toolbar).apply {
            title = getString(R.string.app_name)
        }



        gridView = findViewById(R.id.my_grid_view_list)
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapters = LanguageAdapter(applicationContext, arrayList!!)
        gridView?.adapter = languageAdapters
        gridView?.onItemClickListener = this


        // MainMenu Banner ID ca-app-pub-1257535779017345/2964180584

        // MainMenu Banner TEST ID ca-app-pub-3940256099942544/6300978111
        // MainMenu Interstital TEST ID ca-app-pub-3940256099942544/1033173712
        MobileAds.initialize(this) {
            mAdView = findViewById(R.id.adView)
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)

        }

    }

    private fun setDataList(): ArrayList<LanguageItem> {
        var arrayList: ArrayList<LanguageItem> = ArrayList()

        arrayList.add((LanguageItem(R.drawable.uc, getString(R.string.Triangle))))
        arrayList.add((LanguageItem(R.drawable.ka, getString(R.string.Square))))
        arrayList.add((LanguageItem(R.drawable.dik, getString(R.string.Rectangle))))
        arrayList.add((LanguageItem(R.drawable.para, getString(R.string.Parallelogram))))
        arrayList.add((LanguageItem(R.drawable.yamuk, getString(R.string.Trapezoid))))
        arrayList.add((LanguageItem(R.drawable.dort, getString(R.string.Quadrilateral))))
        arrayList.add((LanguageItem(R.drawable.es, getString(R.string.Quadrangle))))
        arrayList.add((LanguageItem(R.drawable.cok, getString(R.string.Polygon))))
        arrayList.add((LanguageItem(R.drawable.dare, getString(R.string.Circle))))
        arrayList.add((LanguageItem(R.drawable.el, getString(R.string.Ellipse))))
        arrayList.add((LanguageItem(R.drawable.ku, getString(R.string.Sphere))))
        arrayList.add((LanguageItem(R.drawable.kp, getString(R.string.Cube))))
        arrayList.add((LanguageItem(R.drawable.palek, getString(R.string.Parallel))))
        arrayList.add((LanguageItem(R.drawable.cylender, getString(R.string.Cylinder))))



        return arrayList
    }

    val intents = arrayOf(
        MainTriangleActivity::class.java,
        MainSquareActivity::class.java,
        MainRectangleActivity::class.java,
        MainParallelogramActivity::class.java,
        MainTrapezoidActivity::class.java,
        MainQuadrilateralActivity::class.java,
        MainEquilateralQuadrangleActivity::class.java,
        MainPolygonActivity::class.java,
        MainCircleActivity::class.java,
        MainEllipseActivity::class.java,
        MainSphereActivity::class.java,
        MainCubeActivity::class.java,
        MainParallelActivity::class.java,
        MainCylinderActivity::class.java,



        )



    fun loadIADS(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-1257535779017345/2537639321", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
    }
    fun showIADS(){
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", " ad wasn't ready ")
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: LanguageItem = arrayList!!.get(position)
        val intent = Intent(this, intents[position])

        if (counter%3==0){
            showIADS()
        }
        counter++
        loadIADS()
        startActivity(intent)

    }


}