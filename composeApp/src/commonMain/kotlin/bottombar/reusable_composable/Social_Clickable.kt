package bottombar.reusable_composable

import Intents
import PlatformContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Social_Clickable(
    clickableImg: DrawableResource,
    social: Socials,
    imgWidth: Dp,
    imgHeight: Dp,
    context: PlatformContext
){
    val intents = Intents(context)

    Row (
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    )  {
        Image(
            painter = painterResource(clickableImg),
            contentDescription = null,
            modifier = Modifier
                .width(imgWidth)
                .height(imgHeight)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )  {
                    openSocial(social, intents)
                },
            alignment = Alignment.Center,
        )
    }
}

fun openSocial(social: Socials, intents: Intents) {
    when (social) {
        Socials.FACEBOOK -> { intents.openFacebookIntent() }
        Socials.INSTAGRAM -> { intents.openInstagramIntent() }
        Socials.WHATSAPP -> { intents.openWhatsAppIntent() }
        Socials.EMAIL -> { intents.openEmailIntent() }
    }
}

enum class Socials {
    FACEBOOK, INSTAGRAM, WHATSAPP, EMAIL
}