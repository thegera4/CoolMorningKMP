package com.coolmorning.kmp

import App
import LocalPlatform
import PlatformContext
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import bottombar.ContactTab


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Enable edge-to-edge (fullscreen) display
        enableEdgeToEdge()

        // Hide the system bar (android bottom bar with 3 buttons) and make it appear when swiping up
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.navigationBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(LocalPlatform provides PlatformContext(this)) {
                ContactTab.Content()
                App()
            }

        }
    }
}