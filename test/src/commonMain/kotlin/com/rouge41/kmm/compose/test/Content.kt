package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.mutableStateOf
import com.rouge41.kmm.compose.runtime.remember
import com.rouge41.kmm.compose.ui.graphics.ImageResource
import com.rouge41.kmm.compose.test.demos.*

data class Resources(val logo: ImageResource)

@Composable
fun Content(resources: Resources) {
    Theme {
        var state = remember { mutableStateOf(true) }
        if (state.value) {
            App(state, resources)
        } else {
            Raw(state, resources)
        }
    }
}

enum class Demo {
    HelloPlatform,
    Lorem,
    LazyColumn,
    Counter,
    BackPress,
    Layout,
    TextStyles,
    Images,
//    PeopleInSpace,
    Buttons,
    Alert,
    TextFields,
    Board2048,
    // Below are dropped in navigation demos
    BottomNavigation,
    Navigation,
    App,
    Raw,
}

@Composable
expect fun Test()