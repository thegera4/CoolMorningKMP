import androidx.compose.runtime.staticCompositionLocalOf

expect class PlatformContext

expect class Intents(context: PlatformContext) {
    fun openFacebookIntent()
    fun openInstagramIntent()
    fun openWhatsAppIntent()
    fun openEmailIntent()

}

val LocalPlatform = staticCompositionLocalOf<PlatformContext> {
    error("No PlatformContext provided")
}