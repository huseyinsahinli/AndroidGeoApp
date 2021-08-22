package com.hsynshnl.geometriccalculation.Triangle.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.hsynshnl.geometriccalculation.R
import kotlinx.android.synthetic.main.fragment_pythagorean_theorem.*

class PythagoreanTheorem : Fragment() {
    fun Double.format(digits: Int) = "%.${digits}f".format(this)
    var text_a_changed = false
    var text_b_changed = false
    var text_c_changed = false
    fun set_changed_reset() {
        text_a_changed = false
        text_b_changed = false
        text_c_changed = false
    }

    fun set_Textview_reset() {
        liner_a.visibility = View.VISIBLE
        liner_b.visibility = View.VISIBLE
        liner_c.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pythagorean_theorem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_view_number_a.doOnTextChanged { text, start, before, count ->
            text_a_changed = true
            if (!text.isNullOrEmpty()) {
                if (text_a_changed == true && text_b_changed == true) {
                    liner_c.visibility = View.GONE
                } else if (text_a_changed == true && text_c_changed == true) {
                    liner_b.visibility = View.GONE
                }
            } else {
                text_a_changed = false
            }
        }
        text_view_number_b.doOnTextChanged { text, start, before, count ->
            text_b_changed = true
            if (!text.isNullOrEmpty()) {
                if (text_b_changed == true && text_c_changed == true) {
                    liner_a.visibility = View.GONE
                } else if (text_a_changed == true && text_b_changed == true) {
                    liner_c.visibility = View.GONE
                }
            } else {
                text_b_changed = false
            }
        }
        text_view_number_c.doOnTextChanged { text, start, before, count ->
            text_c_changed = true
            if (!text.isNullOrEmpty()) {
                if (text_c_changed == true && text_a_changed == true) {
                    liner_b.visibility = View.GONE
                } else if (text_b_changed == true && text_c_changed == true) {
                    liner_a.visibility = View.GONE
                }
            } else {
                text_c_changed = false
            }
        }

        calculate.setOnClickListener {
            var number_a = text_view_number_a.text.toString().toDoubleOrNull()
            var number_b = text_view_number_b.text.toString().toDoubleOrNull()
            var number_c = text_view_number_c.text.toString().toDoubleOrNull()
            var result: Double? = null
            if (number_a != null && number_b != null) {
                //result c
                result = Math.sqrt(Math.pow(number_a, 2.00) + Math.pow(number_b, 2.00))
                text_view_result.text = "a = ${number_a}\nb = ${number_b}\n" + getString(R.string.Result) + "\nc = ${result.format(2)}"
            } else if (number_a != null && number_c != null) {
                //result b
                if (number_a >= number_c) {
                    Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFour), Toast.LENGTH_SHORT).show()
                } else {
                    result = Math.sqrt(Math.pow(number_c, 2.00) - Math.pow(number_a, 2.00))
                    text_view_result.text = "a = ${number_a}\nc = ${number_c}\n" + getString(R.string.Result) + "\nb = ${result.format(2)}"
                }
            } else if (number_b != null && number_c != null) {
                //result a
                if (number_b >= number_c) {
                    Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFour), Toast.LENGTH_SHORT).show()
                } else {
                    result = Math.sqrt(Math.pow(number_c, 2.00) - Math.pow(number_b, 2.00))
                    text_view_result.text = "b = ${number_b}\nc = ${number_c}\n" + getString(R.string.Result) + "\na = ${result.format(2)}"
                }
            } else {
                Toast.makeText(context?.applicationContext, getString(R.string.PythagoreanSentenceFive), Toast.LENGTH_SHORT).show()
            }

            set_Textview_reset()
            set_changed_reset()
            text_view_number_a.text = Editable.Factory.getInstance().newEditable("")
            text_view_number_b.text = Editable.Factory.getInstance().newEditable("")
            text_view_number_c.text = Editable.Factory.getInstance().newEditable("")

        }

    }
}