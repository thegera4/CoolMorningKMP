package bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coolmorning.composeapp.generated.resources.Res
import coolmorning.composeapp.generated.resources.logo2
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Topbar_Catalogs() {
    Image(
        painter = painterResource(Res.drawable.logo2),
        contentDescription = null,
        modifier = Modifier.padding(top = 8.dp).size(100.dp),
        alignment = Alignment.TopCenter,
    )
    Text(
        text = "Revisa nuestros catálogos y escoge tu experiencia!",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        color = Color.Black,
        modifier = Modifier.padding(top = 60.dp),
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
    )
}