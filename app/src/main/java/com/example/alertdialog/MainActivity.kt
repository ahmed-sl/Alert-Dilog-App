package com.example.alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btn = findViewById<Button>(R.id.btn1)

        val mShowBtn = findViewById<Button>(R.id.showAlertDialogBtn)
        //textview
        val mTextView = findViewById<TextView>(R.id.txtView)

        //button click to show alert dialog
        mShowBtn.setOnClickListener {
            val mBuilder = AlertDialog.Builder(this)
            val mLayout  = LinearLayout(this)
            val mEtName  = EditText(this)


            mEtName.setSingleLine()
            mEtName.hint  = "Enter Something"
            mLayout.orientation = LinearLayout.VERTICAL
            mLayout.addView(mEtName)
            mLayout.setPadding(50, 40, 50, 10)
            mBuilder.setView(mLayout)

            //set positive button to alert dialog
            mBuilder.setPositiveButton("TV"){dialogInterface, i ->
                //get text from edit texts
                val name = mEtName.text.toString()

                //set text to textView
                mTextView.text = name
            }
            //set neutral/cancel button
            mBuilder.setNeutralButton("Go"){dialogInterface, i ->
                dialogInterface.dismiss()
                val name = mEtName.text.toString()
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("Data",name)
                startActivity(intent)

            }
            //show dialog
            mBuilder.create().show()

        }
    }
}