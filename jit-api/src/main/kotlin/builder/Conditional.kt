package io.github.vbe0201.kretro.jit.builder

/**
 * A helper for emitting conditional code based on the evaluation result
 * of a [RuntimeValue].
 */
data class Conditional(val cond: RuntimeValue<Boolean>) {
    /** The branch to be taken when [cond] is fulfilled. */
    var then: (CodeEmitter.() -> Unit)? = null

    /** The branch to be taken when [cond] is not fulfilled. */
    var otherwise: (CodeEmitter.() -> Unit)? = null
}
