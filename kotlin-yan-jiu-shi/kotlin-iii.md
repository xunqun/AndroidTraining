# 基本變數

## 物件導向 \(Object oriented programming\)

### 類別\(Class\)

物件的製作藍圖

```kotlin
class Person { 

}
```

### 建構子\(Constructor\)

```kotlin
class Person {
    constructor(name: String){
        /** do something **/
    }
}
```

```kotlin
class Person constructor(firstName: String) { 
        init {
        /** do something **/
    }
}
```

當建構子沒有其他modifier宣告時，可以省略

```kotlin
class Person(firstName: String) { 
        init {
        /** do something **/
    }
}
```

把建構子的參數當作是類別成員

```kotlin
class Person(val firstName: String) { 
        init {
        /** do something **/
    }
}
```

有好幾個建構子參數

```kotlin
class Person(val name: String, val age: Int, val weight: Int, val height: Int,) {
    init {
        /** do something **/
    }
}
```

### Declaring Properties

```kotlin
class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"

    fun copyAddress(address: Address): Address {
            val result = Address() 
            result.name = address.name // accessors are called
            result.street = address.street
            // ...
            return result
        }
}
```

Getter/Setter

```kotlin
var zip: String = "123456"
    set(value) {
        if(validation(value)) {
            field = value
        }else{
            field = "0"
        }
    }

val formatedAddress: String
    get() = "$zip $state $city $street"
```

Compile-Time Constants

* Top-level, or member of an object declaration or a companion object.
* Initialized with a value of type String or a primitive type
* No custom getter

```kotlin
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { ... }
```

Late-Initialized Properties and Variables

```kotlin
public class MyTest {
    lateinit var subject: TestSubject

    @SetUp fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()  // dereference directly
    }
}
```

檢查 lateinit 變數是否已經初始化

```kotlin
if(this::name.isInitialized){...}
```

### Inheritance

```kotlin
open class Base(p: Int){
    ...
}

class Derived(p: Int) : Base(p){
    ...
}
```

Function override

```kotlin
open class Shape {
    open fun draw() { /*...*/ }
    fun fill() { /*...*/ }
}

class Circle() : Shape() {
    override fun draw() { /*...*/ }
}
```

Properties override

You can also override a val property with a var property, but not vice versa. This is allowed because a val property essentially declares a get method, and overriding it as a var additionally declares a set method in the derived class.

```kotlin
open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount = 4
}
```

Calling the superclass implementation

```kotlin
open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}
```

Abstract classes

```kotlin
open class Polygon {
    open fun draw() {}
}

abstract class Rectangle : Polygon() {
    abstract override fun draw()
}
```

