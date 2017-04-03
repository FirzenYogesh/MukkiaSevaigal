package yogesh.firzen.mukkiasevaigal;


import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.DisplayMetrics;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Important Static objects
 */
public class S {

    public static final String Gaali = "gaali ah iruku";
    public static final String piri = ";!piri!;";
    public static int heightPixels;
    public static int widthPixels;
    public static float scaledDensity;
    public static int densityDpi;
    public static float density;
    public static String appName;

    public static String thapuFile;

    public static final String thapuDest = "thapu_dest";
    public static final String thapuMail = "thapu_email";
    public static final String thapuPass = "thapu_pass";

    /**
     * Set the appname
     *
     * @param name name of the app
     */
    public static void setAppName(@NonNull String name) {
        appName = name;
        thapuFile = appName + "_LOG.txt";
    }

    /**
     * Set display details
     *
     * @param dm Give DisplayMetrics
     */
    public static void setDisp(@NonNull DisplayMetrics dm) {
        heightPixels = dm.heightPixels;
        widthPixels = dm.widthPixels;
        scaledDensity = dm.scaledDensity;
        density = dm.density;
        densityDpi = dm.densityDpi;
    }

    /**
     * Set display details
     *
     * @param context Context
     */
    public static void setDisp(@NonNull Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        heightPixels = dm.heightPixels;
        widthPixels = dm.widthPixels;
        scaledDensity = dm.scaledDensity;
        density = dm.density;
        densityDpi = dm.densityDpi;
    }

    /**
     * Call this onConfigChange()
     *
     * @param width  width
     * @param height height
     */
    public static void setWH(int width, int height) {
        widthPixels = width;
        heightPixels = height;
    }

    /**
     * Call this onConfigChange()
     *
     * @param dm DisplayMetrics
     */
    public static void setWH(@NonNull DisplayMetrics dm) {
        widthPixels = dm.widthPixels;
        heightPixels = dm.heightPixels;
    }

    /**
     * Call this onConfigChange()
     *
     * @param context Context
     */
    public static void setWH(@NonNull Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        widthPixels = dm.widthPixels;
        heightPixels = dm.heightPixels;
    }

