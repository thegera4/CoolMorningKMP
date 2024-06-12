import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import bottombar.reusable_composable.Catalogs
import com.coolmorning.kmp.R
import coolmorning.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import java.io.File
import android.content.Context as AndroidContext

actual class PlatformContext(val androidContext: AndroidContext)

actual class Intents actual constructor(private val context: PlatformContext) {

    actual fun openWebsiteIntent(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(uri)
        }
        try {
            context.androidContext.startActivity(intent)
        } catch (e: Exception) {
            Log.e("Intents", "Error al realizar el intent del navegador", e)
        }
    }

    actual fun openFacebookIntent() {
        val facebookIntent = Intent(Intent.ACTION_VIEW).apply {
            data = android.net.Uri.parse("https://www.facebook.com/CoolMorningLaguna")
        }
        try {
            context.androidContext.startActivity(facebookIntent)
        } catch (e: Exception) {
            Log.e("Intents", "Error al abrir el intent de facebook", e)
        }
    }

    actual fun openInstagramIntent() {
        val instagramIntent = Intent(Intent.ACTION_VIEW).apply {
            data = android.net.Uri.parse("https://www.instagram.com/coolmorning")
        }
        try {
            context.androidContext.startActivity(instagramIntent)
        } catch (e: Exception) {
            Log.e("Intents", "Error al abrir el intent de instagram", e)
        }
    }

    actual fun openWhatsAppIntent() {
        val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
            data = android.net.Uri.parse("https://wa.me/528711390732?text=Hola,%20me%20gustaría%20hacer%20un%20pedido...")
        }
        try {
            context.androidContext.startActivity(whatsappIntent)
        } catch (e: Exception) {
            Log.e("Intents", "Error al abrir el intent de whatsapp", e)
        }
    }

    actual fun openEmailIntent() {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("fatme.sabag@coolmorning.com.mx"))
            putExtra(Intent.EXTRA_SUBJECT, "Pedido de cool morning")
            putExtra(Intent.EXTRA_TEXT, "Hola, me gustaría hacer un pedido...")
        }
        try {
            context.androidContext.startActivity(Intent.createChooser(emailIntent, "Enviar Email"))
        } catch (e: Exception) {
            Log.e("Intents", "Error al abrir el intent de email", e)
        }
    }

    actual fun openPdfIntent(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(uri)
        }
        try {
            context.androidContext.startActivity(intent)
        } catch (e: Exception) {
            Log.e("Intents", "Error al realizar el intent", e)
        }
    }

}