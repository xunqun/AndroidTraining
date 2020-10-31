---
description: 變數、函式、型態、判斷
---



# Kotlin I

{{TOC}}

參考範例 Lessons/src/main/kotlin/kotlin_I.py

## Kotlin 程式檔

```kotlin
package com.whiles.sample
import kotlin.random.Random

var variable: Int = 5 
fun main() { /*...*/ }
class Message { /*...*/ }
```

- Package
	- Package 定義了該檔案的所處階層路徑
- import
	- 所引用的外部程式庫
	- https://kotlinlang.org/api/latest/jvm/stdlib/
- fun main()
	- 主要程式進入點

## 變數 (Variable)

```kotlin
//宣告字串
val greeting: String = "hello kotlin"
println(greeting)

//宣告整數
val number: Int = 3
println(number)

val one = 1 // Int
val threeBillion = 3000000000 // Long
val oneLong = 1L // Long
val oneByte: Byte = 1
 
```


### 整數變數型態[^1]

| Type | Size (bits) | Min value | Max value |
|:--|:--|:--|:--|
| Byte | 8 | -128 | 127 |
| Short| 16 | -32768 | 32767 |
| Int | 32 | -2,147,483,648 (-2^31) | 2,147,483,647 (2^31-1) |
| Long | 64 | -9,223,372,036,854,775,808 (-2^63) | 9,223,372,036,854,775,807 (2^63-1) |

```kotlin
//宣告float變數
val floatNum = 10f
println(floatNum)

//宣告double變數
val doubleNum = 10.0
print(doubleNum)

val pi = 3.14 // Double
val e = 2.7182818284 // Double
> val eFloat = 2.7182818284f // Float, actual value is 2.7182817
```

### 浮點數變數型態[^1]

| Type | Size (bits) | Significant bits | Exponent bits |Decimal digits|
|:--|:--|:--|:--|:--|
| Float | 32 | 24 | 8 | 6-7|
|	Double|	64	|53	|11	|15-16|

### 重新給值


```kotlin
// 可重新指派變數
var value = 6
value = 10
```
變數宣告為var時，可以重新給值，宣告為val則否

## 引用程式庫[^2]

```kotlin

//宣告程式庫
import kotlin.random.Random

// 取得1-100間隨機整數
val randomInt = Random.nextInt(1, 100)

// 取得0-1間隨機Float
val randomFloat = Random.nextFloat()
```

A number of packages are imported into every Kotlin file by default[^3]:

- kotlin.*
- kotlin.annotation.*
- kotlin.collections.*
- kotlin.comparisons.* (since 1.1)
- kotlin.io.*
- kotlin.ranges.*
- kotlin.sequences.*
- kotlin.text.*

## 全域(Global)和區域(Local) 變數

```kotlin
var globalValue = 1 //全域變數
foobar1()
foobar2()

fun foobar1(){
    val localValue = 2  //區域變數
    globalValue = 3 //改變全域變數
    println(localValue)
    println(globalValue)
}

fun foobar2(){
    val localValue = 4
    val globalValue = 5 //可取和全域變數同名，但效用只限於此函數
    println(localValue)
    println(globalValue)
}
```

- 在函式內部的變數宣告，效用只限於函式內部

## 型態轉換

```kotlin
val a: Int? = 1 
val b: Long? = a //錯誤！無法將Int指派給Long
```

```kotlin
val a: Int = 1
val b: Long? = a.toLong() //須先轉換到正確的型態
```	
	
Every number type supports the following conversions:

- toByte(): Byte
- toShort(): Short
- toInt(): Int
- toLong(): Long
- toFloat(): Float
- toDouble(): Double
- toChar(): Char	


## 運算子

```kotlin
val l = 1L + 3 // Long + Int => Long
```

```kotlin
val x = 5 / 2
//println(x == 2.5) // ERROR: Operator '==' cannot be applied to 'Int' and 'Double'
println(x == 2)
```

[^1]: [Kotlin Basic Types](https://kotlinlang.org/docs/reference/basic-types.html#numbers)
[^2]: [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/)
[^3]: [Kotlin Default Import](https://kotlinlang.org/docs/reference/packages.html#default-imports)

## 字串樣板 (String template)

```kotlin
var a = 1
// simple name in template:
val s1 = "a is $a" 

a = 2
// arbitrary expression in template:
val s2 = "${s1.replace("is", "was")}, but now is $a"*‌*
```

## 條件
### if ... else ...
```kotlin
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
```

```kotlin
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```

## 空值

> 允許回傳空值

```kotlin
fun parseInt(str: String): Int? {
    // ...
}
```

> 需要針對可能空值的變數進行檢查，比避免發生程式崩潰

```kotlin
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }    
}
```

## 檢查型態

```kotlin
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}
```

# 實作篇



