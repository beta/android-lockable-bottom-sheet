# Android Lockable Bottom Sheet

[![JitPack Badge](https://jitpack.io/v/beta/android-lockable-bottom-sheet.svg)](https://jitpack.io/#beta/android-lockable-bottom-sheet)

Android Lockable Bottom Sheet is a library built on top of the Android Design Support Library, and provides a simple hack on the bottom sheet dialogs to make them able to be noncancelable.

The [bottom sheet dialogs](https://material.google.com/components/bottom-sheets.html) have been introduced in the Android Design Support Library since version 23.2, which is a new way to provide user with a list of actions, information, etc. However, the implementation provided by the design library doesn't allow developers to make the dialogs persistent easily, and by saying "persistent" I mean a dialog could not be canceled by neither clicking outside it, nor swiping down on the dialog.

So this library offers an easy way to "lock" a bottom sheet dialog by overriding the `setCancelable` method. You can download and play with the demo app from the [Releases](https://github.com/beta/android-lockable-bottom-sheet/releases) page to see how it works yourself.

## Download

This library is published on [JitPack](https://jitpack.io/). Add the following lines to your project's root `build.gradle`:

```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

And add the dependency to `build.gradle` in your app's module:

```gradle
dependencies {
    compile 'com.github.beta:android-lockable-bottom-sheet:0.1.0'
}
```

And that's it.

## License

MIT
