package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_quadrilateral.*
import kotlin.math.sin

class QuadrilateralFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quadrilateral, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_quarilateral_result.text = "a=0\t\td1=0\t\td2=0\n"+getString(R.string.Area) + ": "

        fragment_quarilateral_calculate.setOnClickListener {
            val number_d1 = fragment_quarilateral_number_d1.text.toString().toDoubleOrNull()
            val number_d2 = fragment_quarilateral_number_d2.text.toString().toDoubleOrNull()
            val number_a = fragment_quarilateral_number_a.text.toString().toDoubleOrNull()
            val result: Double
            if (number_a != null && number_d1 != null && number_d2 != null) {
                result=(number_d1*number_d2* sin(Math.toRadians(number_a)))/2
                fragment_quarilateral_result.text="a=${number_a}\td1=${number_d1}\td2=${number_d2}\n"+getString(R.string.Area)+": ${result.format(2)}"
                fragment_quarilateral_number_d1.text = Editable.Factory.getInstance().newEditable("")
                fragment_quarilateral_number_d2.text = Editable.Factory.getInstance().newEditable("")
                fragment_quarilateral_number_a.text = Editable.Factory.getInstance().newEditable("")

            }else{
                Toast.makeText(context?.applicationContext,getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}