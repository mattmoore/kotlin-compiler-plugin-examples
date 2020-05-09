package io.mattmoore.kotlin.compiler.plugins.patternmatch

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.whenExpression

val Meta.patternMatch: CliPlugin
    get() =
        "Pattern matching" {
            meta(
                    whenExpression({ entries.any(::hasPatternMatch) }) { c ->
//                        throw Exception(transformWhen(c))
                        Transform.replace(replacing = c, newDeclaration = transformWhen(c).`when`)
                    }
            )
        }
