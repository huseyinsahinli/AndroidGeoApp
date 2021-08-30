package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_quadrangle.*

class QuadrangleFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quadrangle, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_quadrangle_result.text ="a=0\t\th=0"+
            getString(R.string.Area) + ": \n" + getString(R.string.Perimeter) + ": "
        fragment_quadrangle_calculate.setOnClickListener {
            val number_a = fragment_quadrangle_number_a.text.toString().toIntOrNull()
            val number_h = fragment_quadrangle_number_h.text.toString().toIntOrNull()

            val result_are: Int
            val result_perimeter: Int
            if (number_a != null && number_h != null) {
                result_are = number_a * number_h
                result_perimeter = 4 * number_a
                fragment_quadrangle_result.text = "a=${number_a}\th=${number_h}\n"
                getString(R.string.Area) + ": ${result_are}\n" + getString(R.string.Perimeter) + ": ${result_perimeter}"
                fragment_quadrangle_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_quadrangle_number_h.text = Editable.Factory.getInstance().newEditable("")
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