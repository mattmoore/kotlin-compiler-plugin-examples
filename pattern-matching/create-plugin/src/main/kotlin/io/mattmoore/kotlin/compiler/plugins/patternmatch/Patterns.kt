package io.mattmoore.kotlin.compiler.plugins.patternmatch

import org.jetbrains.kotlin.psi.KtWhenEntry
import org.jetbrains.kotlin.psi.KtWhenExpression

val patterns = mapOf(
        "_" to "Any"
//        """Pair\((_, \d+)\)"""
)

fun hasPatternMatch(whenEntry: KtWhenEntry) =
        whenEntry.conditions.any { condition -> patterns.any { it.key.toRegex().containsMatchIn(condition.text) } }

fun transformPatterns(whenExpression: KtWhenExpression, whenEntry: KtWhenEntry) =
    patterns.keys.fold(whenEntry.conditions.first().text) { acc, s -> acc.replace(s, patterns[s]!!) }
