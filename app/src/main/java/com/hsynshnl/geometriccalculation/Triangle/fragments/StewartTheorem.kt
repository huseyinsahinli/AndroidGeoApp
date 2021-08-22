package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_pythagorean_theorem.*
import kotlinx.android.synthetic.main.fragment_pythagorean_theorem.text_view_number_a
import kotlinx.android.synthetic.main.fragment_stewart_theorem.*
import kotlinx.android.synthetic.main.fragment_stewart_theorem.calculate2
import kotlinx.android.synthetic.main.fragment_stewart_theorem.text_view_number_b
import kotlinx.android.synthetic.main.fragment_stewart_theorem.text_view_number_c
import kotlinx.android.synthetic.main.fragment_stewart_theorem.text_view_result2
import kotlinx.android.synthetic.main.fragment_triangle__inscribedcircle.*

class StewartTheorem : Fragment() {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stewart_theorem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_view_result2.text="x = \nx² ="

        calculate2.setOnClickListener {

            var numberb = text_view_number_b.text.toString().toDoubleOrNull()
            var numberc = text_view_number_c.text.toString().toDoubleOrNull()
            var numberm = text_view_number_m.text.toString().toDoubleOrNull()
            var numbern = text_view_number_n.text.toString().toDoubleOrNull()
            if (numberb==null||numberc==null||numberm==null||numbern==null){
                text_view_result2.text=getString(R.string.StewartTheoremSentenceOne)
            }
            else{
                var powerNumberB=Math.pow(numberb, 2.0)
                var powerNumberC=Math.pow(numberc, 2.0)

                var result=((powerNumberB*numberm)+(powerNumberC*numbern)/numberm+numbern)-numberm*numbern
                var resultsqrt=Math.sqrt(result)
                text_view_result2.text="b=${numberb}\tc=${numberc}\tm=${numberm}\tn=${numbern}\n"+getString(R.string.Result)+"\nx = ${resultsqrt.format(2)}\nx² = ${result.format(2)}"

                text_view_number_b.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_c.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_n.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_m.text = Editable.Factory.getInstance().newEditable("")
            }
        }


    }
}