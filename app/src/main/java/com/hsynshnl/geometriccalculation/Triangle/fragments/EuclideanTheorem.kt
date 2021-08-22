package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle

import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.activity_main_cube.*
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.*
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.text_view_number_a
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.text_view_number_p
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.text_view_number_k
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.linear_a
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.linear_p
import kotlinx.android.synthetic.main.fragment_euclidean_theorem.linear_k
import kotlinx.android.synthetic.main.fragment_pythagorean_theorem.*
import java.security.KeyStore

class EuclideanTheorem : Fragment() {
    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    var text_a_changed = false
    var text_p_changed = false
    var text_k_changed = false
    fun set_Textview_reset() {
        linear_a.visibility = View.VISIBLE
        linear_p.visibility = View.VISIBLE
        linear_k.visibility = View.VISIBLE
        text_a_changed = false
        text_p_changed = false
        text_k_changed = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_euclidean_theorem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_view_number_a.doOnTextChanged { text, start, before, count ->
            text_a_changed = true

            if (!text.isNullOrEmpty()) {
                if (text_a_changed == true && text_p_changed == true) {
                    linear_k.visibility = View.GONE
                } else if (text_a_changed == true && text_k_changed == true) {
                    linear_p.visibility = View.GONE
                }
            } else {
                text_a_changed = false
            }
        }
        text_view_number_p.doOnTextChanged { text, start, before, count ->
            text_p_changed = true
            if (!text.isNullOrEmpty()) {
                if (text_a_changed == true && text_p_changed == true) {
                    linear_k.visibility = View.GONE
                } else if (text_k_changed == true && text_p_changed == true) {
                    linear_a.visibility = View.GONE
                }
            } else {
                text_p_changed = false
            }
        }
        text_view_number_k.doOnTextChanged { text, start, before, count ->
            text_k_changed = true

            if (!text.isNullOrEmpty()) {
                if (text_k_changed == true && text_a_changed) {
                    linear_p.visibility = View.GONE
                } else if (text_k_changed == true && text_p_changed == true) {
                    linear_a.visibility = View.GONE
                }
            } else {
                text_k_changed = false
            }
        }
        calculate2.setOnClickListener {

            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_p = text_view_number_p.text.toString().toDoubleOrNull()
            var number_k = text_view_number_k.text.toString().toDoubleOrNull()
            var result: Double? = null
            if(number_a!=null&&number_k!=null){
           result=Math.sqrt(number_a*number_k)
                text_view_result2.text=getString(R.string.Result)+"\nb= ${result.format(2)}\nb²= ${number_a*number_k}"
            }else if(number_a!=null&&number_p!=null){
                result=Math.sqrt(number_a*number_p)
                text_view_result2.text=getString(R.string.Result)+"\nc= ${result.format(2)}\nc²= ${number_a*number_p}"
            }else if(number_p!=null&&number_k!=null){
                result=Math.sqrt(number_p*number_k)
                text_view_result2.text=getString(R.string.Result)+"\nh= ${result.format(2)}\nh²= ${number_p*number_k}"

            }else{
                Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFive), Toast.LENGTH_SHORT).show()
            }



            set_Textview_reset()
            text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
            text_view_number_p.text = Editable.Factory.getInstance().newEditable("")
            text_view_number_k.text = Editable.Factory.getInstance().newEditable("")



        }
    }


}