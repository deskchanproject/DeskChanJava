package info.deskchan.MessageData.GUIEvents

import info.deskchan.core.MessageData

/**
 * Called every time user perform mouse move above balloon
 *
 * @property screenX Click X position, absolute (relative of screen)
 * @property screenY Click Y position, absolute (relative of screen)
 * @property nodeX Click X position, relative of character sprite
 * @property nodeY Click Y position, relative of character sprite
 */
@MessageData.Tag("gui-events:balloon-mouse-moved")
class BalloonMouseMoved(val screenX: Int, val screenY: Int, val nodeX: Int, val nodeY: Int) : MessageData