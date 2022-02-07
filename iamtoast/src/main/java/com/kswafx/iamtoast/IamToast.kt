package com.kswafx.iamtoast

import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class IamToast {

    companion object {
        const val LONG_DURATION = 5000 // 5 seconds
        const val SHORT_DURATION = 2000 // 2 seconds
        const val TOAST_NORMAL_TYPE = 0
        const val TOAST_INFO_TYPE = 1
        const val TOAST_SUCCESS_TYPE = 2
        const val TOAST_WARNING_TYPE = 3
        const val TOAST_ERROR_TYPE = 4
        const val ICON_STYLE_INSET = 0
        const val ICON_STYLE_OUTSET = 1
        var normalTitle = "Message"
        var infoTitle = "Info"
        var successTitle = "Success"
        var warningTitle = "Warning"
        var errorTitle = "Error"
        var GRAVITY_TOP = 48
        var GRAVITY_CENTER = 20
        var GRAVITY_BOTTOM = 80
        var iconStyle = ICON_STYLE_INSET
        private var transparentColor = R.color.transparent
        var successToastColor = R.color.toast_success_color
        var errorToastColor = R.color.toast_error_color
        var warningToastColor = R.color.toast_warning_color
        var infoToastColor = R.color.toast_info_color
        var normalToastColor = R.color.toast_normal_color
        var successBackgroundToastColor = R.color.toast_success_bg_color
        var errorBackgroundToastColor = R.color.toast_error_bg_color
        var warningBackgroundToastColor = R.color.toast_warning_bg_color
        var infoBackgroundToastColor = R.color.toast_info_bg_color
        var normalBackgroundToastColor = R.color.toast_normal_bg_color
        var successIcon = R.drawable.ic_toast_success
        var errorIcon = R.drawable.ic_toast_error
        var warningIcon = R.drawable.ic_toast_warning
        var infoIcon = R.drawable.ic_toast_info
        var normalIcon = R.drawable.ic_toast_normal

        fun resetStyle() {
            normalTitle = "Message"
            infoTitle = "Info"
            successTitle = "Success"
            warningTitle = "Warning"
            errorTitle = "Error"
            iconStyle = ICON_STYLE_INSET
            successToastColor = R.color.toast_success_color
            errorToastColor = R.color.toast_error_color
            warningToastColor = R.color.toast_warning_color
            infoToastColor = R.color.toast_info_color
            normalToastColor = R.color.toast_normal_color
            successBackgroundToastColor = R.color.toast_success_bg_color
            errorBackgroundToastColor = R.color.toast_error_bg_color
            warningBackgroundToastColor = R.color.toast_warning_bg_color
            infoBackgroundToastColor = R.color.toast_info_bg_color
            normalBackgroundToastColor = R.color.toast_normal_bg_color
            successIcon = R.drawable.ic_toast_success
            errorIcon = R.drawable.ic_toast_error
            warningIcon = R.drawable.ic_toast_warning
            infoIcon = R.drawable.ic_toast_info
            normalIcon = R.drawable.ic_toast_normal
        }

        fun normal(
            activity: Activity,
            message: String?,
            position: Int = GRAVITY_BOTTOM,
            duration: Int = SHORT_DURATION
        ) {
            createToast(activity, message, TOAST_NORMAL_TYPE, position, duration, null)
        }

        fun info(
            activity: Activity,
            message: String?,
            position: Int = GRAVITY_BOTTOM,
            duration: Int = SHORT_DURATION
        ) {
            createToast(activity, message, TOAST_INFO_TYPE, position, duration, null)
        }

        fun success(
            activity: Activity,
            message: String?,
            position: Int = GRAVITY_BOTTOM,
            duration: Int = SHORT_DURATION
        ) {
            createToast(activity, message, TOAST_SUCCESS_TYPE, position, duration, null)
        }

        fun warning(
            activity: Activity,
            message: String?,
            position: Int = GRAVITY_BOTTOM,
            duration: Int = SHORT_DURATION
        ) {
            createToast(activity, message, TOAST_WARNING_TYPE, position, duration, null)
        }

        fun error(
            activity: Activity,
            message: String?,
            position: Int = GRAVITY_BOTTOM,
            duration: Int = SHORT_DURATION
        ) {
            createToast(activity, message, TOAST_ERROR_TYPE, position, duration, null)
        }

        fun createToast(
            activity: Activity,
            message: String?,
            toastType: Int,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            val layoutInflater = LayoutInflater.from(activity)
            val layout = layoutInflater.inflate(
                R.layout.iam_toast,
                activity.findViewById(R.id.toast_container_view)
            )
            val contentLayout = layout.findViewById<ConstraintLayout>(R.id.toast_content_view)
            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            val toastIconLayout = layout.findViewById<View>(R.id.icon_layout)
            val toastText = layout.findViewById<TextView>(R.id.toast_title)
            val toastDescription = layout.findViewById<TextView>(R.id.toast_description)
            var color = infoToastColor
            var bkgColor = infoBackgroundToastColor
            var icon = infoIcon
            when (toastType) {
                TOAST_NORMAL_TYPE -> {
                    icon = normalIcon
                    color = normalToastColor
                    bkgColor = normalBackgroundToastColor
                    toastText.text = normalTitle
                }
                TOAST_INFO_TYPE -> {
                    icon = infoIcon
                    color = infoToastColor
                    bkgColor = infoBackgroundToastColor
                    toastText.text = infoTitle
                }
                TOAST_SUCCESS_TYPE -> {
                    icon = successIcon
                    color = successToastColor
                    bkgColor = successBackgroundToastColor
                    toastText.text = successTitle
                }
                TOAST_WARNING_TYPE -> {
                    icon = warningIcon
                    color = warningToastColor
                    bkgColor = warningBackgroundToastColor
                    toastText.text = warningTitle
                }
                TOAST_ERROR_TYPE -> {
                    icon = errorIcon
                    color = errorToastColor
                    bkgColor = errorBackgroundToastColor
                    toastText.text = errorTitle
                }
                else -> {
                    toastText.text = infoTitle
                }
            }

            toastIcon.setImageDrawable(
                ContextCompat.getDrawable(activity, icon)
            )
            if (iconStyle == ICON_STYLE_INSET) {
                DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.drawable),
                    ContextCompat.getColor(activity, color)
                )
                DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIconLayout.background),
                    ContextCompat.getColor(activity, transparentColor)
                )
            } else {
                DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.drawable),
                    ContextCompat.getColor(activity, bkgColor)
                )
                DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIconLayout.background),
                    ContextCompat.getColor(activity, color)
                )
            }
            DrawableCompat.setTint(
                DrawableCompat.wrap(layout.background),
                ContextCompat.getColor(activity, color)
            )
            DrawableCompat.setTint(
                DrawableCompat.wrap(contentLayout.background),
                ContextCompat.getColor(activity, bkgColor)
            )
            toastText.setTextColor(ContextCompat.getColor(activity, color))

            toastIcon.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.pulse))

            toastDescription.text = message
            if (font != null) {
                toastDescription.typeface = font
            }
            val toast = Toast(activity.applicationContext)
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 120)
            } else {
                toast.setGravity(position, 0, 120)
            }
            toast.view = layout
            if (duration == LONG_DURATION) {
                toast.duration = Toast.LENGTH_LONG
            } else {
                toast.duration = Toast.LENGTH_SHORT
            }
            toast.show()
        }
    }
}