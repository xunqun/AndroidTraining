# \#2 認識Android開發環境

## 修改圖示與App名稱

Android App的圖示設定在 *\[專案\]/app/src/main/AndroidManifest.xml*  當中，圖示通常放置在 *\[專案\]/app/src/main/res/mipmap/* 底下

```markup
<application
        ...
        android:icon="@mipmap/ic_launcher"
        >
                ...
</application>
```


### 圖示文件，/res/drawable，/res/mipmap

這兩個資料夾都是用來放置圖示的，mipmap 資料夾通常用來放App的圖示，而drawable 資料夾則放app應用程式當中所使用到的其他圖檔或xml資源

> 為了加快彩現速度和減少圖像鋸齒，貼圖被處理成由一系列被預先計算和最佳化過的圖片組成的檔案,這樣的貼圖被稱為 MIP map 或者 mipmap

![Image asset](./images/week2/imageasset.png)

#### Android 單位/解析度概念

![Low pixel vs. high pixel](./images/week2/games_img004.jpg)



#### 建立圖示工具，向量與點陣圖示

### 字串文件，/res/value/strings.xml

#### 處理多國語言

## 排版編輯工具

### Widget: TextView、Button、ImageView

