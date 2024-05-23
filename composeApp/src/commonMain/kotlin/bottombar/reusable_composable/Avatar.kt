package bottombar.reusable_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Avatar(avatarImg: DrawableResource){
    Column(
        modifier = Modifier.fillMaxHeight()
    ){
        Image(
            painter = painterResource(avatarImg),
            contentDescription = null,
            modifier = Modifier.size(48.dp).clip(CircleShape),
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}