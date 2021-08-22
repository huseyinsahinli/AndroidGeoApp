package com.hsynshnl.geometriccalculation.Triangle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.hsynshnl.geometriccalculation.R
import com.hsynshnl.geometriccalculation.adapters.LanguageAdapter
import com.hsynshnl.geometriccalculation.model.LanguageItem
import kotlinx.android.synthetic.main.fragment_triangle_list.*


class TriangleListFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triangle_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val names= arrayOf(
            getString(R.string.Triangle)+" "+getString(R.string.Area),
            getString(R.string.PythagoreanTheorem),
            getString(R.string.EuclideanTheorem),
            getString(R.string.IsoscelesTriangle),
            getString(R.string.EquilateralTriangle),
            getString(R.string.Inscribedcircle),

            getString(R.string.StewartTheorem)
            )
        val direction=TriangleListFragmentDirections
        val fragments= arrayOf(
            direction.actionTriangleListFragmentToTriangleArea(),
            direction.actionTriangleListFragmentToPythagoreanTheorem(),
            direction.actionTriangleListFragmentToEuclideanTheorem(),
            direction.actionTriangleListFragmentToTriangleIsosceles(),
            direction.actionTriangleListFragmentToEquilateralTriangle(),
            direction.actionTriangleListFragmentToTriangleInscribedcircle(),

            direction.actionTriangleListFragmentToStewartTheorem()

        )

        val listView= listView
        listView.adapter = activity?.let {
            ArrayAdapter(
                it,
                R.layout.custom_list_item,
                R.id.formula_text,
                names
            )
        }
        listView.setOnItemClickListener { parent, view, position, id ->

            val action=fragments[position]
            Navigation.findNavController(parent).navigate(action)
        }
    }





}