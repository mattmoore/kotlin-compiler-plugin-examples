# Kotlin Compiler Plugin Examples with Arrow Meta

This is a list of examples demonstrating some of the use cases of creating Kotlin compiler plugins with [Arrow Meta](https://github.com/arrow-kt/arrow-meta).

Compile-time checking of code is a useful feature because it allows us to catch possible issues before we try to run the program. Scala does a lot of awesome checking at compile time, but there are some things it doesn't do (such as division by zero).

## List of Plugins

1. [hello-world](hello-world) A simple hello world project created by the Arrow Meta team.
1. [division-by-zero](division-by-zero) A simple plugin that detects division by zero.
1. [transformations](transformations) A simple example demonstrating how to transform the AST.
