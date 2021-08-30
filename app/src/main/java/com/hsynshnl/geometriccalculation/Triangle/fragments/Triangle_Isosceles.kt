package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_triangle__isosceles.*


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
        triangle_isosceles_result.setText("a=${0}\t\tb=${0}\n" + getString(R.string.Area) + ": \n" + getString(R.string.Height) + ": \n" + getString(R.string.Perimeter) + ": \n")
        triangle_isosceles_calculate.setOnClickListener {
            val a_number = triangle_isosceles_number_a.text.toString().toDoubleOrNull()
            val b_number = triangle_isosceles_number_b.text.toString().toDoubleOrNull()
            val h_number: Double
            val result_are: Double
            val result_height: Double
            val result_perimeter: Double
            if (a_number != null && b_number != null) {
                h_number = Math.pow(a_number, 2.0) - (Math.pow(b_number, 2.0) / 4)
                result_height = Math.sqrt(h_number)
                result_perimeter = (2 * a_number) + b_number
                result_are = (b_number * result_height) / 2
                triangle_isosceles_result.setText("a=${a_number}\t\tb=${b_number}\n\n" +
                        getString(R.string.Area) + ": ${result_are.format(2)}\n" + getString(R.string.Height) + ": ${
                    result_height.format(
                            2
                    )
                }\n" + getString(R.string.Perimeter) + ": ${result_perimeter.format(2)}\n")
                triangle_isosceles_number_a.text = Editable.Factory.getInstance().newEditable("")
                triangle_isosceles_number_b.text = Editable.Factory.getInstance().newEditable("")

            } else {
                Toast.makeText(
                        context?.applicationContext,
                        getString(R.string.ToastMessage),
                        Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

}