# AndroidUtils
>* LibCommon (通用库)

## LibCommon

* TimeToast 可自定时长的Toast。

```java
//调用show之前得调用makeText初始化，否则show无效。
TimeToast.makeText(this, "Toast Until canceled");
TimeToast.show();
//在调用show之后，只要没调用cancelToast，Toast就不会消失。
//可以使用Handler的postDelayed来调用cancelToast，从而达到使用任意时长Toast的效果。
TimeToast.cancelToast();
```

* InputUtils 输入相关工具类。

```java
//对应的View弹出软键盘。
InputUtils.toggleSoftInput(view);
```

* LogSelfUtils 自用Log工具类。

```java
LogSelfUtils.v("verbose");
LogSelfUtils.d("debug");
LogSelfUtils.i("info");
LogSelfUtils.w("warn");
LogSelfUtils.e("error");
```
