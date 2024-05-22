package bottombar

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
//import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
//import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(HomeTab, CatalogsTab, ContactTab)
                )
            }
        ) {
            Scaffold(
                //topBar = {TopAppBar(title = { Text(it.current.options.title) },)},
                bottomBar = {
                    BottomNavigation {
                        val tabNavigator = LocalTabNavigator.current
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == HomeTab.key,
                            label = { Text(HomeTab.options.title) },
                            icon = { Icon(
                                        painter = HomeTab.options.icon!!,
                                        contentDescription = null,
                                    )},
                            onClick = { tabNavigator.current = HomeTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color(0xFF8D6236),
                            selectedContentColor = Color(0xFF04A595),
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == CatalogsTab.key,
                            label = { Text(CatalogsTab.options.title) },
                            icon = { Icon(
                                        painter = CatalogsTab.options.icon!!,
                                        contentDescription = null
                                    )},
                            onClick = { tabNavigator.current = CatalogsTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color(0xFF8D6236),
                            selectedContentColor = Color(0xFF04A595),
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == ContactTab.key,
                            label = { Text(ContactTab.options.title) },
                            icon = { Icon(
                                        painter = ContactTab.options.icon!!,
                                        contentDescription = null
                                    )},
                            onClick = { tabNavigator.current = ContactTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color(0xFF8D6236),
                            selectedContentColor = Color(0xFF04A595),
                            alwaysShowLabel = false
                        )
                    }
                },
                content = {
                    val tabNavigator = LocalTabNavigator.current
                    Crossfade(targetState = tabNavigator.current){ tab -> tab.Content() }
                }
            )
        }
    }
}