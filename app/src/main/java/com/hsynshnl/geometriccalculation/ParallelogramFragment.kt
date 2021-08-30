package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_parallelogram.*

class ParallelogramFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parallelogram, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_parallelogram_result.setText( "a=0\t\tb=0"+getString(R.string.Area) + ": "
        )
        fragment_parallelogram_calculate.setOnClickListener {
            val number_a = fragment_parallelogram_number_a.text.toString().toIntOrNull()
            val number_h = fragment_parallelogram_number_h.text.toString().toIntOrNull()

            val result_are:Int
            if (number_a!=null&&number_h!=null){
                result_are=number_a*number_h
                fragment_parallelogram_result.text ="a=${number_a}\th=${number_h}\n"+getString(R.string.Area) + ": ${result_are}"
                fragment_parallelogram_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_parallelogram_number_h.text = Editable.Factory.getInstance().newEditable("")
            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}