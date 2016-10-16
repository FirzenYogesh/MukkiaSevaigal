package yogesh.firzen.mukkiasevaigal;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;

/**
 * Ask Permission
 */
@TargetApi(Build.VERSION_CODES.M)
public class K {
    /*public final static String WRITE_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public final static String READ_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public final static String LOCATION_FINE = Manifest.permission.ACCESS_FINE_LOCATION;
    public final static String LOCATION_COARSE = Manifest.permission.ACCESS_COARSE_LOCATION;
    public final static String CAMERA = Manifest.permission.CAMERA;
    public final static String CONTACTS_READ = Manifest.permission.READ_CONTACTS;
    public final static String CONTACTS_WRITE = Manifest.permission.WRITE_CONTACTS;
    public final static String RECORD = Manifest.permission.RECORD_AUDIO;*/
    public static final int PERM_REQ = 7;

    /**
     * Dangerous Permissions for Calendar
     */
    public static class CALENDAR {
        public static String READ = Manifest.permission.READ_CALENDAR;
        public static String WRITE = Manifest.permission.WRITE_CALENDAR;
    }

    /**
     * Dangerous Permissions for Camera
     */
    public static class CAMERA {
        public final static String CAMERA = Manifest.permission.CAMERA;
    }

    /**
     * Dangerous Permissions for Contacts
     */
    public static class CONTACTS {
        public final static String READ = Manifest.permission.READ_CONTACTS;
        public final static String WRITE = Manifest.permission.WRITE_CONTACTS;
        public final static String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    }

    /**
     * Dangerous Permissions for Location
     */
    public static class LOCATION {
        public final static String FINE = Manifest.permission.ACCESS_FINE_LOCATION;
        public final static String COARSE = Manifest.permission.ACCESS_COARSE_LOCATION;
    }

    /**
     * Dangerous Permissions for Microphone
     */
    public static class MICROPHONE {
        public final static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    }

    /**
     * Dangerous Permissions for Phone
     */
    public static class PHONE {
        public final static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
        public final static String CALL_PHONE = Manifest.permission.CALL_PHONE;
        public final static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
        public final static String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
        public final static String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
        public final static String USE_SIP = Manifest.permission.USE_SIP;
        public final static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    }

    /**
     * Dangerous Permissions for Sensors
     */
    public static class SENSORS {
        public final static String BODY = Manifest.permission.BODY_SENSORS;
    }

    /**
     * Dangerous Permissions for SMS
     */
    public static class SMS {
        public final static String SEND = Manifest.permission.SEND_SMS;
        public final static String READ = Manifest.permission.READ_SMS;
        public final static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
        public final static String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
        public final static String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    }

    /**
     * Dangerous Permissions for Storage
     */
    public static class STORAGE {
        public static String WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        public static String READ = Manifest.permission.READ_EXTERNAL_STORAGE;
    }

    /**
     * Requests permission
     *
     * @param activity The activity to which the permission is asked
     * @param perm     Permission to be requested, one of the static members
     * @param title    The title of the info dialog
     * @param messagge The message of the info dialog
     */
    public static void getPermissionFor(@NonNull final Activity activity, @NonNull final String perm, String title, String messagge) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, perm)) {
            AppCompatDialog dialog = new AlertDialog.Builder(activity).setTitle(title).setMessage(messagge).setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{perm}, PERM_REQ);
                }
            }).create();
            dialog.show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{perm}, PERM_REQ);
        }
    }

    @Deprecated
    public static void getPermissionsFor(@NonNull final Activity activity, @NonNull final String[] perms, String title, String messagge) {
        for (int i = 0; i < perms.length; i++) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, perms[i])) {
                final int finalI = i;
                AppCompatDialog dialog = new AlertDialog.Builder(activity).setTitle(title).setMessage(messagge).setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(activity, new String[]{perms[finalI]}, PERM_REQ);
                    }
                }).create();
                dialog.show();
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{perms[i]}, PERM_REQ);
            }
        }
    }

    /**
     * Check for READ_CALENDAR permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadCalendarPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CALENDAR.READ);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for WRITE_CALENDAR permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkWriteCalendarPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CALENDAR.WRITE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for CAMERA permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkCameraPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CAMERA.CAMERA);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for READ_CONTACTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadContactsPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CONTACTS.READ);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for WRITE_CONTACTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkWriteContactsPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CONTACTS.WRITE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for GET_ACCOUNTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkGetAccountsPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(CONTACTS.GET_ACCOUNTS);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for ACCESS_FINE_LOCATION permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkLocationFinePermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(LOCATION.FINE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for ACCESS_COARSE_LOCATION permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkLocationCoarsePermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(LOCATION.COARSE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for RECORD_AUDIO permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkRecordAudioPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(MICROPHONE.RECORD_AUDIO);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for READ_PHONE_STATE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadPhoneStatePermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.READ_PHONE_STATE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for CALL_PHONE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkCallPhonePermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.CALL_PHONE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for READ_CALL_LOG permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadCallLogPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.READ_CALL_LOG);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for WRITE_CALL_LOG permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkWriteCallLogPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.WRITE_CALL_LOG);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for ADD_VOICEMAIL permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkAddVoicemailPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.ADD_VOICEMAIL);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for USE_SIP permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkUseSIPPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.USE_SIP);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for PROCESS_OUTGOING_CALLS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkProcessOutgoingCallsPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(PHONE.PROCESS_OUTGOING_CALLS);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for BODY_SENSORS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkBodySensorsPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SENSORS.BODY);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for SEND_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkSendSMSPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SMS.SEND);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for READ_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadSMSPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SMS.READ);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for RECEIVE_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReceiveSMSPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_SMS);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for RECEIVE_MMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReceiveMMSPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_MMS);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for RECEIVE_WAP_PUSH permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReceiveWAPPushPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_WAP_PUSH);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for WRITE_EXTERNAL_STORAGE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkWriteExternalPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(STORAGE.WRITE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check for READ_EXTERNAL_STORAGE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    public static boolean checkReadExternalPermission(Activity activity) {
        int res = activity.checkCallingOrSelfPermission(STORAGE.READ);
        return (res == PackageManager.PERMISSION_GRANTED);
    }


    /**
     * Check whether the given permission is granted or not
     *
     * @param context Context
     * @param perm    The permission to be checked
     * @return true if granted else false
     */
    public static boolean checkPermissionGranted(Context context, String perm) {
        int res = context.checkCallingOrSelfPermission(perm);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Check whether the given permission is granted or not
     *
     * @param activity Context
     * @param perm     The permission to be checked
     * @return true if granted else false
     */
    public static boolean checkPermissionGranted(Activity activity, String perm) {
        int res = activity.checkCallingOrSelfPermission(perm);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

}
