package com.hsynshnl.geometriccalculation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.hsynshnl.geometriccalculation.Triangle.TriangleListFragmentDirections
import com.hsynshnl.geometriccalculation.adapters.LanguageAdapter
import com.hsynshnl.geometriccalculation.model.LanguageItem
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(),AdapterView.OnItemClickListener {
    private var arrayList: ArrayList<LanguageItem>? = null
    private var gridView: GridView? = null

    private var languageAdapters: LanguageAdapter? = null


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }
    private fun setDataList(): ArrayList<LanguageItem> {
        var arrayList: ArrayList<LanguageItem> = ArrayList()

        arrayList.add((LanguageItem(R.drawable.main_triangle, getString(R.string.Triangle))))
        arrayList.add((LanguageItem(R.drawable.main_square, getString(R.string.Square))))
        arrayList.add((LanguageItem(R.drawable.main_rectangle, getString(R.string.Rectangle))))
        arrayList.add((LanguageItem(R.drawable.main_parallelogram, getString(R.string.Parallelogram))))
        arrayList.add((LanguageItem(R.drawable.main_trapezoid, getString(R.string.Trapezoid))))
        arrayList.add((LanguageItem(R.drawable.main_quadrilateral, getString(R.string.Quadrilateral))))
        arrayList.add((LanguageItem(R.drawable.main_quadrangle, getString(R.string.Quadrangle))))
        arrayList.add((LanguageItem(R.drawable.main_polygon, getString(R.string.Polygon))))
        arrayList.add((LanguageItem(R.drawable.main_circle, getString(R.string.Circle))))
        arrayList.add((LanguageItem(R.drawable.main_ellipse, getString(R.string.Ellipse))))
        arrayList.add((LanguageItem(R.drawable.main_sphere, getString(R.string.Sphere))))
        arrayList.add((LanguageItem(R.drawable.main_cube, getString(R.string.Cube))))
        arrayList.add((LanguageItem(R.drawable.main_parallel, getString(R.string.Parallel))))
        arrayList.add((LanguageItem(R.drawable.main_cylinder, getString(R.string.Cylinder))))



        return arrayList
    }
    val direction= MainFragmentDirections
    val fragments = arrayOf(
        direction.actionMainFragmentToNavTriangle(),
        direction.actionMainFragmentToSquareFragment(),
        direction.actionMainFragmentToRectangleFragment(),
        direction.actionMainFragmentToParallelogramFragment(),
        direction.actionMainFragmentToTrapezoidFragment(),
        direction.actionMainFragmentToQuadrilateralFragment(),
        direction.actionMainFragmentToQuadrangleFragment(),
        direction.actionMainFragmentToPolygonFragment(),
        direction.actionMainFragmentToCircleFragment(),
        direction.actionMainFragmentToEllipseFragment(),
        direction.actionMainFragmentToSphereFragment(),
        direction.actionMainFragmentToCubeFragment(),
        direction.actionMainFragmentToParallelFragment(),
        direction.actionMainFragmentToCylinderFragment()

        )




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridView = my_grid_view_list
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapters = LanguageAdapter(context?.applicationContext!!, arrayList!!)
        gridView?.adapter = languageAdapters
        gridView?.onItemClickListener = this

    }
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val action=fragments[position]
        if (parent != null) {
            Navigation.findNavController(parent).navigate(action)
        }
    }
}