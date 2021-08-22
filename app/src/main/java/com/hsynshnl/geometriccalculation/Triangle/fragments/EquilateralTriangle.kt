package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_equilateral_triangle.calculate2
import kotlinx.android.synthetic.main.fragment_equilateral_triangle.text_view_number_a
import kotlinx.android.synthetic.main.fragment_equilateral_triangle.text_view_result2
import kotlinx.android.synthetic.main.fragment_triangle__isosceles.*

class EquilateralTriangle : Fragment() {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equilateral_triangle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_view_result2.text =
            getString(R.string.Area) + ": \n" + getString(R.string.Height) + ": \n"+getString(R.string.Perimeter)+": \n"

        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_h:Double?=null
            var result_are:Double?=null
            var result_height:Double?=null
            var result_perimeter:Double?=null
            if (number_a!=null){
                result_are=(Math.sqrt(3.0)/4)*Math.pow(number_a,2.0)


                result_height=(number_a*Math.sqrt(3.0))/2
                result_perimeter=number_a*3
                text_view_result2.text ="a=${number_a}\n"+
                    getString(R.string.Area) + ": ${result_are.format(2)}\n" + getString(R.string.Height) + ": ${
                        result_height.format(
                            2
                        )
                    }\n" + getString(R.string.Perimeter) + ": ${result_perimeter.format(2)}\n"
                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")


            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFive), Toast.LENGTH_SHORT).show()
            }
        }
    }

}