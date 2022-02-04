package com.kswafx.iamtoast

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IamToast.errorTitle = "ข้อผิดพลาด"
        IamToast.successTitle = "รายการสำเร็จ"

        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener { IamToast.info(this, "You have got mail. Please check your mail box.") }
        val buttonNormal = findViewById<Button>(R.id.buttonNormal)
        buttonNormal.setOnClickListener { IamToast.normal(this, "Hello, world") }
        val buttonSuccess = findViewById<Button>(R.id.buttonSuccess)
        buttonSuccess.setOnClickListener { IamToast.success(this, "Transaction complete. Thank you.") }
        val buttonWarning = findViewById<Button>(R.id.buttonWarning)
        buttonWarning.setOnClickListener { IamToast.warning(this, "Please enter more data to complete transaction.") }
        val buttonError = findViewById<Button>(R.id.buttonError)
        buttonError.setOnClickListener { IamToast.error(this, "Server is busy. Please try again later.") }
    }
}