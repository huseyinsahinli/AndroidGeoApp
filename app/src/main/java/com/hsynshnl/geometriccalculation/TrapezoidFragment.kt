package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_trapezoid.*

class TrapezoidFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trapezoid, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_trapezoid_result.text ="a=0\tb=0\th=0\n"+ getString(R.string.Area) + ": "

        fragment_trapezoid_calculate.setOnClickListener {
            var number_a = fragment_trapezoid_number_a.text.toString().toDoubleOrNull()
            var number_b = fragment_trapezoid_number_b.text.toString().toDoubleOrNull()
            var number_h = fragment_trapezoid_number_h.text.toString().toDoubleOrNull()
            var result: Double
            if (number_a != null && number_b != null && number_h != null) {
                result=(number_h*(number_a+number_b))/2
                fragment_trapezoid_result.text="a=${number_a}\tb=${number_b}\th=${number_h}\n"+getString(R.string.Area)+": ${result.toInt()}"
                fragment_trapezoid_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_trapezoid_number_b.text = Editable.Factory.getInstance().newEditable("")
                fragment_trapezoid_number_h.text = Editable.Factory.getInstance().newEditable("")

            }else{
                Toast.makeText(context?.applicationContext,getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}