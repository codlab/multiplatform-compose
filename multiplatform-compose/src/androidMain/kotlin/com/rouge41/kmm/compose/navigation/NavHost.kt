package com.rouge41.kmm.compose.navigation

import com.rouge41.kmm.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController as _rememberNavController
import androidx.navigation.compose.NavHost as _NavHost
import androidx.navigation.compose.composable as _composable

actual typealias Bundle = android.os.Bundle
actual typealias NavController = androidx.navigation.NavController
actual typealias NavHostController = androidx.navigation.NavHostController
actual typealias NavGraphBuilder = androidx.navigation.NavGraphBuilder
@Suppress("NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS")
actual typealias NavBackStackEntry =  androidx.navigation.NavBackStackEntry
actual typealias NavDeepLink =  androidx.navigation.NavDeepLink
actual typealias NamedNavArgument =  androidx.navigation.NamedNavArgument
actual typealias NavOptionsBuilder =  androidx.navigation.NavOptionsBuilder

@Composable
actual fun rememberNavController(): NavHostController = _rememberNavController()

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun NavHost(
    navController: NavHostController,
    startDestination: String,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) = _NavHost(navController = navController, startDestination = startDestination, route = route, builder = builder)

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun NavGraphBuilder.composable(
    route: String,
    title: String? = null,
    leadingButton: @Composable (() -> Unit)? = null,
    trailingButton: @Composable (() -> Unit)? = null,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) = _composable(route = route, arguments = arguments, deepLinks = deepLinks, content = content)

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun NavController.navigate(route: String, builder: NavOptionsBuilder.() -> Unit = {}) = this.navigate(route = route, builder = builder)