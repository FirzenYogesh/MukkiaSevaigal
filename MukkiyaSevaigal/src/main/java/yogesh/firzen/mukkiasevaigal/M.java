package yogesh.firzen.mukkiasevaigal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Message
 */
public class M {

    /**
     * Types of the Log
     */
    public enum Type {
        DEBUG, VERBOSE, INFO, WARN, ERROR, WHAT_A_TERRIBLE_FAILURE
    }

    private static Type type = Type.DEBUG;

    private final static String defTag = "TAG";

    private static String tag = defTag;

    /**
     * Set the type of Logging
     *
     * @param t Type
     */
    public static void setLogType(Type t) {
        type = t;
    }

    /**
     * Set the Logging type to Debug mode
     */
    public static void setLogTypeToDefault() {
        type = Type.DEBUG;
    }

    /**
     * Set the tag for the logging
     *
     * @param s The name of the tag
     */
    public static void setTag(String s) {
        tag = s;
    }

    /**
     * Set the tag value to default
     */
    public static void setTagToDefault() {
        tag = defTag;
    }

    /**
     * Log your message
     *
     * @param message Give your message to be logged
     */
    public static void L(Object message) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(message));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(message));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(message));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(message));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(message));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(message));
    }

    /**
     * Log your message
     *
     * @param type    The type of Logging
     * @param message Give your message to be logged
     */
    public static void L(Type type, Object message) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(message));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(message));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(message));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(message));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(message));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(message));
    }

    /**
     * Log your message
     *
     * @param messages Array of messages
     */
    public static void L(Object... messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param messages Array of messages
     */
    public static void L(Type type, Object... messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param messages List of messages
     */
    public static void L(List<?> messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param messages List of messages
     */
    public static void L(Type type, List<?> messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param tag     Mention the tag
     * @param message Give your message to be logged
     */
    public static void L(@NonNull String tag, Object message) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(message));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(message));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(message));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(message));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(message));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(message));
    }

    /**
     * Log your message
     *
     * @param type    The type of Logging
     * @param tag     Mention the tag
     * @param message Give your message to be logged
     */
    public static void L(Type type, @NonNull String tag, Object message) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(message));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(message));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(message));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(message));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(message));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(message));
    }

    /**
     * Log your message
     *
     * @param tag      tag for identification
     * @param messages array of messages to logged
     */
    public static void L(@NonNull String tag, Object... messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param tag      tag for identification
     * @param messages array of messages to logged
     */
    public static void L(Type type, @NonNull String tag, Object... messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param tag      tag for identification
     * @param messages List of messages
     */
    public static void L(@NonNull String tag, List<?> messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Log your message
     *
     * @param type     The type of Logging
     * @param tag      tag for identification
     * @param messages List of messages
     */
    public static void L(Type type, @NonNull String tag, List<?> messages) {
        if (type == Type.DEBUG)
            Log.d(tag, getMessage(messages));
        else if (type == Type.VERBOSE)
            Log.v(tag, getMessage(messages));
        else if (type == Type.INFO)
            Log.i(tag, getMessage(messages));
        else if (type == Type.WARN)
            Log.i(tag, getMessage(messages));
        else if (type == Type.ERROR)
            Log.e(tag, getMessage(messages));
        else if (type == Type.WHAT_A_TERRIBLE_FAILURE)
            Log.wtf(tag, getMessage(messages));
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be toasted
     */
    public static void T(@NonNull final Context context, final Object message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, getMessage(message), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Toast your message
     *
     * @param context Context
     * @param message Message to be Toasted
     * @param length  LENGTH_LONG or LENGTH_SHORT
     */
    public static void T(@NonNull final Context context, final Object message, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, getMessage(message), length).show();
            }
        });
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
    public static void T(@NonNull final Context context, final Object message, final int gravity, final int xPos, final int yPos) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(context, getMessage(message), Toast.LENGTH_SHORT);
                toast.setGravity(gravity, xPos, yPos);
                toast.show();
            }
        });
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
    public static void T(@NonNull final Context context, final Object message, final int gravity, final int xPos, final int yPos, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(context, getMessage(message), length);
                toast.setGravity(gravity, xPos, yPos);
                toast.show();
            }
        });
    }


    /**
     * Toast your Custom View Message
     *
     * @param view Your Custom View
     */
    public static void T(@NonNull final View view) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = new Toast(view.getContext());
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    /**
     * Toast your Custom View Message
     *
     * @param view   Your Custom View
     * @param length Either LENGTH_SHORT or LENGTH_LONG
     */
    public static void T(@NonNull final View view, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = new Toast(view.getContext());
                toast.setView(view);
                toast.setDuration(length);
                toast.show();
            }
        });
    }

    /**
     * Toast your Custom View Message
     *
     * @param view    Your Custom View
     * @param gravity Gravity of the toast
     * @param xPos    The xOffset of the toast
     * @param yPos    The yOffset of the toast
     */
    public static void T(@NonNull final View view, final int gravity, final int xPos, final int yPos) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = new Toast(view.getContext());
                toast.setView(view);
                toast.setGravity(gravity, xPos, yPos);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
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
    public static void T(@NonNull final View view, final int gravity, final int xPos, final int yPos, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = new Toast(view.getContext());
                toast.setView(view);
                toast.setGravity(gravity, xPos, yPos);
                toast.setDuration(length);
                toast.show();
            }
        });
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     */
    public static void T(@NonNull final Context context, @LayoutRes final int resID) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                View view = View.inflate(context, resID, null);
                Toast toast = new Toast(context);
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    /**
     * Toast your Custom View Message
     *
     * @param context Context
     * @param resID   Your Custom Layout ID
     * @param length  Either LENGTH_SHORT or LENGTH_LONG
     */
    public static void T(@NonNull final Context context, @LayoutRes final int resID, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                View view = View.inflate(context, resID, null);
                Toast toast = new Toast(context);
                toast.setView(view);
                toast.setDuration(length);
                toast.show();
            }
        });
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
    public static void T(@NonNull final Context context, @LayoutRes final int resID, final int gravity, final int xPos, final int yPos) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                View view = View.inflate(context, resID, null);
                Toast toast = new Toast(context);
                toast.setView(view);
                toast.setGravity(gravity, xPos, yPos);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
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
    public static void T(@NonNull final Context context, @LayoutRes final int resID, final int gravity, final int xPos, final int yPos, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                View view = View.inflate(context, resID, null);
                Toast toast = new Toast(context);
                toast.setView(view);
                toast.setGravity(gravity, xPos, yPos);
                toast.setDuration(length);
                toast.show();
            }
        });
    }

    /**
     * Shows a Snackbar
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     */
    public static void S(@NonNull final View parentView, final Object message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Shows a Snackbar with specified length
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     * @param length     LENGTH_LONG or LENGTH_SHORT or LENGTH_INDEFINITE
     */
    public static void S(@NonNull final View parentView, final Object message, final int length) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), length).show();
            }
        });
    }

    /**
     * Shows a SnackBar with and action
     *
     * @param parentView Your parent view
     * @param message    Message to be shown
     * @param action     Name of the action
     * @param listener   ClickListener for the action
     */
    public static void S(@NonNull final View parentView, final Object message, final String action, final View.OnClickListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).setAction(action, listener).show();
            }
        });
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
    public static void S(@NonNull final View parentView, final Object message, final String action, final int actionColor, final View.OnClickListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), Snackbar.LENGTH_SHORT).setAction(action, listener).setActionTextColor(actionColor).show();
            }
        });
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
    public static void S(@NonNull final View parentView, final Object message, final int length, final String action, final View.OnClickListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), length).setAction(action, listener).show();
            }
        });
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
    public static void S(@NonNull final View parentView, final Object message, final int length, final String action, final int actionColor, final View.OnClickListener listener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(parentView, getMessage(message), length).setAction(action, listener).setActionTextColor(actionColor).show();
            }
        });
    }

    private static String getMessage(Object o) {
        if (o != null) {
            return o.toString();
        } else {
            return S.Gaali;
        }
    }

    private static String getMessage(Object... o) {
        if (o != null) {
            String s = "";
            for (Object a : o) {
                s += (getMessage(a) + "\t");
            }
            return s;
        } else
            return S.Gaali;
    }

    private static String getMessage(List<?> o) {
        if (o != null) {
            String s = "";
            for (Object a : o) {
                s += (getMessage(a) + "\t");
            }
            return s;
        } else
            return S.Gaali;
    }

    /*public static void N(@NonNull Context context, int id, String title, String message, @DrawableRes int iconRes) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(iconRes);

    }

    public static void N(@NonNull Context context, int id, String title, String message, @DrawableRes int iconRes) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(iconRes)
                .setAutoCancel(true)
                .setColor(Color.WHITE)
                .set;
    }

    private static void buildNotification(NotificationCompat.Builder builder, int id) {

    }*/
}

