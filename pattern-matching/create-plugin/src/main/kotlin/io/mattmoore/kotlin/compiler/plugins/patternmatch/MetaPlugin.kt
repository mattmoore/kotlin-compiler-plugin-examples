package io.mattmoore.kotlin.compiler.plugins.patternmatch

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.phases.CompilerContext
import kotlin.contracts.ExperimentalContracts

class MetaPlugin : Meta {
    @ExperimentalContracts
    override fun intercept(ctx: CompilerContext): List<CliPlugin> =
            listOf(
                    patternMatch
            )
}
