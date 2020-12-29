package com.example.data.mappers

interface Mapper<in M, out E> {
    fun mapFrom(model:M): E
}