package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_triangle_area.*

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
        triangle_area_result.setText("a= ${0}\t\th= ${0}\n\n"+getString(R.string.Area)+"= ${0}")
        triangle_are_calculate.setOnClickListener {
            val a_number = triangle_area_number_a.text.toString().toIntOrNull()
            val h_number = triangle_area_number_h.text.toString().toIntOrNull()
            if(a_number!=null&&h_number!=null){
                val result=(a_number*h_number)/2
                triangle_area_result.setText("a= ${a_number}\t\th= ${h_number}\n\n"+getString(R.string.Area)+"= ${result}")
                triangle_area_number_a.text = Editable.Factory.getInstance().newEditable("")
                triangle_area_number_h.text = Editable.Factory.getInstance().newEditable("")

            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }




    }

}