package bottombar

import LocalPlatform
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
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bottombar.reusable_composable.AvatarPosition
import bottombar.reusable_composable.Catalogs
import bottombar.reusable_composable.ChatWithAvatar
import bottombar.reusable_composable.Screens_Topbar
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.desayunos_y_globos
import coolmorning.composeapp.generated.resources.cena_en_columpios
import coolmorning.composeapp.generated.resources.luces_y_decoracion
import coolmorning.composeapp.generated.resources.eventos_especiales
import coolmorning.composeapp.generated.resources.logo1
import coolmorning.composeapp.generated.resources.box_y_globos
import coolmorning.composeapp.generated.resources.columpios
import coolmorning.composeapp.generated.resources.luces
import coolmorning.composeapp.generated.resources.especiales
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

    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    override fun Content() {

        val platformContext = LocalPlatform.current

        val windowSizeClass = calculateWindowSizeClass()

        val imgWidth = when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 280.dp
            else -> 450.dp
        }

        val imgHeight = when (windowSizeClass.heightSizeClass) {
            WindowHeightSizeClass.Compact -> 140.dp
            WindowHeightSizeClass.Medium -> 140.dp
            else -> 210.dp
        }

        val fontSize = when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 15.sp
            else -> 20.sp
        }

        Column(modifier = Modifier.fillMaxSize().fillMaxHeight()) {
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
                Column {
                    Screens_Topbar(
                        text = "Revisa nuestros catálogos y escoge tu experiencia!",
                        fontSize = fontSize
                    )
                    LazyColumn (
                        modifier = Modifier.fillMaxHeight().fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                    ){
                        item{
                            ChatWithAvatar(
                                clickableImg = Res.drawable.desayunos_y_globos,
                                avatarImg = Res.drawable.box_y_globos,
                                avatarPosition = AvatarPosition.RIGHT,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext,
                                catalog = Catalogs.DESAYUNOS_Y_GLOBOS
                            )
                        }
                        item{
                            ChatWithAvatar(
                                clickableImg = Res.drawable.cena_en_columpios,
                                avatarImg = Res.drawable.columpios,
                                avatarPosition = AvatarPosition.LEFT,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext,
                                catalog = Catalogs.CENA_EN_COLUMPIOS
                            )
                        }
                        item{
                            ChatWithAvatar(
                                clickableImg = Res.drawable.luces_y_decoracion,
                                avatarImg = Res.drawable.luces,
                                avatarPosition = AvatarPosition.RIGHT,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext,
                                catalog = Catalogs.LUCES_Y_DECORACION
                            )
                        }
                        item{
                            ChatWithAvatar(
                                clickableImg = Res.drawable.eventos_especiales,
                                avatarImg = Res.drawable.especiales,
                                avatarPosition = AvatarPosition.LEFT,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext,
                                catalog = Catalogs.EVENTOS_ESPECIALES
                            )
                        }
                    }
                }
            }
        }
    }
}