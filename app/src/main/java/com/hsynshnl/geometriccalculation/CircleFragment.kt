package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_circle.*

class CircleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circle, container, false)
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragment_circle_result.setText(
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Perimeter) + ": \n" + getString(
                R.string.InscribedcircleSentenceTwo
            ) + ": "
        )
        fragment_circle_calculate.setOnClickListener {
            val r_number = fragment_circle_number_r.text.toString().toDoubleOrNull()
            val result_are: Double
            val result_diameter: Double
            val result_perimeter: Double
            if (r_number != null) {
                result_are = Math.pow(r_number, 2.0) * 3.14
                result_diameter = 2 * r_number
                result_perimeter = 2 * r_number * 3.14
                fragment_circle_result.setText(
                    "π=3.14\na=${r_number}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(
                        R.string.Perimeter
                    ) + ": ${result_perimeter.format(1)}\n" + getString(R.string.InscribedcircleSentenceTwo) + ": ${result_diameter}"
                )
                fragment_circle_number_r.text = Editable.Factory.getInstance().newEditable("")
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