    /**
     * Check whether device is connect to Internet
     *
     * @return true if connected false if not
     */
    public static boolean isOnline() {
        try {
            Process ipProcess = Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

    /**
     * Converts dp to pixels
     *
     * @param x value in dp
     * @return pixels
     */
    public static int dp(int x) {
        return (int) ((x * density) + 0.5);
    }

    /**
     * Convert pixel to dp
     *
     * @param px pixel
     * @return dp
     */
    public static float pxTodp(float px) {
        return px / densityDpi;
    }

    /**
     * Convert sp to pixel
     *
     * @param x pixel
     * @return pixels
     */
    public static int sp(int x) {
        return (int) ((x * scaledDensity) + 0.5);
    }

    /**
     * Convert pixel to dp
     *
     * @param px pixel
     * @return sp
     */
    public static float pxTosp(int px) {
        return px / scaledDensity;
    }

    /**
     * Log the DisplayData
     */
    public static void dispData() {
        M.L("nammadata", widthPixels + "\t\t" + heightPixels + "\t\t" + scaledDensity + "\t\t" + density + "\t\t" + densityDpi);
    }

    /**
     * Get the log store it in a file;
     *
     * @param context context
     * @return filename
     */
    public static String thapuThedar(@NonNull Context context) {
        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        String model = Build.MODEL;
        if (!model.startsWith(Build.MANUFACTURER))
            model = Build.MANUFACTURER + " " + model;

        File file = new File(context.getFilesDir(), thapuFile);
        if (file.exists()) file.delete();
        Uri u = Uri.fromFile(file);
        String fullName = u.toString();
        InputStreamReader reader = null;
        FileWriter writer = null;
        try {
            String cmd = (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) ?
                    "logcat -d -v time " + S.appName + ":v dalvikvm:v System.err:v *:s" :
                    "logcat -d -v time";
            Process process = Runtime.getRuntime().exec(cmd);
            reader = new InputStreamReader(process.getInputStream());
            writer = new FileWriter(file);
            writer.write("User : " + Build.USER + "\n");
            writer.write("Android version: " + Build.VERSION.SDK_INT + "\n");
            writer.write("Brand:" + Build.BRAND + "\n");
            writer.write("Device: " + model + "\n");
            writer.write("App version: " + (info == null ? "(null)" : info.versionCode) + "\n");
            char[] buffer = new char[10000];
            do {
                int n = reader.read(buffer, 0, buffer.length);
                if (n == -1)
                    break;
                writer.write(buffer, 0, n);
            } while (true);
            reader.close();
            writer.close();
        } catch (IOException e) {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            return null;
        }
        return fullName;
    }

    /**
     * Check whether the file is an image or not
     *
     * @param filename file path
     * @return Returns true if the file is an Image
     */
    public static boolean isImage(String filename) {
        String ext = FilenameUtils.getExtension(filename).toLowerCase();
        return ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png") || ext.equals("bmp") || ext.equals("gif");
    }

    /**
     * Check whether the file is an image or not
     *
     * @param file file
     * @return Returns true if the file is an Image
     */
    public static boolean isImage(File file) {
        return isImage(file.getAbsolutePath());
    }

    /**
     * Check whether the file is a video or not
     *
     * @param filename file path
     * @return Returns true if the file is an Video
     */
    public static boolean isVideo(String filename) {
        String ext = FilenameUtils.getExtension(filename).toLowerCase();
        return ext.equals("mkv")
                || ext.equals("avi")
                || ext.equals("mp4")
                || ext.equals("wmv")
                || ext.equals("3gp")
                || ext.equals("webm")
                || ext.equals("flv")
                || ext.equals("vob")
                || ext.equals("ogg")
                || ext.equals("mng")
                || ext.equals("mov")
                || ext.equals("qt")
                || ext.equals("m4v")
                || ext.equals("mpg")
                || ext.equals("mpeg")
                || ext.equals("ts");
    }

    /**
     * Check whether the file is a video or not
     *
     * @param file file
     * @return Returns true if the file is an Video
     */
    public static boolean isVideo(File file) {
        return isVideo(file.getAbsolutePath());
    }

    /**
     * Check whether the file is a audio or not
     *
     * @param filename file
     * @return Returns true if the file is an Audio
     */
    public static boolean isAudio(String filename) {
        String ext = FilenameUtils.getExtension(filename).toLowerCase();
        return ext.equals("flac")
                || ext.equals("mp3")
                || ext.equals("mid")
                || ext.equals("midi")
                || ext.equals("xmf")
                || ext.equals("mxmf")
                || ext.equals("rtttl")
                || ext.equals("rtx")
                || ext.equals("ota")
                || ext.equals("imy")
                || ext.equals("ogg")
                || ext.equals("wav")
                || ext.equals("ts")
                || ext.equals("aac")
                || ext.equals("mp4")
                || ext.equals("m4a")
                || ext.equals("3gp")
                || ext.equals("mkv");
    }

    /**
     * Check whether the file is a audio or not
     *
     * @param file file
     * @return Returns true if the file is an Audio
     */
    public static boolean isAudio(File file) {
        return isAudio(file.getAbsolutePath());
    }

    /**
     * Converts bytes to easily identifiable format
     *
     * @param bytes bytes value
     * @return String value in B or KB or MB or GB
     */
    public static String bytesInHumanFormat(double bytes) {
        double kilobyte = 1024;
        double megabyte = kilobyte * 1024;
        double gigabyte = megabyte * 1024;
        double terabyte = gigabyte * 1024;
        double pettabyte = terabyte * 1024;
        double exabyte = pettabyte * 1024;
        if ((bytes >= 0) && (bytes < kilobyte))
            return bytes + " B";
        else if ((bytes >= kilobyte) && (bytes < megabyte))
            return (new DecimalFormat("0.00").format(bytes / kilobyte)) + " KB";
        else if ((bytes >= megabyte) && (bytes < gigabyte))
            return (new DecimalFormat("0.00").format(bytes / megabyte)) + " MB";
        else if ((bytes >= gigabyte) && (bytes < terabyte))
            return (new DecimalFormat("0.00").format(bytes / gigabyte)) + " GB";
        else if (bytes >= terabyte && bytes < pettabyte)
            return (new DecimalFormat("0.00").format(bytes / terabyte)) + " TB";
        else if (bytes >= pettabyte && bytes < exabyte)
            return (new DecimalFormat("0.00").format(bytes / pettabyte)) + " PB";
        else if (bytes >= exabyte)
            return (new DecimalFormat("0.00").format(bytes / exabyte)) + " EB";
        else
            return bytes + " Bytes";
    }

    /**
     * Converts bytes to easily identifiable format
     *
     * @param bits bits value
     * @return String value in bits or Kbits or Mbits or Gbits
     */
    public static String bitsInHumanFormat(double bits) {
        double kilobit = 1024;
        double megabit = kilobit * 1024;
        double gigabit = megabit * 1024;
        double terabit = gigabit * 1024;
        double pettabit = terabit * 1024;
        double exabit = pettabit * 1024;
        if ((bits >= 0) && (bits < kilobit))
            return bits + " bits";
        else if ((bits >= kilobit) && (bits < megabit))
            return (new DecimalFormat("0.00").format(bits / kilobit)) + " Kbits";
        else if ((bits >= megabit) && (bits < gigabit))
            return (new DecimalFormat("0.00").format(bits / megabit)) + " Mbits";
        else if ((bits >= gigabit) && (bits < terabit))
            return (new DecimalFormat("0.00").format(bits / gigabit)) + " Gbits";
        else if (bits >= terabit && bits < pettabit)
            return (new DecimalFormat("0.00").format(bits / terabit)) + " Tbits";
        else if (bits >= pettabit && bits < exabit)
            return (new DecimalFormat("0.00").format(bits / pettabit)) + " Pbits";
        else if (bits >= exabit)
            return (new DecimalFormat("0.00").format(bits / exabit)) + " Ebits";
        else
            return bits + " bits";
    }

    /**
     * Use this method to know if the screen is ON or OFF
     *
     * @param context Context
     * @return true if the Screen is ON else false
     */
    public static boolean isScreenOn(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            return pm.isInteractive();
        } else {
            return pm.isScreenOn();
        }
    }

    /**
     * Use this method to know if the phone is unlocked or not
     *
     * @param context Context
     * @return true if the phone is unlocked else false
     */
    public static boolean isPhoneUnlocked(Context context) {
        KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (myKM.inKeyguardRestrictedInputMode()) {
            M.L(M.Type.INFO, "Screen Lock Status", "locked");
            return true;
        } else {
            M.L(M.Type.INFO, "Screen Lock Status", "unlocked");
            return false;
        }
    }

    /**
     * Use this method to know if the device is IDLE or not
     * Available only in Android M
     *
     * @param context Context
     * @return true if the device is idle else false
     */
    @WorkerThread
    public static boolean isDeviceIdle(Context context) {
        if (Build.VERSION.SDK_INT > 22) {
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            return pm.isDeviceIdleMode();
        } else {
            return readUsage() < 7f;
        }
    }

    /**
     * Read the current CPU usage(for all Process)
     * Make sure to call this function in background thread to avoid UI Thread blocking
     *
     * @return CPU Usage in percentage
     */
    @WorkerThread
    public static float readUsage() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();
            String[] toks = load.split(" ");
            long idle1 = Long.parseLong(toks[5]);
            long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);
            try {
                Thread.sleep(360);
            } catch (InterruptedException ignored) {
            }
            reader.seek(0);
            load = reader.readLine();
            reader.close();
            toks = load.split(" ");
            long idle2 = Long.parseLong(toks[5]);
            long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);
            return (float) (cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1)) * 100f;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


    /**
     * Checks whether the given package is a system app or not
     *
     * @param packageName Application package to be checked
     * @return true if it is a system app else false
     */
    public static boolean isSystemApp(String packageName) {
        Set<String> systemApps = new HashSet<>();
        try {
            ProcessBuilder builder = new ProcessBuilder("pm", "list", "packages", "-s");
            Process process = builder.start();
            InputStream in = process.getInputStream();
            Scanner scanner = new Scanner(in);
            Pattern pattern = Pattern.compile("^package:.+");
            int skip = "package:".length();
            while (scanner.hasNext(pattern)) {
                String pckg = scanner.next().substring(skip);
                systemApps.add(pckg);
            }
            scanner.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return systemApps.contains(packageName);
    }


    /**
     * Checks whether the current application is a system app or not
     *
     * @param context Application package to be checked
     * @return true if it is a system app else false
     */
    public static boolean isSystemApp(Context context) {
        return isSystemApp(context.getPackageName());
    }

    /**
     * Creates a Handler to post runnable in main thread
     *
     * @return a Handler object
     */
    public static Handler runInMainThread() {
        return new Handler(Looper.getMainLooper());
    }
}
