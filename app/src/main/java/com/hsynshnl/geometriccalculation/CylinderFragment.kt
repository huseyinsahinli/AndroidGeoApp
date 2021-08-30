package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cylinder.*

class CylinderFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cylinder, container, false)
    }
    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_cylinder_result.setText(
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": "
        )
        fragment_cylinder_calcute.setOnClickListener {
            val number_r = fragment_cylinder_number_r.text.toString().toDoubleOrNull()
            val number_h = fragment_cylinder_number_h.text.toString().toDoubleOrNull()

            val result_are: Double
            val result_volume: Double
            if (number_r != null&&number_h!=null) {
                result_are = 2 *3.14* number_r*(number_h+number_r)
                result_volume = 3.14*Math.pow(number_r,2.0)*number_h
                fragment_cylinder_result.setText(
                    "π=3.14\nr=${number_r}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(
                        R.string.Volume
                    ) + ": ${result_volume.format(1)}")
                fragment_cylinder_number_r.text = Editable.Factory.getInstance().newEditable("")
                fragment_cylinder_number_h.text = Editable.Factory.getInstance().newEditable("")
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