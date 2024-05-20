package bottombar.catalogs_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatWithAvatar(clickableImg: DrawableResource, avatarImg: DrawableResource,
                   avatarPosition: AvatarPosition, catalog: Catalogs) {

    Row (modifier = Modifier.fillMaxHeight())  {
        if(avatarPosition == AvatarPosition.LEFT) {
            Avatar(avatarImg)
        }
        Image(
            painter = painterResource(clickableImg),
            contentDescription = null,
            modifier = Modifier.width(280.dp).height(140.dp)
            .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ){
            println(catalog)
            // TODO: When clicked, it will open a pdf viewer with the catalog (pdf file)
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

enum class Catalogs {
    DESAYUNOS_Y_GLOBOS, CENA_EN_COLUMPIOS, LUCES_Y_DECORACION, EVENTOS_ESPECIALES
}