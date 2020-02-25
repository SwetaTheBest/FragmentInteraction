package com.swetajain.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(),
    FragmentOne.FragmentAListener,
    FragmentTwo.FragmentBListener{

    val fragmentOne = FragmentOne()
    val fragmentTwo = FragmentTwo()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_b,fragmentOne)
            .replace(R.id.container_a,fragmentTwo)
            .commit()


    }

    override fun onInputASent(input: CharSequence?) {
          fragmentTwo.updateEditText(input)
    }

    override fun onInputBSent(input: CharSequence?) {
          fragmentOne.updateEditText(input)
    }

}
