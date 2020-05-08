package io.mattmoore.kotlin.compiler.plugins.uniontypes

//metadebug

data class Cat(val name: String)
data class Dog(val name: String)
class Union2<A, B>

fun greet(pet: Union2<Cat, Dog>): String =
    "Hello, ${pet.name}"

fun main() {
    println(greet(Cat("Whiskers")))
}
