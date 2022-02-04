package com.kswafx.iamtoast;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


public class IamToast {

    public static final int LONG_DURATION = 5000; // 5 seconds
    public static final int SHORT_DURATION = 2000; // 2 seconds
    public static final int TOAST_NORMAL_TYPE = 0;
    public static final int TOAST_INFO_TYPE = 1;
    public static final int TOAST_SUCCESS_TYPE = 2;
    public static final int TOAST_WARNING_TYPE = 3;
    public static final int TOAST_ERROR_TYPE = 4;
    public static String normalTitle = "Message";
    public static String infoTitle = "Info";
    public static String successTitle = "Success";
    public static String warningTitle = "Warning";
    public static String errorTitle = "Error";

    public static int GRAVITY_TOP = 48;
    public static int GRAVITY_CENTER = 20;
    public static int GRAVITY_BOTTOM = 80;

    private static int successToastColor = R.color.toast_success_color;
    private static int errorToastColor = R.color.toast_error_color;
    private static int warningToastColor = R.color.toast_warning_color;
    private static int infoToastColor = R.color.toast_info_color;
    private static int normalToastColor = R.color.toast_normal_color;

    private static int successBackgroundToastColor = R.color.toast_success_bg_color;
    private static int errorBackgroundToastColor = R.color.toast_error_bg_color;
    private static int warningBackgroundToastColor = R.color.toast_warning_bg_color;
    private static int infoBackgroundToastColor = R.color.toast_info_bg_color;
    private static int normalBackgroundToastColor = R.color.toast_normal_bg_color;

    public void resetToastColors() {
        successToastColor = R.color.toast_success_color;
        errorToastColor = R.color.toast_error_color;
        warningToastColor = R.color.toast_warning_color;
        infoToastColor = R.color.toast_info_color;
        normalToastColor = R.color.toast_normal_color;

        successBackgroundToastColor = R.color.toast_success_bg_color;
        errorBackgroundToastColor = R.color.toast_error_bg_color;
        warningBackgroundToastColor = R.color.toast_warning_bg_color;
        infoBackgroundToastColor = R.color.toast_info_bg_color;
        normalBackgroundToastColor = R.color.toast_normal_bg_color;
    }

    public void setInfoTitle(String title) {
        infoTitle = title;
    }

    public void setNormalTitle(String title) {
        normalTitle = title;
    }

    public void setSuccessTitle(String title) {
        successTitle = title;
    }

    public void setWarningTitle(String title) {
        warningTitle = title;
    }

    public void setErrorTitle(String title) {
        errorTitle = title;
    }

    public void setSuccessColor(int color) {
        successToastColor = color;
    }

    public void setSuccessBackgroundColor(int color) {
        successBackgroundToastColor = color;
    }

    public void setErrorColor(int color) {
        errorToastColor = color;
    }

    public void setErrorBackgroundColor(int color) {
        errorBackgroundToastColor = color;
    }

    public void setWarningColor(int color) {
        warningToastColor = color;
    }

    public void setWarningBackgroundColor(int color) {
        warningBackgroundToastColor = color;
    }

    public void setInfoColor(int color) {
        infoToastColor = color;
    }

    public void setInfoBackgroundColor(int color) {
        infoBackgroundToastColor = color;
    }

    public static void setNormalToastColor(int normalToastColor) {
        IamToast.normalToastColor = normalToastColor;
    }

    public static void setNormalBackgroundToastColor(int normalBackgroundToastColor) {
        IamToast.normalBackgroundToastColor = normalBackgroundToastColor;
    }

    public static void normal(
            Activity activity,
            String message
    ) {
        createToast(activity, message, TOAST_NORMAL_TYPE, IamToast.GRAVITY_BOTTOM, IamToast.SHORT_DURATION, null);
    }

    public static void normal(
            Activity activity,
            String message,
            int position,
            int duration
    ) {
        createToast(activity, message, TOAST_NORMAL_TYPE, position, duration, null);
    }

    public static void info(
            Activity activity,
            String message
    ) {
        createToast(activity, message, TOAST_INFO_TYPE, IamToast.GRAVITY_BOTTOM, IamToast.SHORT_DURATION, null);
    }

    public static void info(
            Activity activity,
            String message,
            int position,
            int duration
    ) {
        createToast(activity, message, TOAST_INFO_TYPE, position, duration, null);
    }

    public static void success(
            Activity activity,
            String message
    ) {
        createToast(activity, message, TOAST_SUCCESS_TYPE, IamToast.GRAVITY_BOTTOM, IamToast.SHORT_DURATION, null);
    }

    public static void success(
            Activity activity,
            String message,
            int position,
            int duration
    ) {
        createToast(activity, message, TOAST_SUCCESS_TYPE, position, duration, null);
    }

    public static void warning(
            Activity activity,
            String message
    ) {
        createToast(activity, message, TOAST_WARNING_TYPE, IamToast.GRAVITY_BOTTOM, IamToast.SHORT_DURATION, null);
    }

    public static void warning(
            Activity activity,
            String message,
            int position,
            int duration
    ) {
        createToast(activity, message, TOAST_WARNING_TYPE, position, duration, null);
    }

    public static void error(
            Activity activity,
            String message
    ) {
        createToast(activity, message, TOAST_ERROR_TYPE, IamToast.GRAVITY_BOTTOM, IamToast.SHORT_DURATION, null);
    }

    public static void error(
            Activity activity,
            String message,
            int position,
            int duration
    ) {
        createToast(activity, message, TOAST_ERROR_TYPE, position, duration, null);
    }

