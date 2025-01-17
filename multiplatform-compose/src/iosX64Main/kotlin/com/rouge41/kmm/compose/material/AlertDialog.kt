package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ios.addController
import com.rouge41.kmm.compose.ios.getCurrentController
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.graphics.Shape
import platform.UIKit.*

@Composable
actual fun AlertDialog(
        onDismissRequest: () -> Unit,
        confirmButton: @Composable () -> Unit,
        modifier: Modifier,
        dismissButton: @Composable (() -> Unit)?,
        title: @Composable (() -> Unit)?,
        text: @Composable (() -> Unit)?,
        shape: Shape?,
        backgroundColor: Color?,
        contentColor: Color?,
) {
    val alertController = ComposeAlertController()
    addController(alertController) {
        dismissButton?.let {
            it.invoke()
            val onClick = alertController.onClick
            val action = UIAlertAction.actionWithTitle(alertController.text, 1) { onClick() }
            alertController.alert.addAction(action)
        }

        confirmButton.invoke()
        val onClick = alertController.onClick
        val action = UIAlertAction.actionWithTitle(alertController.text, 0) { onClick() }
        alertController.alert.addAction(action)
        title?.let {
            it()
            alertController.alert.title = alertController.text
        }
        text?.let {
            it()
            alertController.alert.message = alertController.text
        }
    }

    getCurrentController().presentViewController(alertController.alert, true) { }
}

class ComposeAlertController() : UIViewController(nibName = null, bundle = null) {
    var text = ""
    var onClick: () -> Unit = {}
    val alert = UIAlertController.alertControllerWithTitle(null, null, 1)
}