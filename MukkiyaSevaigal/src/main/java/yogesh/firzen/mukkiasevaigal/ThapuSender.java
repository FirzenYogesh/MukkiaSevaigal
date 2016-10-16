package yogesh.firzen.mukkiasevaigal;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class ThapuSender extends AsyncTask<Void, Void, Void> {

    private Context context;
    private String destination = "veto.voiceenabledtools@gmail.com";
    private String email;
    private String password;
    private String data = "";

    /**
     * @param c     context
     * @param dest  destination email
     * @param email email id
     * @param pass  password for email id
     */
    public ThapuSender(Context c, String dest, String email, String pass) {
        destination = dest;
        context = c;
        this.email = email;
        password = pass;
    }

    /**
     * Additional message to be added in the error log
     *
     * @param data Message to be added
     */
    public void additional(String data) {
        this.data = data;
    }

    public ThapuSender(Context c, String mail, String pass) {
        context = c;
        email = mail;
        password = pass;
    }

    @Override
    protected Void doInBackground(Void... params) {
        String st = null;
        File f = new File(context.getFilesDir(), S.thapuFile);
        if (!f.exists()) {
            M.T(context, "No Error Logs found");
        } else {
            if (S.isOnline()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    st = br.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sendmail(destination, S.appName + " error log", st);
            } else {
                M.T(context, "No internet connection");
                context.sendBroadcast(new Intent("thavara anupiten"));
            }
        }
        return null;
    }

    private void sendmail(String email, String sub, String body) {
        Session s = createsession();
        Message m = createMessage(email, sub, body, s);
        new SendMailTask().execute(m);
    }

    private Message createMessage(String email, String sub, String msgbody, Session s) {
        Message m = new MimeMessage(s);
        BodyPart bp = new MimeBodyPart();
        Multipart mp = new MimeMultipart();
        try {
            bp.setText("From :\n" + Build.MANUFACTURER + ",  " + Build.MODEL + ",  " + Build.PRODUCT + ",  " + Build.VERSION.SDK_INT + "\n\n" + data);
            mp.addBodyPart(bp);
            bp = new MimeBodyPart();
            String filename = new File(context.getFilesDir(), S.thapuFile).getAbsolutePath();
            DataSource source = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(source));
            bp.setFileName("HM_LOG.txt");
            mp.addBodyPart(bp);
            m.setFrom(new InternetAddress(destination, "ASHTech"));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "ASH"));
            m.setSubject(sub);
            m.setText(msgbody);
            m.setContent(mp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return m;
    }

    private Session createsession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
    }

    private class SendMailTask extends AsyncTask<Message, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    M.T(context, "Sending error report");
                }
            });
        }

        @Override
        protected Boolean doInBackground(Message... params) {
            try {
                Transport.send(params[0]);
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
                M.T(context, "Error Report Send failed");
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            if (aVoid) {
                M.T(context, "Error report sent");
                context.sendBroadcast(new Intent("thavara anupiten ku"));
                new File(context.getFilesDir(), S.thapuFile).delete();
            }
        }
    }
}
