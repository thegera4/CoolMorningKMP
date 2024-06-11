import androidx.compose.runtime.staticCompositionLocalOf
import bottombar.reusable_composable.Catalogs

expect class PlatformContext

expect class Intents(context: PlatformContext) {
    fun openFacebookIntent()
    fun openInstagramIntent()
    fun openWhatsAppIntent()
    fun openEmailIntent()
    fun openPdfIntent(uri: String)

}

val LocalPlatform = staticCompositionLocalOf<PlatformContext> {
    error("No PlatformContext provided")
}