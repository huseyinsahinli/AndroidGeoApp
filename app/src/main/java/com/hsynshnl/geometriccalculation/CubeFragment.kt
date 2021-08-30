package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cube.*

class CubeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cube, container, false)
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_cube_result.setText(
            "a=${0}\n"
                    +
                    getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": "
        )
        fragment_cube_calcute.setOnClickListener {
            val number_a = fragment_cube_number_a.text.toString().toIntOrNull()

            val result_are: Int
            val result_diagonal: Double
            val result_diagonal2: Double
            val result_volume: Int
            if (number_a != null) {
                result_are = 6 * (number_a * number_a)
                result_diagonal = number_a * Math.sqrt(2.0)
                result_diagonal2 = number_a * Math.sqrt(3.0)
                result_volume = Math.pow(number_a.toDouble(), 3.0).toInt()
                fragment_cube_result.setText(
                    "a=${number_a}\n" + getString(R.string.Area) + ": ${result_are}\n" + getString(R.string.Volume) + ": ${result_volume}\n" + getString(
                        R.string.Diagonal
                    ) + " d: ${number_a}√2\t=${result_diagonal.format(2)}\n" + getString(R.string.Diagonal) + " D: ${number_a}√3\t=${
                        result_diagonal2.format(
                            2
                        )
                    }"
                )
                fragment_cube_number_a.text = Editable.Factory.getInstance().newEditable("")
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