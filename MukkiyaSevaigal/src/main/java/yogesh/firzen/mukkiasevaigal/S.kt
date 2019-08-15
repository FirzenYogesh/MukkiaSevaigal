package yogesh.firzen.mukkiasevaigal


import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.util.DisplayMetrics
import androidx.annotation.WorkerThread
import java.io.*
import java.text.DecimalFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Important Static objects
 */
object S {

    val Gaali = "gaali ah iruku"
    val piri = ";!piri!;"
    var heightPixels: Int = 0
    var widthPixels: Int = 0
    var heightDp: Float = 0.toFloat()
    var widthDp: Float = 0.toFloat()
    var widthInches: Float = 0.toFloat()
    var heightInches: Float = 0.toFloat()
    var screenSizeInches: Float = 0.toFloat()
    var xDpi: Float = 0.toFloat()
    var yDpi: Float = 0.toFloat()
    var scaledDensity: Float = 0.toFloat()
    var densityDpi: Int = 0
    var density: Float = 0.toFloat()
    var appName: String = ""
        set(value) {
            field = value
            errorFile = value + "_LOG.txt"
        }

    /**
     * Returns the size of the screen
     *
     * @return One of the enum in ScreenSize
     */
    var screenSize: ScreenSize? = null
        private set
    var screenDensity: ScreenDensity? = null
        private set

    var errorFile: String? = null

