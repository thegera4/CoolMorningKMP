actual class PlatformContext

actual class Intents actual constructor(context: PlatformContext){
    actual fun openEmailIntent() {
        println("Email intent for desktop...not gonna happen...")
    }

    actual fun openFacebookIntent() {
        println("Facebook intent for desktop...not gonna happen...")
    }

    actual fun openInstagramIntent() {
        println("Instagram intent for desktop...not gonna happen...")
    }

    actual fun openWhatsAppIntent() {
        println("WhatsApp intent for desktop...not gonna happen...")
    }
}