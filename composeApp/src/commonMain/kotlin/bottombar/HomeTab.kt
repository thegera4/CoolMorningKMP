package bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coolmorning.composeapp.generated.resources.GOTHICB
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.home_screen_img
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass


object HomeTab : Tab {
    override val options: TabOptions

        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }

    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    override fun Content() {

        val windowSizeClass = calculateWindowSizeClass()
        val fontSize = when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 16.sp
            WindowWidthSizeClass.Medium -> 24.sp
            else -> 30.sp
        }
        
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            Box (
                    modifier = Modifier.fillMaxSize().padding(bottom = 56.dp),
                    contentAlignment = Alignment.BottomCenter,
                ){
                Image(
                    painter = painterResource(Res.drawable.home_screen_img),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "El detalle perfecto para cada ocasión!",
                    fontSize = fontSize,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(Res.font.GOTHICB)),
                    color = Color(0xFF8D6236),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                }
        }
    }
}