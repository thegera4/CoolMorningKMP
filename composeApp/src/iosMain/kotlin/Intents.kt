import bottombar.reusable_composable.Catalogs

actual class PlatformContext

actual class Intents actual constructor(context: PlatformContext) {
    actual fun openEmailIntent() {
        println("Email intent not implemented for iOS yet.")
    }

    actual fun openFacebookIntent() {
        println("Facebook intent not implemented for iOS yet.")
    }

    actual fun openInstagramIntent() {
        println("Instagram intent not implemented for iOS yet.")
    }

    actual fun openWhatsAppIntent() {
        println("WhatsApp intent not implemented for iOS yet.")
    }

    actual fun openPdfIntent(uri: String) {
        println("Pdf intent not implemented for iOS yet.")
    }
}