package io.mattmoore.kotlin.compiler.plugins.patternmatch

//metadebug

fun main() {
    val x = 2

//    when {
//        x is Any && x == 2 -> println("TEST")
//    }

    when (x) {
        1 -> println("exact match")
        is _ -> println("wildcard match")
    }

    // Rewritten as:

//    when (x) {
//        1 -> println("exact match")
//        is Any -> println("wildcard match")
//    }

    // or possibly:

//    when {
//        x == 1 -> println("match")
//        x is Any -> println("wildcard match")
//    }

    // with pairs:

//    val y = Pair(1, 2)
//
//    when (y) {
//        is Pair<Any, Int> -> println("exact match")
//        is Pair(_, 2) -> println("wildcard match")
//    }

    // rewrite:

//    when {
//        y is Pair<Any, Int> && (y.second == 2) -> println("wildcard match rewritten")
//    }
}
