package yogesh.firzen.mukkiasevaigal

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog

/**
 * Ask Permission
 */
@TargetApi(Build.VERSION_CODES.M)
@RequiresApi(api = Build.VERSION_CODES.M)
object K {
    /*public final static String WRITE_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public final static String READ_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public final static String LOCATION_FINE = Manifest.permission.ACCESS_FINE_LOCATION;
    public final static String LOCATION_COARSE = Manifest.permission.ACCESS_COARSE_LOCATION;
    public final static String CAMERA = Manifest.permission.CAMERA;
    public final static String CONTACTS_READ = Manifest.permission.READ_CONTACTS;
    public final static String CONTACTS_WRITE = Manifest.permission.WRITE_CONTACTS;
    public final static String RECORD = Manifest.permission.RECORD_AUDIO;*/
    const val PERM_REQ = 7596

    /**
     * Dangerous Permissions for Calendar
     */
    object CALENDAR {
        const val READ = Manifest.permission.READ_CALENDAR
        const val WRITE = Manifest.permission.WRITE_CALENDAR
    }

    /**
     * Dangerous Permissions for Camera
     */
    object CAMERA {
        const val CAMERA = Manifest.permission.CAMERA
    }

    /**
     * Dangerous Permissions for Contacts
     */
    object CONTACTS {
        const val READ = Manifest.permission.READ_CONTACTS
        const val WRITE = Manifest.permission.WRITE_CONTACTS
        const val GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS
    }

    /**
     * Dangerous Permissions for Location
     */
    object LOCATION {
        const val FINE = Manifest.permission.ACCESS_FINE_LOCATION
        const val COARSE = Manifest.permission.ACCESS_COARSE_LOCATION
    }

    /**
     * Dangerous Permissions for Microphone
     */
    object MICROPHONE {
        const val RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
    }

    /**
     * Dangerous Permissions for Phone
     */
    object PHONE {
        const val READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE
        const val CALL_PHONE = Manifest.permission.CALL_PHONE
        const val READ_CALL_LOG = Manifest.permission.READ_CALL_LOG
        const val WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG
        const val ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL
        const val USE_SIP = Manifest.permission.USE_SIP
        const val PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS
    }

    /**
     * Dangerous Permissions for Sensors
     */
    object SENSORS {
        const val BODY = Manifest.permission.BODY_SENSORS
    }

    /**
     * Dangerous Permissions for SMS
     */
    object SMS {
        const val SEND = Manifest.permission.SEND_SMS
        const val READ = Manifest.permission.READ_SMS
        const val RECEIVE_SMS = Manifest.permission.RECEIVE_SMS
        const val RECEIVE_MMS = Manifest.permission.RECEIVE_MMS
        const val RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH
    }

    /**
     * Dangerous Permissions for Storage
     */
    object STORAGE {
        var WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE
        var READ = Manifest.permission.READ_EXTERNAL_STORAGE
    }

    /**
     * Requests permission
     *
     * @param activity The activity to which the permission is asked
     * @param perm     Permission to be requested, one of the static members
     * @param title    The title of the info dialog
     * @param messagge The message of the info dialog
     */
    fun getPermissionFor(activity: Activity, perm: String, title: String, messagge: String) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, perm)) {
            val dialog = AlertDialog.Builder(activity).setTitle(title).setMessage(messagge).setPositiveButton("DONE") { dialog, which -> ActivityCompat.requestPermissions(activity, arrayOf(perm), PERM_REQ) }.create()
            dialog.show()
        } else {
            ActivityCompat.requestPermissions(activity, arrayOf(perm), PERM_REQ)
        }
    }

    /**
     * Requests permission
     *
     * @param activity The activity to which the permission is asked
     * @param perm     Permission to be requested, one of the static members
     */
    fun getPermissionFor(activity: Activity, perm: String) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, perm)) {
            val dialog = AlertDialog.Builder(activity).setTitle(S.appName).setMessage(perm).setPositiveButton("DONE") { dialog, which -> ActivityCompat.requestPermissions(activity, arrayOf(perm), PERM_REQ) }.create()
            dialog.show()
        } else {
            ActivityCompat.requestPermissions(activity, arrayOf(perm), PERM_REQ)
        }
    }

    /**
     * Requests permission
     *
     * @param activity The activity to which the permission is asked
     * @param perm     Permissions to be requested
     */
    fun getPermissionFor(activity: Activity, perm: Array<String>) {
        ActivityCompat.requestPermissions(activity, perm, PERM_REQ)
    }

    /*@Deprecated
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
    }*/

    /**
     * Check for READ_CALENDAR permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadCalendarPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CALENDAR.READ)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for WRITE_CALENDAR permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkWriteCalendarPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CALENDAR.WRITE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for CAMERA permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkCameraPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CAMERA.CAMERA)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for READ_CONTACTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadContactsPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CONTACTS.READ)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for WRITE_CONTACTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkWriteContactsPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CONTACTS.WRITE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for GET_ACCOUNTS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkGetAccountsPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(CONTACTS.GET_ACCOUNTS)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for ACCESS_FINE_LOCATION permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkLocationFinePermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(LOCATION.FINE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for ACCESS_COARSE_LOCATION permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkLocationCoarsePermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(LOCATION.COARSE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for RECORD_AUDIO permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkRecordAudioPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(MICROPHONE.RECORD_AUDIO)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for READ_PHONE_STATE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadPhoneStatePermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.READ_PHONE_STATE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for CALL_PHONE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkCallPhonePermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.CALL_PHONE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for READ_CALL_LOG permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadCallLogPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.READ_CALL_LOG)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for WRITE_CALL_LOG permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkWriteCallLogPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.WRITE_CALL_LOG)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for ADD_VOICEMAIL permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkAddVoicemailPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.ADD_VOICEMAIL)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for USE_SIP permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkUseSIPPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.USE_SIP)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for PROCESS_OUTGOING_CALLS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkProcessOutgoingCallsPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(PHONE.PROCESS_OUTGOING_CALLS)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for BODY_SENSORS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkBodySensorsPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SENSORS.BODY)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for SEND_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkSendSMSPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SMS.SEND)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for READ_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadSMSPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SMS.READ)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for RECEIVE_SMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReceiveSMSPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_SMS)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for RECEIVE_MMS permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReceiveMMSPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_MMS)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for RECEIVE_WAP_PUSH permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReceiveWAPPushPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(SMS.RECEIVE_WAP_PUSH)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for WRITE_EXTERNAL_STORAGE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkWriteExternalPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(STORAGE.WRITE)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check for READ_EXTERNAL_STORAGE permission
     *
     * @param activity Activity
     * @return true if granted else false
     */
    fun checkReadExternalPermission(activity: Activity): Boolean {
        val res = activity.checkCallingOrSelfPermission(STORAGE.READ)
        return res == PackageManager.PERMISSION_GRANTED
    }


    /**
     * Check whether the given permission is granted or not
     *
     * @param context Context
     * @param perm    The permission to be checked
     * @return true if granted else false
     */
    fun checkPermissionGranted(context: Context, perm: String): Boolean {
        val res = context.checkCallingOrSelfPermission(perm)
        return res == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check whether the given permission is granted or not
     *
     * @param activity Context
     * @param perm     The permission to be checked
     * @return true if granted else false
     */
    fun checkPermissionGranted(activity: Activity, perm: String): Boolean {
        val res = activity.checkCallingOrSelfPermission(perm)
        return res == PackageManager.PERMISSION_GRANTED
    }

}
