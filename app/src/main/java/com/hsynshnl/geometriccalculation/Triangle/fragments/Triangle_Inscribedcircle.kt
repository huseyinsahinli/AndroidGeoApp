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
import kotlinx.android.synthetic.main.fragment_triangle__inscribedcircle.text_view_number_a
import kotlinx.android.synthetic.main.fragment_triangle__inscribedcircle.text_view_number_b
import kotlinx.android.synthetic.main.fragment_triangle__inscribedcircle.text_view_number_c


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
        text_view_result2.text =
            getString(R.string.Result) + "\n" + getString(R.string.InscribedcircleSentenceOne) + ": \n" + getString(
                R.string.InscribedcircleSentenceTwo
            ) + ": \n" + getString(R.string.Area) + ": "
        calculate2.setOnClickListener {
            var result_p: Double? = null
            var result_a: Double? = null
            var result_r: Double? = null
            var result_s: Double? = null
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_b = text_view_number_b.text.toString().toDoubleOrNull()
            var number_c = text_view_number_c.text.toString().toDoubleOrNull()

            if (number_a != null && number_b != null && number_c != null) {
                result_p = (number_a + number_b + number_c) / 2
                result_a =
                    ((result_p - number_a) * (result_p - number_b) * (result_p - number_c)) / result_p
                result_r = Math.sqrt(result_a)
                result_s = result_p * result_r
                text_view_result2.text ="a=${number_a}\tb=${number_b}\tc=${number_c}\n"+
                    getString(R.string.Result) + "\n" + getString(R.string.InscribedcircleSentenceOne) + ": ${
                        result_r.format(2)
                    }\n" + getString(R.string.InscribedcircleSentenceTwo) + ": ${
                        (result_r * 2).format(
                            2
                        )
                    }\n" + getString(R.string.Area) + ": ${result_s.format(2)}"

                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_b.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_c.text = Editable.Factory.getInstance().newEditable("")
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