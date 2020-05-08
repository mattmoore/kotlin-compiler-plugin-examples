# Pattern Matching

The goal of this Arrow Meta plugin is to support pattern matching in Kotlin.

## What is Pattern Matching?

Without pattern matching:

```kotlin
when (x) {
    is Int -> //...
    is Any -> //...
}
```

With pattern matching:

```kotlin
when (x) {
    Int -> //...
    _ -> //...
}
```

## Run from the command line

```shell
cd pattern-matching
./gradlew clean :use-plugin:shadowJar
```