    public static void createToast(
            Activity activity,
            String message,
            int toastType,
            int position,
            int duration,
            Typeface font
    ) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View layout = layoutInflater.inflate(
            R.layout.iam_toast,
            (activity).findViewById(R.id.toast_view)
        );
        ImageView toastIcon = layout.findViewById(R.id.toast_icon);
        TextView toastText = layout.findViewById(R.id.toast_text);
        TextView toastDescription = layout.findViewById(R.id.toast_description);

        Drawable drawable;

        switch(toastType) {
        case TOAST_INFO_TYPE:
        default:
            toastIcon.setImageDrawable(ContextCompat.getDrawable(activity,R.drawable.ic_toast_info));
            DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.getDrawable()),
                    ContextCompat.getColor(activity, infoToastColor)
            );
//            layout.findViewById(R.id.colorView).setBackgroundTintList(
//                    ContextCompat.getColorStateList(activity, infoToastColor)
//            );
            drawable = ContextCompat.getDrawable(activity, R.drawable.toast_info_background);
            assert drawable != null;
            drawable.setColorFilter(new PorterDuffColorFilter(
                    ContextCompat.getColor(activity, infoBackgroundToastColor),
                    PorterDuff.Mode.MULTIPLY
            ));
            layout.setBackground(drawable);
            toastText.setTextColor(ContextCompat.getColor(activity, infoToastColor));
            toastText.setText(infoTitle);
            break;
        case TOAST_NORMAL_TYPE:
            toastIcon.setImageDrawable(ContextCompat.getDrawable(activity,R.drawable.ic_toast_normal));
            DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.getDrawable()),
                    ContextCompat.getColor(activity, normalToastColor)
            );
//            layout.findViewById(R.id.colorView).setBackgroundTintList(
//                    ContextCompat.getColorStateList(activity, infoToastColor)
//            );
            drawable = ContextCompat.getDrawable(activity, R.drawable.toast_normal_background);
            assert drawable != null;
            drawable.setColorFilter(new PorterDuffColorFilter(
                    ContextCompat.getColor(activity, normalBackgroundToastColor),
                    PorterDuff.Mode.MULTIPLY
            ));
            layout.setBackground(drawable);
            toastText.setTextColor(ContextCompat.getColor(activity, normalToastColor));
            toastText.setText(normalTitle);
            break;
        case TOAST_SUCCESS_TYPE:
            toastIcon.setImageDrawable(ContextCompat.getDrawable(activity,R.drawable.ic_toast_success));
            DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.getDrawable()),
                    ContextCompat.getColor(activity, successToastColor)
            );
//            layout.findViewById(R.id.colorView).setBackgroundTintList(
//                    ContextCompat.getColorStateList(activity, successToastColor)
//            );
            drawable = ContextCompat.getDrawable(activity, R.drawable.toast_success_background);
            drawable.setColorFilter(new PorterDuffColorFilter(
                ContextCompat.getColor(activity, successBackgroundToastColor),
                PorterDuff.Mode.MULTIPLY
            ));
            layout.setBackground(drawable);
            toastText.setTextColor(ContextCompat.getColor(activity, successToastColor));
            toastText.setText(successTitle);
            break;

        case TOAST_WARNING_TYPE:
            toastIcon.setImageDrawable(ContextCompat.getDrawable(activity,R.drawable.ic_toast_warning));
            DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.getDrawable()),
                    ContextCompat.getColor(activity, warningToastColor)
            );
//            layout.findViewById(R.id.colorView).setBackgroundTintList(
//                    ContextCompat.getColorStateList(activity, warningToastColor)
//            );
            drawable = ContextCompat.getDrawable(activity, R.drawable.toast_warning_background);
            drawable.setColorFilter(new PorterDuffColorFilter(
                    ContextCompat.getColor(activity, warningBackgroundToastColor),
                    PorterDuff.Mode.MULTIPLY
            ));
            layout.setBackground(drawable);
            toastText.setTextColor(ContextCompat.getColor(activity, warningToastColor));
            toastText.setText(warningTitle);
            break;

        case TOAST_ERROR_TYPE:
            toastIcon.setImageDrawable(ContextCompat.getDrawable(activity,R.drawable.ic_toast_error));
            DrawableCompat.setTint(
                    DrawableCompat.wrap(toastIcon.getDrawable()),
                    ContextCompat.getColor(activity, errorToastColor)
            );
//            layout.findViewById(R.id.colorView).setBackgroundTintList(
//                    ContextCompat.getColorStateList(activity, errorToastColor)
//            );
            drawable = ContextCompat.getDrawable(activity, R.drawable.toast_error_background);
            drawable.setColorFilter(new PorterDuffColorFilter(
                ContextCompat.getColor(activity, errorBackgroundToastColor),
                PorterDuff.Mode.MULTIPLY
            ));
            layout.setBackground(drawable);
            toastText.setTextColor(ContextCompat.getColor(activity, errorToastColor));
            toastText.setText(errorTitle);
            break;
        }

        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.pulse);
        toastIcon.startAnimation(animation);

        toastDescription.setText(message);
        if (font!=null) {
            toastDescription.setTypeface(font);
        }
        Toast toast = new Toast(activity.getApplicationContext());

        if (position == GRAVITY_BOTTOM) {
            toast.setGravity(position, 0, 120);
        } else {
            toast.setGravity(position, 0, 120);
        }
        toast.setView(layout);
        if (duration==LONG_DURATION) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

}
