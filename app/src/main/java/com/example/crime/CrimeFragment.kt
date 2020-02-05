package com.example.crime

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer

class CrimeFragment:Fragment() {

    private lateinit var crime:Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        crime = Crime()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val view = inflater.inflate(R.layout.fragment_crime,container,false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button

        dateButton.apply{
            text = crime.date.toString()
            isEnabled = false
        }
        return view
    }

    override fun onStart(){
        super.onStart()

        val titleWatcher = object:TextWatcher{
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ){
                //leave blank for now
            }
            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ){
                crime.title = sequence.toString()
            }

            override fun afterTextChaged(sequence: Editable?){
                //leave blank for now
            }
        }

        titleField.addTextChangedListener(titleWatcher)
    }
}