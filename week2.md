# \#2 認識Android開發環境

## 修改圖示與App名稱

### 圖示文件，/res/drawable，/res/mipmap

#### Android 單位/解析度概念

#### 建立圖示工具，向量與點陣圖示

### 字串文件，/res/value/strings.xml

{% hint style="info" %}
XML\(E**x**tensible **M**arkup **L**anguage\)，可延伸標記語言

#### 標籤（Tag）
{% endhint %}

#### 處理多國語言

## 排版編輯工具

### 排版文件，/res/layout/activity\_main.xml

```text
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Widget: TextView、Button、ImageView

