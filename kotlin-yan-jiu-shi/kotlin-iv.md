# 基本變數

## Collection types

* A read-only interface that provides operations for accessing collection elements.
* A mutable interface that extends the corresponding read-only interface with write operations: adding, removing, and updating its elements.

### List

Read-only list

```kotlin
val numbers = listOf("one", "two", "three", "four")
println("Number of elements: ${numbers.size}")
println("Third element: ${numbers.get(2)}")
println("Fourth element: ${numbers[3]}")
println("Index of element \"two\" ${numbers.indexOf("two")}")
```

Mutable list

```kotlin
val numbers = mutableListOf("one", "two", "three", "four")
numbers.add("five")
```

### Set

### Map

