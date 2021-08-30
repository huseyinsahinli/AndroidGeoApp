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
import kotlinx.android.synthetic.main.fragment_triangle__inscribedcircle.*


class Triangle_Inscribedcircle : Fragment() {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triangle__inscribedcircle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //reulst  r  p=a+b+c/2 r=a nın karekökü a=(p-a)*(p-b)*(p-c)/p çarp da 2 katı alan s=p*r
        triangle_inscribedcircle_result.setText("a= ${0}\t\tb= ${0}\t\tc=${0}\n" +
                getString(R.string.Result) + "\n" + getString(R.string.InscribedcircleSentenceOne) + ": \n" + getString(
                        R.string.InscribedcircleSentenceTwo
                ) + ": \n" + getString(R.string.Area) + ": ")
        triangle_inscribedcircle_calculate.setOnClickListener {
            var result_p: Double?
            var result_a: Double?
            var result_r: Double?
            var result_s: Double?
            var a_number = triangle_inscribedcircle_number_a.text.toString().toDoubleOrNull()
            var b_number = triangle_inscribedcircle_number_b.text.toString().toDoubleOrNull()
            var c_number = triangle_inscribedcircle_number_c.text.toString().toDoubleOrNull()

            if (a_number != null && b_number != null && c_number != null) {
                result_p = (a_number + b_number + c_number) / 2
                result_a =
                        ((result_p - a_number) * (result_p - b_number) * (result_p - c_number)) / result_p
                result_r = Math.sqrt(result_a)
                result_s = result_p * result_r
                triangle_inscribedcircle_result.setText( "a= ${a_number}\t\tb= ${b_number}\t\tc=${c_number}\n" +
                        getString(R.string.Result) + "\n" + getString(R.string.InscribedcircleSentenceOne) + ": ${
                    result_r.format(2)
                }\n" + getString(R.string.InscribedcircleSentenceTwo) + ": ${
                    (result_r * 2).format(
                            2
                    )
                }\n" + getString(R.string.Area) + ": ${result_s.format(2)}")

                triangle_inscribedcircle_number_a.text = Editable.Factory.getInstance().newEditable("")
                triangle_inscribedcircle_number_b.text = Editable.Factory.getInstance().newEditable("")
                triangle_inscribedcircle_number_c.text = Editable.Factory.getInstance().newEditable("")
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