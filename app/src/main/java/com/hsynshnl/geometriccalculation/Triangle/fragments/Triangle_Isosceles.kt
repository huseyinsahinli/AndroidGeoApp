package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_pythagorean_theorem.*
import kotlinx.android.synthetic.main.fragment_triangle__isosceles.*
import kotlinx.android.synthetic.main.fragment_triangle__isosceles.text_view_number_a
import kotlinx.android.synthetic.main.fragment_triangle__isosceles.text_view_number_b


class Triangle_Isosceles : Fragment() {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triangle__isosceles, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_view_result2.text =
            getString(R.string.Area) + ": \n" + getString(R.string.Height) + ": \n" + getString(R.string.Perimeter) + ": \n"

        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_b = text_view_number_b.text.toString().toDoubleOrNull()
            var number_h: Double? = null
            var result_are: Double? = null
            var result_height: Double? = null
            var result_perimeter: Double? = null
            if (number_a != null && number_b != null) {
                number_h = Math.pow(number_a, 2.0) - (Math.pow(number_b, 2.0) / 4)
                result_height = Math.sqrt(number_h)
                result_perimeter = (2 * number_a) + number_b
                result_are = (number_b * result_height) / 2
                text_view_result2.text ="a=${number_a}\tb=${number_b}\n"+
                    getString(R.string.Area) + ": ${result_are.format(2)}\n" + getString(R.string.Height) + ": ${
                        result_height.format(
                            2
                        )
                    }\n" + getString(R.string.Perimeter) + ": ${result_perimeter.format(2)}\n"

                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_b.text = Editable.Factory.getInstance().newEditable("")

            } else {
                Toast.makeText(
                    context?.applicationContext,
                    getString(R.string.PythagoreanSentenceFive),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

}