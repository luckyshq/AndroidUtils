# AndroidUtils
>* libtoast (Toast相关库)

## libtoast 

* TimeToast 可自定时长的Toast。

```java
//调用show之前得调用makeText初始化，否则show无效。
TimeToast.makeText(this, "Toast Until canceled");
TimeToast.show();
//在调用show之后，只要没调用cancelToast，Toast就不会消失。
//可以使用Handler的postDelayed来调用cancelToast，从而达到使用任意时长Toast的效果。
TimeToast.cancelToast();
```
