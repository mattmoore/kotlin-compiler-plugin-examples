package io.mattmoore.kotlin.compiler.plugins.helloworld

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.phases.CompilerContext
import io.mattmoore.kotlin.compiler.plugins.helloworld.helloWorld
import kotlin.contracts.ExperimentalContracts

class MetaPlugin : Meta {
    @ExperimentalContracts
    override fun intercept(ctx: CompilerContext): List<CliPlugin> =
            listOf(
                    helloWorld
            )
}
