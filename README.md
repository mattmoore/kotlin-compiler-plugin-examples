# Kotlin Compiler Plugin Examples with Arrow Meta

This is a list of examples demonstrating some of the use cases of creating Kotlin compiler plugins with [Arrow Meta](https://github.com/arrow-kt/arrow-meta).

Compile-time checking of code is a useful feature because it allows us to catch possible issues before we try to run the program. Scala does a lot of awesome checking at compile time, but there are some things it doesn't do (such as division by zero).

## List of Completed Plugins

1. [hello-world](hello-world) - A simple hello world project created by the Arrow Meta team. Included here for educational completeness.
1. [division-by-zero](division-by-zero) - A simple plugin that detects division by zero.

## List of Upcoming Plugins

1. transformations - A simple example demonstrating how to transform the AST.
1. advanced-transformations - A more complex example of AST transformations.
