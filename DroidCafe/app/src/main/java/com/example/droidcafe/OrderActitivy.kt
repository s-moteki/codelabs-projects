package com.example.droidcafe


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order_actitivy.*


class OrderActitivy : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_actitivy)
        intent.getStringExtra(MainActivity.EXTRA_MESSAGE)?.let {
            order_textview.text = it
        }

        label_spinner?.let {
            it.onItemSelectedListener = this;
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.labels_array, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        label_spinner?.let {
            it.adapter = adapter
        }


        // radio_group.setOnCheckedChangeListener
    }

    fun onRadioButtonClicked(view: View) {

        if (view is RadioButton && view.isChecked) {
            when (view.getId()) {
                R.id.sameday -> displayToast(getString(R.string.same_day_messenger_service))
                R.id.nextday -> displayToast(getString(R.string.next_day_ground_delivery))
                R.id.pickup -> displayToast(getString(R.string.pick_up))
                else -> {
                }
            }
        }
    }

    fun displayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
        val spinnerLabel = adapterView?.getItemAtPosition(i).toString();
        displayToast(spinnerLabel)
    }
}