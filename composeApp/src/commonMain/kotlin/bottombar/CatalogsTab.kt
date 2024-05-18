package bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.logo1
import coolmorning.composeapp.generated.resources.desayunos_y_globos
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

                // "Chat" - Catalog selection section

                // First Row Composable: Image (Catalog button) and Avatar
                Row(
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 150.dp),
                ){
                    // Chat 1, when clicked, it will open a pdf viewer with the catalog (pdf file)
                    Image(
                        painter = painterResource(Res.drawable.desayunos_y_globos),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().width(150.dp).height(140.dp)
                            .clickable(
                                indication = null, // Remove ripple effect
                                interactionSource = remember { MutableInteractionSource() }
                            ){
                                println("Desayunos y globos")
                            },
                        alignment = Alignment.Center,
                    )
                    // Space between image and avatar
                    Spacer(modifier = Modifier.width(8.dp))
                    // Avatar 1
                    Image(
                        painter = painterResource(Res.drawable.logo1),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp).clip(CircleShape),
                    )
                }
            }

        }
    }
}