    /**
     * Check whether device is connected to Internet or not
     *
     * @return true if connected false if not
     */
    val isOnline: Boolean
        get() {
            try {
                val ipProcess = Runtime.getRuntime().exec("ping -c 1 www.google.com")
                val exitValue = ipProcess.waitFor()
                return exitValue == 0
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return false
        }

    /**
     * Sizes of screen
     */
    enum class ScreenSize {
        SMALL, NORMAL, LARGE, XLARGE, UNDEFINED
    }

    enum class ScreenDensity {
        LDPI, MDPI, HDPI, XHDPI, XXHDPI, TV, UNKNOWN, XXXHDPI
    }

    /**
     * Set display details
     *
     * @param resources Give Resource obtained from context
     */
    private fun setDisp(resources: Resources) {
        val dm = resources.displayMetrics
        heightPixels = dm.heightPixels
        widthPixels = dm.widthPixels
        xDpi = dm.xdpi
        yDpi = dm.ydpi
        scaledDensity = dm.scaledDensity
        density = dm.density
        densityDpi = dm.densityDpi
        heightDp = pxTodp(heightPixels.toFloat())
        widthDp = pxTodp(widthPixels.toFloat())
        widthInches = widthPixels / xDpi
        heightInches = heightPixels / yDpi
        screenSizeInches = sqrt(heightInches.toDouble().pow(2.0) + widthInches.toDouble().pow(2.0)).toFloat()
        setScreenSize(resources)
        setScreenDensity(resources)

    }

    /**
     * Set display details
     *
     * @param context Context
     */
    fun setDisp(context: Context) {
        setDisp(context.resources)
    }

    /**
     * Call this onConfigChange()
     *
     * @param width  width
     * @param height height
     */
    fun setWH(width: Int, height: Int) {
        widthPixels = width
        heightPixels = height
    }

    /**
     * Call this onConfigChange()
     *
     * @param dm DisplayMetrics
     */
    fun setWH(dm: DisplayMetrics) {
        widthPixels = dm.widthPixels
        heightPixels = dm.heightPixels
    }

    /**
     * Call this onConfigChange()
     *
     * @param context Context
     */
    fun setWH(context: Context) {
        val dm = context.resources.displayMetrics
        widthPixels = dm.widthPixels
        heightPixels = dm.heightPixels
    }

    private fun setScreenSize(res: Resources) {
        //screenLayout = res.getConfiguration().screenLayout;
        when (res.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) {
            Configuration.SCREENLAYOUT_SIZE_SMALL -> screenSize = ScreenSize.SMALL
            Configuration.SCREENLAYOUT_SIZE_NORMAL -> screenSize = ScreenSize.NORMAL
            Configuration.SCREENLAYOUT_SIZE_LARGE -> screenSize = ScreenSize.LARGE
            Configuration.SCREENLAYOUT_SIZE_XLARGE -> screenSize = ScreenSize.XLARGE
            Configuration.SCREENLAYOUT_SIZE_UNDEFINED -> screenSize = ScreenSize.UNDEFINED
        }
    }

    private fun setScreenDensity(res: Resources) {
        val dm = res.displayMetrics
        val density = dm.densityDpi
        screenDensity = when (density) {
            DisplayMetrics.DENSITY_HIGH -> ScreenDensity.HDPI
            DisplayMetrics.DENSITY_MEDIUM -> ScreenDensity.MDPI
            DisplayMetrics.DENSITY_LOW -> ScreenDensity.LDPI
            DisplayMetrics.DENSITY_XHIGH -> ScreenDensity.XHDPI
            DisplayMetrics.DENSITY_XXHIGH -> ScreenDensity.XXHDPI
            DisplayMetrics.DENSITY_XXXHIGH -> ScreenDensity.XXXHDPI
            DisplayMetrics.DENSITY_TV -> ScreenDensity.TV
            else -> ScreenDensity.UNKNOWN
        }
    }

    /**
     * Converts dp to pixels
     *
     * @param x value in dp
     * @return pixels
     */
    fun dpToPx(x: Int): Int {
        return (x * density + 0.5).toInt()
    }

    /**
     * Convert pixel to dp
     *
     * @param px pixel
     * @return dp
     */
    fun pxTodp(px: Float): Float {
        return px / density
    }

    /**
     * Convert sp to pixel
     *
     * @param x pixel
     * @return pixels
     */
    fun spToPx(x: Int): Int {
        return (x * scaledDensity + 0.5).toInt()
    }

    /**
     * Convert pixel to dp
     *
     * @param px pixel
     * @return sp
     */
    fun pxTosp(px: Int): Float {
        return px / scaledDensity
    }

    /**
     * Log the DisplayData
     */
    fun dispData() {
        M.L("Display Parameters",
                "Width (px) : " + widthPixels + "\t\t" + "Width (dp) : " + widthDp + "\t\t" + "Width (inches) : " + widthInches + "\n" +
                        "Height (px) : " + heightPixels + "\t\t" + "Height (dp) : " + heightDp + "\t\t" + "Height (inches) : " + heightInches + "\n" +
                        "Screen Size (inches) : " + screenSizeInches + "\t\t" + "Screen Size : " + screenSize + "\n"
                        + "Screen Density Scale : " + density + "\t\t" + "Font Scale : " + scaledDensity + "\n" +
                        "Screen Density (dpi) : " + densityDpi + "\t\t" + "Screen Density : " + screenDensity + "\n" +
                        "xDpi : " + xDpi + "\t\t" + "yDpi : " + yDpi + "\n")
    }

    /**
     * Check whether device is connected to Internet or not
     *
     * @return true if connected false if not
     */
    fun isOnline(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = manager.activeNetworkInfo
        return ni != null && ni.isConnected
    }

    /**
     * Get the log store it in a file;
     *
     * @param context context
     * @return filename
     */
    fun thapuThedar(context: Context): String? {
        val manager = context.packageManager
        var info: PackageInfo? = null
        try {
            info = manager.getPackageInfo(context.packageName, 0)
        } catch (e2: PackageManager.NameNotFoundException) {
            e2.printStackTrace()
        }

        var model = Build.MODEL
        if (!model.startsWith(Build.MANUFACTURER))
            model = Build.MANUFACTURER + " " + model
        if (errorFile == null)
            errorFile = "Log.txt"
        val file = File(context.filesDir, errorFile!!)
        if (file.exists()) file.delete()
        val u = Uri.fromFile(file)
        val fullName = u.toString()
        var reader: InputStreamReader? = null
        var writer: FileWriter? = null
        try {
            val cmd = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
                "logcat -d -v time " + S.appName + ":v dalvikvm:v System.err:v *:s"
            else
                "logcat -d -v time"
            val process = Runtime.getRuntime().exec(cmd)
            reader = InputStreamReader(process.inputStream)
            writer = FileWriter(file)
            writer.write("User : " + Build.USER + "\n")
            writer.write("Android version: " + Build.VERSION.SDK_INT + "\n")
            writer.write("Brand:" + Build.BRAND + "\n")
            writer.write("Device: $model\n")
            writer.write("App version: " + (info?.versionCode ?: "(null)") + "\n")
            val buffer = CharArray(10000)
            do {
                val n = reader.read(buffer, 0, buffer.size)
                if (n == -1)
                    break
                writer.write(buffer, 0, n)
            } while (true)
            reader.close()
            writer.close()
        } catch (e: IOException) {
            if (writer != null)
                try {
                    writer.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }

            if (reader != null)
                try {
                    reader.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }

            return null
        }

        return fullName
    }

    /**
     * Converts bytes to easily identifiable format
     *
     * @param bytes bytes value
     * @return String value in B or KB or MB or GB
     */
    fun bytesInHumanFormat(bytes: Double): String {
        val kilobyte = 1024.0
        val megabyte = kilobyte * 1024
        val gigabyte = megabyte * 1024
        val terabyte = gigabyte * 1024
        val pettabyte = terabyte * 1024
        val exabyte = pettabyte * 1024
        return if (bytes >= 0 && bytes < kilobyte)
            "$bytes B"
        else if (bytes >= kilobyte && bytes < megabyte)
            DecimalFormat("0.00").format(bytes / kilobyte) + " KB"
        else if (bytes >= megabyte && bytes < gigabyte)
            DecimalFormat("0.00").format(bytes / megabyte) + " MB"
        else if (bytes >= gigabyte && bytes < terabyte)
            DecimalFormat("0.00").format(bytes / gigabyte) + " GB"
        else if (bytes >= terabyte && bytes < pettabyte)
            DecimalFormat("0.00").format(bytes / terabyte) + " TB"
        else if (bytes >= pettabyte && bytes < exabyte)
            DecimalFormat("0.00").format(bytes / pettabyte) + " PB"
        else if (bytes >= exabyte)
            DecimalFormat("0.00").format(bytes / exabyte) + " EB"
        else
            "$bytes Bytes"
    }

    /**
     * Converts bits to easily identifiable format
     *
     * @param bits bits value
     * @return String value in bits or Kbits or Mbits or Gbits
     */
    fun bitsInHumanFormat(bits: Double): String {
        val kilobit = 1024.0
        val megabit = kilobit * 1024
        val gigabit = megabit * 1024
        val terabit = gigabit * 1024
        val pettabit = terabit * 1024
        val exabit = pettabit * 1024
        return if (bits >= 0 && bits < kilobit)
            "$bits bits"
        else if (bits >= kilobit && bits < megabit)
            DecimalFormat("0.00").format(bits / kilobit) + " Kbits"
        else if (bits >= megabit && bits < gigabit)
            DecimalFormat("0.00").format(bits / megabit) + " Mbits"
        else if (bits >= gigabit && bits < terabit)
            DecimalFormat("0.00").format(bits / gigabit) + " Gbits"
        else if (bits >= terabit && bits < pettabit)
            DecimalFormat("0.00").format(bits / terabit) + " Tbits"
        else if (bits >= pettabit && bits < exabit)
            DecimalFormat("0.00").format(bits / pettabit) + " Pbits"
        else if (bits >= exabit)
            DecimalFormat("0.00").format(bits / exabit) + " Ebits"
        else
            "$bits bits"
    }

    /**
     * Use this method to know if the screen is ON or OFF
     *
     * @param context Context
     * @return true if the Screen is ON else false
     */
    fun isScreenOn(context: Context): Boolean {
        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            pm.isInteractive
        } else {
            pm.isScreenOn
        }
    }

