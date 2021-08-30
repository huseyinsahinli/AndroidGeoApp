package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_square.*

class SquareFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_square, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_square_result.text = "a=0\n"+getString(R.string.Area) + ": \n"+getString(R.string.Perimeter)+": \n"+getString(R.string.Diagonal)+": "
        fragment_square_calculate.setOnClickListener {
            var number_a = fragment_square_number_a.text.toString().toIntOrNull()

            var result_are:Int?=null
            var result_diagonal:Int?=null
            var result_perimeter:Int?=null
            if (number_a!=null){
                result_are=number_a*number_a
                result_diagonal=number_a
                result_perimeter=4*number_a
                fragment_square_result.text ="a=${number_a}\n"+getString(R.string.Area) + ": ${result_are}\n"+getString(R.string.Perimeter)+": ${result_perimeter}\n"+getString(R.string.Diagonal)+": ${result_diagonal}√2"
                fragment_square_number_a.text = Editable.Factory.getInstance().newEditable("")
            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}