package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_rectangle.*

class RectangleFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rectangle, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_rectangle_result.text ="a=0\t\tb=0\n"+ getString(R.string.Area) + ": \n"+getString(R.string.Perimeter)+": \n"+getString(R.string.Diagonal)+": "
        fragment_rectangle_calculate.setOnClickListener {
            val number_a = fragment_rectangle_number_a.text.toString().toIntOrNull()
            val number_b = fragment_rectangle_number_b.text.toString().toIntOrNull()

            val result_are:Int
            val result_diagonal:Double
            val result_perimeter:Int
            if (number_a!=null&&number_b!=null){
                result_are=number_a*number_b
                result_diagonal=Math.sqrt((number_a*number_a).toDouble()+(number_b*number_b).toDouble())
                result_perimeter=2*(number_a+number_b)
                fragment_rectangle_result.text ="a=${number_a}\tb=${number_b}\n"+getString(R.string.Area) + ": ${result_are}\n"+getString(R.string.Perimeter)+": ${result_perimeter}\n"+getString(R.string.Diagonal)+": ${result_diagonal.toInt()}√2"
                fragment_rectangle_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_rectangle_number_b.text = Editable.Factory.getInstance().newEditable("")
            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}