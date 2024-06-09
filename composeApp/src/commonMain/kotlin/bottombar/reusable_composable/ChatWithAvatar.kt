package bottombar.reusable_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatWithAvatar(
    clickableImg: DrawableResource, avatarImg: DrawableResource,
    avatarPosition: AvatarPosition, imgWidth: Dp,
    imgHeight: Dp
) {


    Row (
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    )  {
        if(avatarPosition == AvatarPosition.LEFT) {
            Avatar(avatarImg)
        }
        Image(
            painter = painterResource(clickableImg),
            contentDescription = null,
            modifier = Modifier.width(imgWidth).height(imgHeight).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )  {
                //open pdf
            },
            alignment = Alignment.Center,
        )
        Spacer(modifier = Modifier.width(4.dp))
        if(avatarPosition == AvatarPosition.RIGHT) {
            Avatar(avatarImg)
        }
    }
}

enum class AvatarPosition {
    LEFT, RIGHT
}

/*enum class Catalogs {
    DESAYUNOS_Y_GLOBOS, CENA_EN_COLUMPIOS, LUCES_Y_DECORACION, EVENTOS_ESPECIALES
}*/