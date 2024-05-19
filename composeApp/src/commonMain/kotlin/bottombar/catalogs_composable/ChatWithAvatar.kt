package bottombar.catalogs_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatWithAvatar(clickableImg: DrawableResource, avatarImg: DrawableResource, avatarPosition: AvatarPosition) {

    Row (modifier = Modifier.fillMaxHeight())  {
        if(avatarPosition == AvatarPosition.LEFT) {
            Avatar(avatarImg)
        }
        Image(
            painter = painterResource(clickableImg),
            contentDescription = null,
            modifier = Modifier/*.fillMaxWidth()*/.width(280.dp).height(140.dp)
            /*.clickable( // TODO: When clicked, it will open a pdf viewer with the catalog (pdf file)
            indication = null, // Remove ripple effect
            interactionSource = remember { MutableInteractionSource() }
        ){
            println("Desayunos y globos")
        },*/,
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