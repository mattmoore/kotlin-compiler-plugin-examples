package io.mattmoore.kotlin.compiler.plugins.divisionbyzero

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.binaryExpression
import org.jetbrains.kotlin.psi.KtBinaryExpression

fun divisionByZeroMatcher(expression: KtBinaryExpression): Boolean =
        expression.operationReference.textMatches("/")
                && expression.right?.textMatches("0") ?: false

val Meta.divisionByZero: CliPlugin
    get() =
        "Detect division by zero" {
            meta(
                    binaryExpression(::divisionByZeroMatcher) {
                        throw ArithmeticException("/ by zero")
                    }
            )
        }
