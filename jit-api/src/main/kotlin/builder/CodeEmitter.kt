package io.github.vbe0201.kretro.jit.builder

import java.lang.invoke.MethodHandle

/**
 * Dynamically composes JIT code at runtime.
 *
 * This class is responsible for managing [RuntimeValue]s and translating the
 * operations performed on them into executable code. The public API surface
 * of this class provides the high-level building blocks for code, which are
 * recorded and returned as a [ByteArray] of unspecified contents.
 *
 * Subclasses are responsible for implementing these operations and doing the
 * appropriate translations to a chosen target.
 */
interface CodeEmitter {
    /**
     * Finishes the emission and returns the resulting code buffer.
     *
     * This should also reset the [CodeEmitter] object to a state where it
     * can be re-used for generation of another code buffer.
     */
    fun finish(): ByteArray

    /** Starts a new block with a given name. */
    fun block(name: String)

    /** Gets a block call argument as a [RuntimeValue] by index. */
    fun arg(index: Int): RuntimeValue<*>

    /** Terminates the current block context by returning a value. */
    fun ret(value: RuntimeValue<*>)

    /** Makes a given constant accessible as a [RuntimeValue] in the code. */
    fun <T> const(value: T): RuntimeValue<T>

    /**
     * Emits the conditional execution of [Conditional.then] code if [cond]
     * is fulfilled, else [Conditional.otherwise].
     *
     * Both callbacks are optional here and code will be emitted based on
     * the presence of the branches. If no branch is given, this is a no-op
     * and [cond] may not be evaluated at all if no other code depends on it.
     */
    fun conditional(cond: RuntimeValue<Boolean>, action: Conditional.() -> Unit)

    /**
     * Emits a call to the given [func] represented by its [MethodHandle].
     *
     * Users are advised to cache their handles if there are methods where
     * calls are emitted often.
     */
    fun call(func: MethodHandle, vararg args: RuntimeValue<*>): RuntimeValue<*>
}