    /**
     * Use this method to know if the phone is unlocked or not
     *
     * @param context Context
     * @return true if the phone is unlocked else false
     */
    fun isPhoneUnlocked(context: Context): Boolean {
        val myKM = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        return if (myKM.inKeyguardRestrictedInputMode()) {
            M.L(M.Type.INFO, "Screen Lock Status", "locked")
            true
        } else {
            M.L(M.Type.INFO, "Screen Lock Status", "unlocked")
            false
        }
    }

    /**
     * Use this method to know if the device is IDLE or not
     *
     * @param context Context
     * @return true if the device is idle else false
     */
    @WorkerThread
    fun isDeviceIdle(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT > 22) {
            val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            pm.isDeviceIdleMode
        } else {
            readUsage() < 7f
        }
    }

    /**
     * Read the current CPU usage(for all Process)
     * Make sure to call this function in background thread to avoid UI Thread blocking
     *
     * @return CPU Usage in percentage
     */
    @WorkerThread
    fun readUsage(): Float {
        try {
            val reader = RandomAccessFile("/proc/stat", "r")
            var load = reader.readLine()
            var toks = load.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val idle1 = java.lang.Long.parseLong(toks[5])
            val cpu1 = (java.lang.Long.parseLong(toks[2]) + java.lang.Long.parseLong(toks[3]) + java.lang.Long.parseLong(toks[4])
                    + java.lang.Long.parseLong(toks[6]) + java.lang.Long.parseLong(toks[7]) + java.lang.Long.parseLong(toks[8]))
            try {
                Thread.sleep(360)
            } catch (ignored: InterruptedException) {
            }

            reader.seek(0)
            load = reader.readLine()
            reader.close()
            toks = load.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val idle2 = java.lang.Long.parseLong(toks[5])
            val cpu2 = (java.lang.Long.parseLong(toks[2]) + java.lang.Long.parseLong(toks[3]) + java.lang.Long.parseLong(toks[4])
                    + java.lang.Long.parseLong(toks[6]) + java.lang.Long.parseLong(toks[7]) + java.lang.Long.parseLong(toks[8]))
            return (cpu2 - cpu1).toFloat() / (cpu2 + idle2 - (cpu1 + idle1)) * 100f
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return 0f
    }


    /**
     * Checks whether the given package is a system app or not
     *
     * @param packageName Application package to be checked
     * @return true if it is a system app else false
     */
    fun isSystemApp(packageName: String): Boolean {
        val systemApps = HashSet<String>()
        try {
            val builder = ProcessBuilder("pm", "list", "packages", "-s")
            val process = builder.start()
            val `in` = process.inputStream
            val scanner = Scanner(`in`)
            val pattern = Pattern.compile("^package:.+")
            val skip = "package:".length
            while (scanner.hasNext(pattern)) {
                val pckg = scanner.next().substring(skip)
                systemApps.add(pckg)
            }
            scanner.close()
            process.destroy()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return systemApps.contains(packageName)
    }


    /**
     * Checks whether the current application is a system app or not
     *
     * @param context Application package to be checked
     * @return true if it is a system app else false
     */
    fun isSystemApp(context: Context): Boolean {
        return isSystemApp(context.packageName)
    }

    /**
     * Creates a Handler to post runnable in main thread
     *
     * @return a Handler object
     */
    fun runInMainThread(): Handler {
        return Handler(Looper.getMainLooper())
    }
}
