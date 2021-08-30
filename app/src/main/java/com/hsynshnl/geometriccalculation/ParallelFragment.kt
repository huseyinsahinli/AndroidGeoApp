package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_parallel.*


class ParallelFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parallel, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_parallel_result.setText("a=${0}\t\tb=${0}\t\tc=${0}\n"+
            getString(R.string.Area) + ": \n" + getString(R.string.Volume) + ": \n" + getString(R.string.Diagonal) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": \n" + getString(
                R.string.Diagonal
            ) + ": ")
        fragment_parallel_calculate.setOnClickListener {
            val number_a = fragment_parallel_number_a.text.toString().toDoubleOrNull()
            val number_b = fragment_parallel_number_b.text.toString().toDoubleOrNull()
            val number_c = fragment_parallel_number_c.text.toString().toDoubleOrNull()

            val result_are: Double
            val result_diagonal: Double
            val result_diagonal1: Double
            val result_diagonal2: Double
            val result_diagonal3: Double
            val result_volume: Int
            if (number_a != null && number_b != null && number_c != null) {
                result_are =
                    2 * ((number_a * number_b) + (number_b * number_c) + (number_a * number_c))
                result_volume = number_a.toInt() * number_b.toInt() * number_c.toInt()
                result_diagonal = Math.sqrt(
                    Math.pow(number_a, 2.0) + Math.pow(number_b, 2.0) + Math.pow(
                        number_c,
                        2.0
                    )
                )
                result_diagonal1 = Math.sqrt(Math.pow(number_a, 2.0) + Math.pow(number_c, 2.0))
                result_diagonal2 = Math.sqrt(Math.pow(number_b, 2.0) + Math.pow(number_c, 2.0))
                result_diagonal3 = Math.sqrt(Math.pow(number_a, 2.0) + Math.pow(number_b, 2.0))

                fragment_parallel_result.setText(
                    "a=${number_a}\tb=${number_b}\tc=${number_c}\n" + getString(R.string.Area) + ": ${result_are}\n" + getString(
                        R.string.Volume
                    ) + ": ${result_volume}\n" + getString(R.string.Diagonal) + " D: ${result_diagonal.format(2)}\n" + getString(
                        R.string.Diagonal
                    ) + " d1: ${result_diagonal1.format(2)}\n" + getString(R.string.Diagonal) + " d2: ${result_diagonal2.format(2)}\n" + getString(
                        R.string.Diagonal
                    ) + " d3: ${result_diagonal3.format(2)}")
                fragment_parallel_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_parallel_number_b.text = Editable.Factory.getInstance().newEditable("")
                fragment_parallel_number_c.text = Editable.Factory.getInstance().newEditable("")
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