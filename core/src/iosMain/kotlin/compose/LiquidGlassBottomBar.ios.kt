package compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import compose.models.AppTabItem
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.*
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun LiquidGlassBottomBar(
    modifier: Modifier,
    tabs: List<AppTabItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
) {
    val currentOnSelect = rememberUpdatedState(onSelect)

    val delegate = remember {
        object : NSObject(), UITabBarDelegateProtocol {
            override fun tabBar(tabBar: UITabBar, didSelectItem: UITabBarItem) {
                val index = tabBar.items?.indexOf(didSelectItem) ?: 0
                currentOnSelect.value(index)
            }
        }
    }

    UIKitView(
        modifier = modifier,
        factory = {
            val container = UIView().apply {
                backgroundColor = UIColor.whiteColor
                setOpaque(false)
            }

            val tabBar = UITabBar().apply {
                items = tabs.map { tab ->
                    UITabBarItem(
                        title = tab.title,
                        image = UIImage.systemImageNamed(name = tab.iconName)?.imageWithRenderingMode(
                            UIImageRenderingMode.UIImageRenderingModeAlwaysTemplate
                        ),
                        selectedImage = UIImage.systemImageNamed(name = tab.selectedIcon)?.imageWithRenderingMode(
                            UIImageRenderingMode.UIImageRenderingModeAlwaysOriginal
                        )
                    )
                }
                selectedItem = items?.get(selectedIndex) as? UITabBarItem
                this.delegate = delegate
                setTranslucent(true)
            }

            container.addSubview(tabBar)

            tabBar.translatesAutoresizingMaskIntoConstraints = false

            NSLayoutConstraint.activateConstraints(
                listOf(
                    tabBar.leadingAnchor.constraintEqualToAnchor(container.leadingAnchor),
                    tabBar.trailingAnchor.constraintEqualToAnchor(container.trailingAnchor),
                    tabBar.bottomAnchor.constraintEqualToAnchor(container.bottomAnchor)
                )
            )

            container
        },
        update = { view ->
            val tabBar = view.subviews.firstOrNull { it is UITabBar } as UITabBar
            tabBar.selectedItem = tabBar.items?.get(selectedIndex)as? UITabBarItem
        }
    )
}