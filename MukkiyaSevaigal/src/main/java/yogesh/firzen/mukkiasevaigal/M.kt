package yogesh.firzen.mukkiasevaigal

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.google.android.material.snackbar.Snackbar
import androidx.core.app.NotificationCompat
import android.util.Log
import android.view.View
import android.widget.Toast

/**
 * Message
 */
object M {

    private var type = Type.DEBUG

    private val defTag = "TAG"

    private var tag = defTag

    /**
     * Types of the Log
     */
    enum class Type {
        DEBUG, VERBOSE, INFO, WARN, ERROR, WHAT_A_TERRIBLE_FAILURE
    }

    /**
     * Set the type of Logging
     *
     * @param t Type
     */
    fun setLogType(t: Type) {
        type = t
    }

    /**
     * Set the Logging type to Debug mode
     */
    fun setLogTypeToDefault() {
        type = Type.DEBUG
    }

    /**
     * Set the tag for the logging
     *
     * @param s The name of the tag
     */
    fun setTag(s: String) {
        tag = s
    }

    /**
     * Set the tag value to default
     */
    fun setTagToDefault() {
        tag = defTag
    }

    /**
     * Log your message
     *
     * @param message Give your message to be logged
     */
    fun L(message: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(message))
            Type.VERBOSE -> Log.v(tag, getMessage(message))
            Type.INFO -> Log.i(tag, getMessage(message))
            Type.WARN -> Log.i(tag, getMessage(message))
            Type.ERROR -> Log.e(tag, getMessage(message))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(message))
        }
    }

    /**
     * Log your message
     *
     * @param type    The type of Logging
     * @param message Give your message to be logged
     */
    fun L(type: Type, message: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(message))
            Type.VERBOSE -> Log.v(tag, getMessage(message))
            Type.INFO -> Log.i(tag, getMessage(message))
            Type.WARN -> Log.i(tag, getMessage(message))
            Type.ERROR -> Log.e(tag, getMessage(message))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(message))
        }
    }

    /**
     * Log your message
     *
     * @param messages Array of messages
     */
    fun L(vararg messages: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param messages Array of messages
     */
    fun L(type: Type, vararg messages: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param messages List of messages
     */
    fun L(messages: List<*>?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param messages List of messages
     */
    fun L(type: Type, messages: List<*>?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param tag     Mention the tag
     * @param message Give your message to be logged
     */
    fun L(tag: String, message: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(message))
            Type.VERBOSE -> Log.v(tag, getMessage(message))
            Type.INFO -> Log.i(tag, getMessage(message))
            Type.WARN -> Log.i(tag, getMessage(message))
            Type.ERROR -> Log.e(tag, getMessage(message))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(message))
        }
    }

    /**
     * Log your message
     *
     * @param type    The type of Logging
     * @param tag     Mention the tag
     * @param message Give your message to be logged
     */
    fun L(type: Type, tag: String, message: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(message))
            Type.VERBOSE -> Log.v(tag, getMessage(message))
            Type.INFO -> Log.i(tag, getMessage(message))
            Type.WARN -> Log.i(tag, getMessage(message))
            Type.ERROR -> Log.e(tag, getMessage(message))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(message))
        }
    }

    /**
     * Log your message
     *
     * @param tag      tag for identification
     * @param messages array of messages to logged
     */
    fun L(tag: String, vararg messages: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param tag      tag for identification
     * @param messages array of messages to logged
     */
    fun L(type: Type, tag: String, vararg messages: Any?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param tag      tag for identification
     * @param messages List of messages
     */
    fun L(tag: String, messages: List<*>?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param tag      tag for identification
     * @param messages List of messages
     */
    fun L(type: Type, tag: String, messages: List<*>?) {
        when (type) {
            Type.DEBUG -> Log.d(tag, getMessage(messages))
            Type.VERBOSE -> Log.v(tag, getMessage(messages))
            Type.INFO -> Log.i(tag, getMessage(messages))
            Type.WARN -> Log.i(tag, getMessage(messages))
            Type.ERROR -> Log.e(tag, getMessage(messages))
            Type.WHAT_A_TERRIBLE_FAILURE -> Log.wtf(tag, getMessage(messages))
        }
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be toasted
     */
    fun T(context: Context, message: Any?) {
        Handler(Looper.getMainLooper()).post { Toast.makeText(context, getMessage(message), Toast.LENGTH_SHORT).show() }
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be Toasted
     * @param length  LENGTH_LONG or LENGTH_SHORT
     */
    fun T(context: Context, message: Any?, length: Int) {
        Handler(Looper.getMainLooper()).post { Toast.makeText(context, getMessage(message), length).show() }
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be Toasted
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     */
    fun T(context: Context, message: Any?, gravity: Int, xPos: Int, yPos: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast.makeText(context, getMessage(message), Toast.LENGTH_SHORT)
            toast.setGravity(gravity, xPos, yPos)
            toast.show()
        }
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be Toasted
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     * @param length  LENGTH_LONG or LENGTH_SHORT
     */
    fun T(context: Context, message: Any?, gravity: Int, xPos: Int, yPos: Int, length: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast.makeText(context, getMessage(message), length)
            toast.setGravity(gravity, xPos, yPos)
            toast.show()
        }
    }


    /**
     * Toast your Custom View Message
     *
     * @param view Your Custom View
     */
    fun T(view: View) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast(view.context)
            toast.view = view
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param view   Your Custom View
     * @param length Either LENGTH_SHORT or LENGTH_LONG
     */
    fun T(view: View, length: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast(view.context)
            toast.view = view
            toast.duration = length
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param view    Your Custom View
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     */
    fun T(view: View, gravity: Int, xPos: Int, yPos: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast(view.context)
            toast.view = view
            toast.setGravity(gravity, xPos, yPos)
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param view    Your Custom View
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     * @param length  Either LENGTH_SHORT or LENGTH_LONG
     */
    fun T(view: View, gravity: Int, xPos: Int, yPos: Int, length: Int) {
        Handler(Looper.getMainLooper()).post {
            val toast = Toast(view.context)
            toast.view = view
            toast.setGravity(gravity, xPos, yPos)
            toast.duration = length
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     */
    fun T(context: Context, @LayoutRes resID: Int) {
        Handler(Looper.getMainLooper()).post {
            val view = View.inflate(context, resID, null)
            val toast = Toast(context)
            toast.view = view
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     * @param length  Either LENGTH_SHORT or LENGTH_LONG
     */
    fun T(context: Context, @LayoutRes resID: Int, length: Int) {
        Handler(Looper.getMainLooper()).post {
            val view = View.inflate(context, resID, null)
            val toast = Toast(context)
            toast.view = view
            toast.duration = length
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     */
    fun T(context: Context, @LayoutRes resID: Int, gravity: Int, xPos: Int, yPos: Int) {
        Handler(Looper.getMainLooper()).post {
            val view = View.inflate(context, resID, null)
            val toast = Toast(context)
            toast.view = view
            toast.setGravity(gravity, xPos, yPos)
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     * @param length  Either LENGTH_SHORT or LENGTH_LONG
     */
    fun T(context: Context, @LayoutRes resID: Int, gravity: Int, xPos: Int, yPos: Int, length: Int) {
        Handler(Looper.getMainLooper()).post {
            val view = View.inflate(context, resID, null)
            val toast = Toast(context)
            toast.view = view
            toast.setGravity(gravity, xPos, yPos)
            toast.duration = length
            toast.show()
        }
    }

    /**
     * Shows a Snackbar
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     */
    fun S(parentView: View, message: Any?) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).show() }
    }

    /**
     * Shows a Snackbar with specified length
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     * @param length     LENGTH_LONG or LENGTH_SHORT or LENGTH_INDEFINITE
     */
    fun S(parentView: View, message: Any?, length: Int) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), length).show() }
    }

    /**
     * Shows a SnackBar with and action
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     * @param action     Name of the action
     * @param listener   ClickListener for the action
     */
    fun S(parentView: View, message: Any?, action: String, listener: View.OnClickListener) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).setAction(action, listener).show() }
    }

    /**
     * Shows a SnackBar with action that has specified color for action text
     *
     * @param parentView  Your parent view
     * @param message     Message to be shown
     * @param action      Name of the action
     * @param actionColor Color of the action text
     * @param listener    ClickListener for the action
     */
    fun S(parentView: View, message: Any?, action: String, actionColor: Int, listener: View.OnClickListener) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).setAction(action, listener).setActionTextColor(actionColor).show() }
    }

    /**
     * Shows a SnackBar with and action
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     * @param length     LENGTH_LONG or LENGTH_SHORT or LENGTH_INDEFINITE
     * @param action     Name of the action
     * @param listener   ClickListener for the action
     */
    fun S(parentView: View, message: Any?, length: Int, action: String, listener: View.OnClickListener) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), length).setAction(action, listener).show() }
    }

    /**
     * Shows a SnackBar with action that has specified color for action text and specified time
     *
     * @param parentView  Your parent view
     * @param message     Message to be shown
     * @param length      LENGTH_LONG or LENGTH_SHORT or LENGTH_INDEFINITE
     * @param action      Name of the action
     * @param actionColor Color of the action text
     * @param listener    ClickListener for the action
     */
    fun S(parentView: View, message: Any?, length: Int, action: String, actionColor: Int, listener: View.OnClickListener) {
        Handler(Looper.getMainLooper()).post { Snackbar.make(parentView, getMessage(message), length).setAction(action, listener).setActionTextColor(actionColor).show() }
    }

    private fun getMessage(o: Any?): String {
        return o?.toString() ?: S.Gaali
    }

    private fun getMessage(o: Array<*>?): String {
        return if (o != null) {
            var s = ""
            for (a in o) {
                s += getMessage(a) + "\t"
            }
            s
        } else
            S.Gaali
    }

    private fun getMessage(o: List<*>?): String {
        return if (o != null) {
            var s = ""
            for (a in o) {
                s += getMessage(a) + "\t"
            }
            s
        } else
            S.Gaali
    }

    /*public static void N(@NonNull Context context, int id, String title, String message, @DrawableRes int iconRes) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(iconRes)
                .setAutoCancel(true)
                .setColor(Color.TRANSPARENT);
    }*/

    /*public static void N(@NonNull Context context, int id, String title, String message, @DrawableRes int iconRes) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(iconRes)
                .setAutoCancel(true)
                .setColor(Color.WHITE)
                .set;
    }*/

    /*private static void buildNotification(NotificationCompat.Builder builder, int id) {

    }*/
}

