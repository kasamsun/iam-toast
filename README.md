# Android : IamToast
Another Toast library for Android

![alt text](https://raw.githubusercontent.com/kasamsun/iamtoast/master/images/toast-sample.png "Toast sammple")

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
    implementation 'com.github.kasamsun:iamtoast:1.0.5'
}
```

```kotlin

IamToast.info(this, "You have got mail. Please check your mail box.")

IamToast.normal(this, "Hello, world")

IamToast.success(this, "Transaction complete. Thank you.")

IamToast.warning(this, "Please enter more data to complete transaction.")

IamToast.error(this, "Server is busy. Please try again later.")

```

