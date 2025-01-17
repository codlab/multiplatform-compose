package com.rouge41.kmm.compose.runtime

import com.rouge41.kmm.compose.ios.getCurrentController
import com.rouge41.kmm.compose.ios.refreshContent
import kotlin.reflect.KProperty

// simple cache implementation
val cache = HashMap<String, Any>()

@Composable
actual fun <T> remember(calculation: () -> T): T {
    val controller = getCurrentController()
    val key = "$controller ${calculation::class}"
    return if (cache[key] != null) {
        cache[key] as T
    } else {
        val value = calculation()
        cache[key] = value as Any
        value
    }
}

actual fun <T> mutableStateOf(value: T): MutableState<T> {
    return iosMutableState(value = value)
}

actual operator fun <T> MutableState<T>.getValue(thisObj: Any?, property: KProperty<*>): T = value
actual operator fun <T> MutableState<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T) {
    this.value = value
    refreshContent()
}

actual interface MutableState<T> {
    actual var value: T
}

class iosMutableState<T>(value: T) : MutableState<T> {
    private var _value: T = value
    override var value: T
        get() = _value
        set(value) {
            _value = value
            refreshContent()
        }
}