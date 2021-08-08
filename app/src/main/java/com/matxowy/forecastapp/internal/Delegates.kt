package com.matxowy.forecastapp.internal

import kotlinx.coroutines.*

/*
Funkcja lazy, która dodatkowo jest deferred
 */
fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}