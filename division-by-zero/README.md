# Division by Zero

The Kotlin compiler allows code attempting to divide by zero to succeed. However, division by zero is not a valid math operation, so we'll encounter errors at runtime. This is a simple plugin to demonstrate detection of division by zero at compile time and preventing compilation from succeeding.

## Run from the command line

```shell
cd division-by-zero
./gradlew clean :use-plugin:shadowJar
```

Compiling the example code in `use-plugin` above will fail with the following error message:

```shell
e: java.lang.Exception: Division by zero being attempted!
```

The compiler failed, because our plugin found a division by zero match. This is good. It prevents us from running our example program, where we would instead encounter division by zero at run time.

Let's examine what happens if we disable the plugin. Open and modify the file [use-plugin/build.gradle](use-plugin/build.gradle). You'll want to comment out or remove the following line:

```gradle
freeCompilerArgs = ["-Xplugin=${project.rootDir}/create-plugin/build/libs/create-plugin-all.jar"]
```

Save that file and now let's try compiling and running without the plugin:

```shell
cd division-by-zero
./gradlew clean :use-plugin:shadowJar
```

You'll notice that Kotlin allows for compiling division the code attempting division by zero. However, if you try to run the compiled jar file:

```shell
java -jar use-plugin/build/libs/use-plugin-all.jar
```

It will fail at to run with this exception:

```shell
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at io.mattmoore.kotlin.compiler.plugins.divisionbyzero.DivisionByZeroKt.divByZero(DivisionByZero.kt:5)
        at io.mattmoore.kotlin.compiler.plugins.divisionbyzero.DivisionByZeroKt.main(DivisionByZero.kt:8)
        at io.mattmoore.kotlin.compiler.plugins.divisionbyzero.DivisionByZeroKt.main(DivisionByZero.kt)
```

## The Moral of the Story

These kinds of plugins are useful because they allow us to catch errors early on at compile time rather than encountering errors at run time. This helps make our code safer.

Note that this is a very simple example, intended to show how such plugins can be made. You shouldn't rely solely on this plugin to catch all division by zero problems, as it is not thorough and will miss scenarios where dynamic division by zero is attempted. An example of this would be:

```kotlin
val x = 5
val y = 0
x / y
```

The plugin here, as written, will not catch the above as it doesn't understand that `y` happens to be assigned the value `0`. A more complex plugin would have to be written to lookup the value of `y` during compilation, which is out of the scope of this example.
