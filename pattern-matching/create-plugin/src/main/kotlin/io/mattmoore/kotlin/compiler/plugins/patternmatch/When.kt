package io.mattmoore.kotlin.compiler.plugins.patternmatch

import org.jetbrains.kotlin.psi.KtWhenEntry
import org.jetbrains.kotlin.psi.KtWhenExpression

fun transformWhen(whenExpression: KtWhenExpression) =
        """|when ${whenSubject(whenExpression)} {
           ${transformWhenEntries(whenExpression)}
           |}
        """

fun transformWhenEntries(whenExpression: KtWhenExpression) =
        whenExpression.entries.joinToString("\n") { transformWhenEntry(whenExpression, it) }

fun transformWhenEntry(whenExpression: KtWhenExpression, whenEntry: KtWhenEntry): String =
        when (hasPatternMatch(whenEntry)) {
            true -> """|  ${transformWhenLeft(whenExpression, whenEntry)} -> ${whenEntry.expression?.text}"""
            false -> """|  ${whenEntry.text}"""
        }

fun transformWhenLeft(whenExpression: KtWhenExpression, whenEntry: KtWhenEntry): String =
        transformPatterns(whenExpression, whenEntry)

fun whenSubject(whenExpression: KtWhenExpression) =
        when {
            whenExpression.subjectExpression != null -> "(${whenExpression.subjectExpression?.text})"
            else -> ""
        }
