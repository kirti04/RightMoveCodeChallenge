package com.rightmove.library_property.remote.base

internal interface Mapper<I, out O> {
    fun map(input: I): O
}