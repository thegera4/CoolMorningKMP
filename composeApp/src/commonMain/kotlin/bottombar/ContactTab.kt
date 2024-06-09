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
import androidx.compose.material.icons.filled.Call
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
import bottombar.reusable_composable.Screens_Topbar
import bottombar.reusable_composable.Social_Clickable
import bottombar.reusable_composable.Socials
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.contact_background
import coolmorning.composeapp.generated.resources.facebook
import coolmorning.composeapp.generated.resources.gmail
import coolmorning.composeapp.generated.resources.instagram
import coolmorning.composeapp.generated.resources.whatsapp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object ContactTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Call)
            return remember {
                TabOptions(
                    index = 2u,
                    title = "Contacto",
                    icon = icon
                )
            }
        }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalResourceApi::class)
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
                    painter = painterResource(Res.drawable.contact_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                Column {
                    Screens_Topbar(
                        text = "Estamos a tus ordenes!",
                        fontSize = fontSize
                    )
                    LazyColumn (
                        modifier = Modifier.fillMaxHeight().fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                    ){
                        item{
                            Social_Clickable(
                                clickableImg = Res.drawable.whatsapp,
                                social = Socials.WHATSAPP,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext
                            )
                        }
                        item{
                            Social_Clickable(
                                clickableImg = Res.drawable.instagram,
                                social = Socials.INSTAGRAM,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext
                            )
                        }
                        item{
                            Social_Clickable(
                                clickableImg = Res.drawable.facebook,
                                social = Socials.FACEBOOK,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext
                            )
                        }
                        item{
                            Social_Clickable(
                                clickableImg = Res.drawable.gmail,
                                social = Socials.EMAIL,
                                imgWidth = imgWidth,
                                imgHeight = imgHeight,
                                context = platformContext
                            )
                        }
                    }
                }
            }
        }
    }
}