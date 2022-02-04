# Android : IamToast
Another Toast library for Android

![alt text](https://raw.githubusercontent.com/kasamsun/iam-toast/master/images/toast-sample.png "Toast sammple")

# How to

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

```kotlin

IamToast.info(this, "You have got mail. Please check your mail box.")

IamToast.normal(this, "Hello, world")

IamToast.success(this, "Transaction complete. Thank you.")

IamToast.warning(this, "Please enter more data to complete transaction.")

IamToast.error(this, "Server is busy. Please try again later.")

```

