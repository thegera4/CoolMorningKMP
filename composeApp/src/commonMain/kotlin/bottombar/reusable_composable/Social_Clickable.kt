package bottombar.reusable_composable

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
fun Social_Clickable(clickableImg: DrawableResource, social: Socials, imgWidth: Dp, imgHeight: Dp ){
    Row (
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    )  {
        Image(
            painter = painterResource(clickableImg),
            contentDescription = null,
            modifier = Modifier.width(imgWidth).height(imgHeight).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )  {
                println(social)
                // TODO: Intent to open the social media app (Facebook, Instagram, WhatsApp, Email)
            },
            alignment = Alignment.Center,
        )
    }
}

enum class Socials {
    FACEBOOK, INSTAGRAM, WHATSAPP, EMAIL
}