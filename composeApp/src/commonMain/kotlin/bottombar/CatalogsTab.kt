package bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import bottombar.catalogs_composable.AvatarPosition
import bottombar.catalogs_composable.ChatWithAvatar
import bottombar.catalogs_composable.Topbar_Catalogs
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.box_y_globos
import coolmorning.composeapp.generated.resources.desayunos_y_globos
import coolmorning.composeapp.generated.resources.logo1
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object CatalogsTab  : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Menu)
            return remember {
                TabOptions(
                    index = 1u,
                    title = "Catálogos",
                    icon = icon
                )
            }
        }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize().fillMaxHeight(),
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(bottom = 56.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                // Logo Background Image with Opacity
                Image(
                    painter = painterResource(Res.drawable.logo1),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alpha = 0.2f
                )
                // Topbar Composable: Small logo and text above the catalogs
                Topbar_Catalogs()
                // Scrollable Column container for the chats with avatars (catalogs)
                LazyColumn (
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(top = 100.dp)
                ){
                    item{
                        // Desayunos y globos
                        ChatWithAvatar(
                            clickableImg = Res.drawable.desayunos_y_globos,
                            avatarImg = Res.drawable.box_y_globos,
                            avatarPosition = AvatarPosition.RIGHT
                        )
                    }
                    item{
                        // Cena en columpios
                        ChatWithAvatar(
                            clickableImg = Res.drawable.desayunos_y_globos,
                            avatarImg = Res.drawable.box_y_globos,
                            avatarPosition = AvatarPosition.LEFT
                        )
                    }
                    /*item {
                        // Luces y decoracion
                        ChatWithAvatar(
                            text = "Luces y decoración",
                        )
                    }
                    item{
                        // Eventos especiales
                        ChatWithAvatar(
                            text = "Eventos especiales",
                        )
                    }*/

                }

            }

        }
    }
}