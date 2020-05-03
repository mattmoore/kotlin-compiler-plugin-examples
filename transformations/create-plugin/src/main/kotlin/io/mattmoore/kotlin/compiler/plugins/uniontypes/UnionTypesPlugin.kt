package io.mattmoore.kotlin.compiler.plugins.uniontypes

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.plugins.optics.destructured
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction
import org.jetbrains.kotlin.psi.KtNamedFunction

val Meta.unionType: CliPlugin
    get() =
        "Union types" {
            meta(
                    namedFunction(::unionType) { c ->
                        Transform.replace(replacing = c, newDeclaration =
                        """|fun ${this.name}(pet: Cat)${this.returnType} =
                           |    ${this.body}
                           |""".function.syntheticScope
                        )
                    }
            )
        }

fun unionType(f: KtNamedFunction): Boolean {
    if (f.name == "greet") return true
    return false
}
