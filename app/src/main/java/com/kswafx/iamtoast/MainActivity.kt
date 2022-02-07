package com.kswafx.iamtoast

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rg = findViewById<View>(R.id.style_group) as RadioGroup
        rg.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.style_inset -> {
                        IamToast.resetStyle()
                        IamToast.apply {
                            this.iconStyle = IamToast.ICON_STYLE_INSET
                        }
                    }
                    R.id.style_outset -> {
                        IamToast.resetStyle()
                        IamToast.apply {
                            this.iconStyle = IamToast.ICON_STYLE_OUTSET
                        }
                    }
                    R.id.style_custom -> {
                        IamToast.apply {
                            this.infoTitle = "ข้อความ"
                            this.normalTitle = "ข้อความ"
                            this.errorTitle = "ข้อผิดพลาด"
                            this.successTitle = "ทำรายการเรียบร้อย"
                            this.warningTitle = "แจ้งเตือน"
                            this.iconStyle = IamToast.ICON_STYLE_INSET
                            this.normalToastColor = R.color.brown_darken_3
                            this.normalBackgroundToastColor = R.color.white
                            this.infoToastColor = R.color.teal_darken_3
                            this.infoBackgroundToastColor = R.color.white
                            this.successToastColor = R.color.light_blue_darken_3
                            this.successBackgroundToastColor = R.color.white
                            this.warningToastColor = R.color.amber_darken_3
                            this.warningBackgroundToastColor = R.color.white
                            this.errorToastColor = R.color.deep_orange_darken_3
                            this.errorBackgroundToastColor = R.color.white
                            this.normalIcon = R.drawable.ic_sentiment_satisfied_24
                            this.infoIcon = R.drawable.ic_sentiment_satisfied_alt_24
                            this.successIcon = R.drawable.ic_sentiment_very_satisfied_24
                            this.warningIcon = R.drawable.ic_sentiment_neutral_24
                            this.errorIcon = R.drawable.ic_sentiment_very_dissatisfied_24
                        }
                    }
                }
            }
        })
        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener {
            IamToast.info(
                this,
                "You have got mail. Please check your mail box. Thank you for your attention."
            )
        }
        val buttonNormal = findViewById<Button>(R.id.buttonNormal)
        buttonNormal.setOnClickListener { IamToast.normal(this, "Hello, world") }

        val buttonSuccess = findViewById<Button>(R.id.buttonSuccess)
        buttonSuccess.setOnClickListener {
            IamToast.success(
                this,
                "Transaction complete. Thank you."
            )
        }
        val buttonWarning = findViewById<Button>(R.id.buttonWarning)
        buttonWarning.setOnClickListener {
            IamToast.warning(
                this,
                "Please enter more data to complete transaction."
            )
        }
        val buttonError = findViewById<Button>(R.id.buttonError)
        buttonError.setOnClickListener {
            IamToast.error(
                this,
                "Server is busy. Please try again later."
            )
        }
    }
}