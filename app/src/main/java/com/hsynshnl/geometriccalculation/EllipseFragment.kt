package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ellipse.*

class EllipseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ellipse, container, false)
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_ellipse_result.setText(
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Perimeter) + ": ")
        fragment_ellipse_calculate.setOnClickListener {

            val number_a = fragment_ellipse_number_a.text.toString().toDoubleOrNull()
            val number_b = fragment_ellipse_number_b.text.toString().toDoubleOrNull()

            val result_are: Double
            val result_perimeter: Double
            if (number_a != null && number_b != null) {
                result_are = number_a * number_b * 3.14
                result_perimeter =
                    3.14 * (3 * (number_a + number_b)) - Math.sqrt((3 * number_a + number_b) * (number_a + 3 * number_b))
                fragment_ellipse_result.setText(
                    "π=3.14\na=${number_a}\tb=${number_b}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(R.string.Perimeter) + ": ${result_perimeter.format(1)}")
                fragment_ellipse_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_ellipse_number_b.text = Editable.Factory.getInstance().newEditable("")
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