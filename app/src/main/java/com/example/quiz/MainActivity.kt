package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_reset.setOnClickListener{
            rgmain.clearCheck()

            checkboxEnglish.isChecked = false;
            checkboxJava.isChecked = false;
            checkboxKotlin.isChecked = false;
        }

        button_submit.setOnClickListener{
            var marks:Int = 0

            if(radioButtonTrue.isChecked)
                marks += 50

            if(checkboxEnglish.isChecked){
                marks += 0
            } else if (checkboxKotlin.isChecked && checkboxJava.isChecked) {
                marks += 50
            } else if ((checkboxKotlin.isChecked && !checkboxJava.isChecked)|| (!checkboxKotlin.isChecked && checkboxJava.isChecked)) {
                marks += 25
            }

            var builder = AlertDialog.Builder(this)

            val currentTime = Calendar.getInstance().time
            builder.setMessage("Congratulations! You submitted on  $currentTime. You achieved $marks%")
            builder.setPositiveButton("OK"){dialogInterface, which ->
                Toast.makeText(applicationContext,"It's a positive action click by which id : $which",
                    Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
                finish()
            }

            builder.setNegativeButton("Cancel"){dialogInterface, which ->
                Toast.makeText(applicationContext,"It's a negative action click by which id : $which",
                    Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}