import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mattmoore.kotlin.compiler.plugins.helloworld.helloWorld

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MetaPluginSpec : StringSpec({
    "Meta hello world test" {
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        helloWorld()
        out.toString() shouldBe "Hello ΛRROW Meta!\n"
    }
})
