# Android : IamToast
Another Toast library for Android

![alt text](https://raw.githubusercontent.com/kasamsun/iam-toast/master/assets/toast-normal-inset.png "Toast sammple")

# Setup

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```
dependencies {
    implementation 'com.github.kasamsun:iam-toast:1.0.0'
}
```

# Usage
```kotlin

IamToast.info(this, "You have got mail. Please check your mail box.")

IamToast.normal(this, "Hello, world")

IamToast.success(this, "Transaction complete. Thank you.")

IamToast.warning(this, "Please enter more data to complete transaction.")

IamToast.error(this, "Server is busy. Please try again later.")

```
You can specify toast position [TOP,BOTTOM(default)] and duration [SHORT(default),LONG]
```kotlin

IamToast.normal(
    this,
    "Hello, world",
    IamToast.GRAVITY_TOP,
    IamToast.SHORT_DURATION
)

IamToast.normal(
    this,
    "Hello, world",
    IamToast.GRAVITY_BOTTOM,
    IamToast.LONG_DURATION
)

```


# Style

There are 2 default style, inset and outset.
```kotlin

IamToast.apply {
    this.iconStyle = IamToast.ICON_STYLE_INSET
}

```

![alt text](https://raw.githubusercontent.com/kasamsun/iam-toast/master/assets/toast-normal-inset.png "Toast sammple")
```kotlin

IamToast.apply {
    this.iconStyle = IamToast.ICON_STYLE_OUTSET
}

```
![alt text](https://raw.githubusercontent.com/kasamsun/iam-toast/master/assets/toast-normal-outset.png "Toast sammple")

You can reset style to default
```kotlin

IamToast.resetStyle()

```

You can set color and icon you want 
```kotlin

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

```
![alt text](https://raw.githubusercontent.com/kasamsun/iam-toast/master/assets/toast-custom.png "Toast sammple")