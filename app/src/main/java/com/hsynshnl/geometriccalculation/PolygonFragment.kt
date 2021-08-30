package com.hsynshnl.geometriccalculation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_polygon.*
import kotlin.math.tan

class PolygonFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_polygon, container, false)
    }


    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_polygon_result.text ="a=0\t\tn=0"+ getString(R.string.Area) + ": \n"+getString(R.string.Perimeter)+": "
        fragment_polygon_calculate.setOnClickListener {
            var number_a = fragment_polygon_number_a.text.toString().toIntOrNull()
            var number_n = fragment_polygon_number_n.text.toString().toIntOrNull()

            var result_are:Double
            var result_perimeter:Int
            if (number_a!=null&&number_n!=null){
                result_perimeter=number_a*number_n
                result_are=(number_n.toDouble()*Math.pow(number_a.toDouble(),2.0))/(4* tan(Math.toRadians(180/number_n.toDouble())))
                fragment_polygon_result.text = "a=${number_a}\tn=${number_n}\n"+getString(R.string.Area) + ": ${result_are.toInt()}\n"+getString(R.string.Perimeter)+": ${result_perimeter}"
                fragment_polygon_number_a.text = Editable.Factory.getInstance().newEditable("")
                fragment_polygon_number_n.text = Editable.Factory.getInstance().newEditable("")
            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.ToastMessage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}