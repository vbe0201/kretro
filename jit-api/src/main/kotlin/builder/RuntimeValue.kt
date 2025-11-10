package io.github.vbe0201.kretro.jit.builder

/**
 * A value that lives in the context of generated code.
 *
 * Operations performed on [RuntimeValue]s do not execute their computations
 * immediately. Instead, they will emit the respective operations to the code
 * builder for them to be performed when the JIT runs.
 *
 * This enables a natural programming style for code generation which is both
 * maintainable and easy to pick up without needing to be familiar with the
 * intricacies of the targeted backend.
 */
interface RuntimeValue<T> {
    operator fun plus(rhs: RuntimeValue<T>): RuntimeValue<T>
    operator fun minus(rhs: RuntimeValue<T>): RuntimeValue<T>
    operator fun times(rhs: RuntimeValue<T>): RuntimeValue<T>
    operator fun div(rhs: RuntimeValue<T>): RuntimeValue<T>
    operator fun rem(rhs: RuntimeValue<T>): RuntimeValue<T>

    infix fun and(other: RuntimeValue<T>): RuntimeValue<T>
    infix fun or(other: RuntimeValue<T>): RuntimeValue<T>
    infix fun xor(other: RuntimeValue<T>): RuntimeValue<T>
    infix fun shl(other: RuntimeValue<T>): RuntimeValue<T>
    infix fun shr(other: RuntimeValue<T>): RuntimeValue<T>
    infix fun ushr(other: RuntimeValue<T>): RuntimeValue<T>
    fun inv(): RuntimeValue<T>

    infix fun eq(other: RuntimeValue<T>): RuntimeValue<Boolean>
    infix fun ne(other: RuntimeValue<T>): RuntimeValue<Boolean>
    infix fun lt(other: RuntimeValue<T>): RuntimeValue<Boolean>
    infix fun le(other: RuntimeValue<T>): RuntimeValue<Boolean>
    infix fun gt(other: RuntimeValue<T>): RuntimeValue<Boolean>
    infix fun ge(other: RuntimeValue<T>): RuntimeValue<Boolean>

    /**
     * Casts this value to a different one by sign extension.
     *
     * If [U] is smaller than [T], the value will be truncated.
     */
    fun <U> zeroExtend(): RuntimeValue<U>

    /**
     * Casts this value to a different one by zero extension.
     *
     * If [U] is smaller than [T], the value will be truncated.
     */
    fun <U> signExtend(): RuntimeValue<U>
}
