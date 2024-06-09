import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import bottombar.BottomBarScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(BottomBarScreen() as Screen)
    }
}