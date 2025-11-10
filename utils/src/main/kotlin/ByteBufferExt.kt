package io.github.vbe0201.kstation.utils

import java.nio.ByteBuffer

/** Reads a [UByte] from the current cursor position. */
fun ByteBuffer.uget(): UByte {
    return this.get().toUByte()
}

/** Reads a [UByte] from the given [index]. */
fun ByteBuffer.uget(index: Int): UByte {
    return this.get(index).toUByte()
}

/** Reads a [UByte] from the current cursor position. */
fun ByteBuffer.getUShort(): UShort {
    return this.getShort().toUShort()
}

/** Reads a [UShort] value from the given [index]. */
fun ByteBuffer.getUShort(index: Int): UShort {
    return this.getShort(index).toUShort()
}

/** Reads a [UInt] value from the current cursor position. */
fun ByteBuffer.getUInt(): UInt {
    return this.getInt().toUInt()
}

/** Reads a [UInt] value from the given [index]. */
fun ByteBuffer.getUInt(index: Int): UInt {
    return this.getInt(index).toUInt()
}

/** Reads a [ULong] value from the current cursor position. */
fun ByteBuffer.getULong(): ULong {
    return this.getLong().toULong()
}

/** Reads a [ULong] value from the given [index]. */
fun ByteBuffer.getULong(index: Int): ULong {
    return this.getLong(index).toULong()
}

/** Writes a [UByte] value to the current cursor position. */
fun ByteBuffer.uput(value: UByte) {
    this.put(value.toByte())
}

/** Writes a [UByte] value to the given [index]. */
fun ByteBuffer.uput(index: Int, value: UByte) {
    this.put(index, value.toByte())
}

/** Writes a [UShort] value to the current cursor position. */
fun ByteBuffer.putUShort(value: UShort) {
    this.putShort(value.toShort())
}

/** Writes a [UShort] value to the given [index]. */
fun ByteBuffer.putUShort(index: Int, value: UShort) {
    this.putShort(index, value.toShort())
}

/** Writes a [UInt] value to the current cursor position. */
fun ByteBuffer.putUInt(value: UInt) {
    this.putInt(value.toInt())
}

/** Writes a [UInt] value to the given [index]. */
fun ByteBuffer.putUInt(index: Int, value: UInt) {
    this.putInt(index, value.toInt())
}

/** Writes a [ULong] value to the current cursor position. */
fun ByteBuffer.putULong(value: ULong) {
    this.putLong(value.toLong())
}

/** Writes a [ULong] value to the given [index]. */
fun ByteBuffer.putULong(index: Int, value: ULong) {
    this.putLong(index, value.toLong())
}
