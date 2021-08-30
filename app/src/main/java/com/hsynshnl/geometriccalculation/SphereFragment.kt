package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_sphere.*

class SphereFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sphere, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_sphere_result.text ="r=0\n"
            "π=3.14\n" + getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": "
        fragment_sphere_calculate.setOnClickListener {
            var number_r = fragment_sphere_number_r.text.toString().toDoubleOrNull()

            var result_are: Double
            var result_volume: Double
            if (number_r != null) {
                result_are = 4 *3.14* Math.pow(number_r, 2.0)
                result_volume = (4 *3.14* Math.pow(number_r, 3.0)) / 3
                fragment_sphere_result.text =
                    "π=3.14\nr=${number_r}\n" + getString(R.string.Area) + ": ${result_are.format(1)}\n" + getString(
                        R.string.Volume
                    ) + ": ${result_volume.format(1)}"
                fragment_sphere_number_r.text = Editable.Factory.getInstance().newEditable("")
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