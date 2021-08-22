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
import kotlinx.android.synthetic.main.fragment_triangle_area.*
import kotlinx.android.synthetic.main.fragment_triangle_area.text_view_number_a

class TriangleArea : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triangle_area, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        text_view_result2.text=getString(R.string.Area)+": "
        calculate2.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_h = text_view_number_h.text.toString().toDoubleOrNull()
            if(number_a!=null&&number_h!=null){
                var result=(number_a*number_h)/2
                text_view_result2.text="a=${number_a}\th=${number_h}\n"+getString(R.string.Area)+": ${result}"

                text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
                text_view_number_h.text = Editable.Factory.getInstance().newEditable("")

            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFive), Toast.LENGTH_SHORT).show()
            }
        }




    }

}