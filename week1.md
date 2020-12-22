# Android與Kotlin語言簡介

## 安裝 Android Studio

1. 在 [https://developer.android.com/studio](https://developer.android.com/studio)下載 Android Studio 
2. 在PC/MAC上執行安裝程序
3. 由 Configure / Preferences 進入設定頁面
   * Appearance & Behavior / Appearance 設定介面風格
   * Editor / Font 設定字型

## 建立第一個專案

1. 點擊按鈕 Create New Project 來新增一個專案

![Welcome screen](.gitbook/assets/welcome.png)

1. 選擇 Empty Activity範本

![Welcome screen](.gitbook/assets/select-template.png)

1. 仔細端詳 Android Studio 開發環境

![Welcome screen](.gitbook/assets/empty_activity.png)

## 安裝虛擬機器

1. 上方工具列按下AVD Manager按鈕 ![Alt text](.gitbook/assets/avd-manager.png)，建立虛擬裝置
2. 按下 Create Viretual Device 選擇虛擬裝置大小和版本 \(需要時間下載Android版本\)
3. 啟動虛擬機器
4. 在Android Studio 執行剛剛所建立的專案

## 簡述Android專案結構

### The Manifest file 及其用途

> 位置在: \[專案\]/app/src/main/AndroidManifest.xml

1. 宣告用到的使用者權限
2. ~~宣告 minimum API Level~~
3. 宣告硬體規格需求\(前後相機鏡頭、藍芽、多點觸控\)
4. 宣告用到的外部程式庫參數
5. 宣告App使用到的元件，包含Android的四大元件

```markup
<manifest ... >
    <uses-feature android:name="android.hardware.camera.any"
                  android:required="true" />
    <uses-sdk android:minSdkVersion="7" android:targetSdkVersion="19" />
    <uses-permission android:name="android.permission.SEND_SMS"/>
    ...
</manifest>
```



🚩 **&lt;uses-feature android:name="..." android:required="..."/&gt;**

宣告硬體規格需求定義你的App

Feature reference list [https://developer.android.com/guide/topics/manifest/uses-feature-element\#features-reference](https://developer.android.com/guide/topics/manifest/uses-feature-element#features-reference)

🚩 **&lt;uses-sdk android:minSdkVersion="7" android:targetSdkVersion="19" /&gt;**

宣告使用的sdk版本，以及最低支援版本，此設定會被build.gradle中的設定給覆蓋，所以現在不需要將版本設定放在AndroidManifest.xml當中

🚩 **&lt;uses-permission android:name="android.permission.SEND\_SMS"/&gt;**

宣告所使用到的權限。用以規範受限制的權限和行為。當開發App時，需要避免宣告為使用到的權限



```markup
<?xml version="1.0" encoding="utf-8"?>
<manifest ... >
    ...
    <application ... >
        <activity android:name="com.example.project.ComposeEmailActivity">
            <intent-filter>
                <action android:name="android.intent.action.SEND" />
                <data android:type="*/*" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

🚩 **&lt;application ...&gt;**

Android 四大元件包含Activity, Service, Broadcast Receiver 和 Content Provider

* &lt;activity&gt; elements for activities.
* &lt;service&gt; elements for services.
* &lt;receiver&gt; elements for broadcast receivers.
* &lt;provider&gt; elements for content providers.

#### Intent 和 Intent filter

Android App 允許系統中其他App可以呼叫其他App，支援相關動作的元件。例如，我需要寄電子郵件時，可以呼叫其他支援電子郵件的App來幫忙處理寄件。

在實務上就是丟出一個Intent，尋求可以支援寄送的Activity來幫忙。

Web reference: [https://developer.android.com/guide/topics/manifest/manifest-intro](https://developer.android.com/guide/topics/manifest/manifest-intro)

### App resources

> 位置在：\[專案\]/app/src/main/res/

App 資源包含了圖片、聲音、多國語言字串、動畫設定、排版設定、顏色設定、風格、外部字型等。將資源檔分開將有助於管理提供不同類型的資源或修改不同的風格，而不需要動到程式碼。

{% hint style="info" %}
不能直接將檔案存在/res/底下，會造成編譯錯誤
{% endhint %}

<table>
  <thead>
    <tr>
      <th style="text-align:left">Directory</th>
      <th style="text-align:left">Resource Type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><code>color/</code>
      </td>
      <td style="text-align:left">XML files that define a state list of colors. See <a href="https://developer.android.com/guide/topics/resources/color-list-resource">Color State List Resource</a>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><code>drawable/</code>
      </td>
      <td style="text-align:left">Bitmap files (<code>.png</code>, <code>.9.png</code>, <code>.jpg</code>, <code>.gif</code>)
        or XML files See <a href="https://developer.android.com/guide/topics/resources/drawable-resource">Drawable Resources</a>.</td>
    </tr>
    <tr>
      <td style="text-align:left"><code>mipmap/</code>
      </td>
      <td style="text-align:left">Drawable files for different launcher icon densities. For more information
        on managing launcher icons with <code>mipmap/</code> folders, see <a href="https://developer.android.com/tools/projects#mipmap">Managing Projects Overview</a>.</td>
    </tr>
    <tr>
      <td style="text-align:left"><code>layout/</code>
      </td>
      <td style="text-align:left">XML files that define a user interface layout. See <a href="https://developer.android.com/guide/topics/resources/layout-resource">Layout Resource</a>.</td>
    </tr>
    <tr>
      <td style="text-align:left"><code>menu/</code>
      </td>
      <td style="text-align:left">XML files that define app menus, such as an Options Menu, Context Menu,
        or Sub Menu. See <a href="https://developer.android.com/guide/topics/resources/menu-resource">Menu Resource</a>.</td>
    </tr>
    <tr>
      <td style="text-align:left"><code>values/</code>
      </td>
      <td style="text-align:left">
        <ul>
          <li>arrays.xml for resource arrays (<a href="https://developer.android.com/guide/topics/resources/more-resources#TypedArray">typed arrays</a>).</li>
          <li>colors.xml for <a href="https://developer.android.com/guide/topics/resources/more-resources#Color">color values</a>
          </li>
          <li>dimens.xml for <a href="https://developer.android.com/guide/topics/resources/more-resources#Dimension">dimension values</a>.</li>
          <li>strings.xml for <a href="https://developer.android.com/guide/topics/resources/string-resource">string values</a>.</li>
          <li>styles.xml for <a href="https://developer.android.com/guide/topics/resources/style-resource">styles</a>.</li>
        </ul>
        <p>See <a href="https://developer.android.com/guide/topics/resources/string-resource">String Resources</a>,
          <a
          href="https://developer.android.com/guide/topics/resources/style-resource">Style Resource</a>, and <a href="https://developer.android.com/guide/topics/resources/more-resources">More Resource Types</a>.</p>
      </td>
    </tr>
  </tbody>
</table>

Web reference: [https://developer.android.com/guide/topics/resources/providing-resources](https://developer.android.com/guide/topics/resources/providing-resources)



## Build Process

當按下執行後，發生了什麼事？





