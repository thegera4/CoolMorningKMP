package bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
                            label = {
                                    AnimatedVisibility(
                                        visible = tabNavigator.current.key == HomeTab.key,
                                        enter = slideInVertically(initialOffsetY = { 100 }),
                                        exit = slideOutVertically(targetOffsetY = { 100 })
                                    ) {
                                        Text(HomeTab.options.title)
                                    }
                            },
                            icon = {
                                Icon(
                                    painter = HomeTab.options.icon!!,
                                    contentDescription = null,
                                )
                            },
                            onClick = { tabNavigator.current = HomeTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color.Black,
                            selectedContentColor = Color.Blue
                        )
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == CatalogsTab.key,
                            label = {
                                AnimatedVisibility(
                                    visible = tabNavigator.current.key == CatalogsTab.key,
                                    enter = slideInVertically(initialOffsetY = { 100 }),
                                    exit = slideOutVertically(targetOffsetY = { 100 })
                                ) {
                                    Text(CatalogsTab.options.title)
                                }},
                            icon = {
                                Icon(
                                    painter = CatalogsTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = { tabNavigator.current = CatalogsTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color.Black,
                            selectedContentColor = Color.Blue
                        )
                        BottomNavigationItem(
                            selected = tabNavigator.current.key == ContactTab.key,
                            label = {
                                AnimatedVisibility(
                                    visible = tabNavigator.current.key == ContactTab.key,
                                    enter = slideInVertically(initialOffsetY = { 100 }),
                                    exit = slideOutVertically(targetOffsetY = { 100 })
                                ) {
                                    Text(ContactTab.options.title)
                                } },
                            icon = {
                                Icon(
                                    painter = ContactTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = { tabNavigator.current = ContactTab },
                            modifier = Modifier.background(Color.White),
                            unselectedContentColor = Color.Black,
                            selectedContentColor = Color.Blue
                        )

                    }
                },
                content = {
                    val tabNavigator = LocalTabNavigator.current
                    Crossfade(targetState = tabNavigator.current){ tab ->
                        tab.Content()
                    }
                }
            )
        }
    }
}