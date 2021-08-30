package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_stewart_theorem.*

class StewartTheorem : Fragment() {

    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stewart_theorem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        triangle_stewart_result.text="x = \nx² ="

        triangle_stewart_calculate.setOnClickListener {

            var b_number = triangle_stewart_number_b.text.toString().toDoubleOrNull()
            var c_number = triangle_stewart_number_c.text.toString().toDoubleOrNull()
            var m_number = triangle_stewart_number_m.text.toString().toDoubleOrNull()
            var n_number = triangle_stewart_number_n.text.toString().toDoubleOrNull()
            if (b_number==null||c_number==null||m_number==null||n_number==null){
                triangle_stewart_result.text=getString(R.string.StewartTheoremSentenceOne)
            }
            else{
                var powerNumberB=Math.pow(b_number, 2.0)
                var powerNumberC=Math.pow(c_number, 2.0)

                var result=((powerNumberB*m_number)+(powerNumberC*n_number)/m_number+n_number)-m_number*n_number
                var resultsqrt=Math.sqrt(result)
                triangle_stewart_result.text="b=${b_number}\tc=${c_number}\tm=${m_number}\tn=${n_number}\n"+getString(R.string.Result)+"\nx = ${resultsqrt.format(2)}\nx² = ${result.format(2)}"

                triangle_stewart_number_b.text = Editable.Factory.getInstance().newEditable("")
                triangle_stewart_number_c.text = Editable.Factory.getInstance().newEditable("")
                triangle_stewart_number_m.text = Editable.Factory.getInstance().newEditable("")
                triangle_stewart_number_n.text = Editable.Factory.getInstance().newEditable("")
            }
        }


    }
}