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
import java.lang.ref.WeakReference;
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

    private WeakReference<Context> context;
    private String destination;
    private String email;
    private String password;
    private String data = "";

    /**
     * @param c     a weak reference to the context
     * @param dest  destination email
     * @param email email id
     * @param pass  password for email id
     */
    public ThapuSender(WeakReference<Context> c, String dest, String email, String pass) {
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

    /**
     * @param c    a weak reference to the context
     * @param mail email id
     * @param pass password for email id
     */
    public ThapuSender(WeakReference<Context> c, String mail, String pass) {
        context = c;
        email = mail;
        password = pass;
        destination = email;
    }

    @Override
    protected Void doInBackground(Void... params) {
        String st = null;
        File f = new File(getContext().getFilesDir(), S.thapuFile);
        if (!f.exists()) {
            M.T(getContext(), "No Error Logs found");
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
                M.T(getContext(), "No internet connection");
                getContext().sendBroadcast(new Intent("thavara anupiten"));
            }
        }
        return null;
    }

    private void sendmail(String email, String sub, String body) {
        Session s = createsession();
        Message m = createMessage(email, sub, body, s);
        new SendMailTask(context).execute(m);
    }

    private Message createMessage(String email, String sub, String msgbody, Session s) {
        Message m = new MimeMessage(s);
        BodyPart bp = new MimeBodyPart();
        Multipart mp = new MimeMultipart();
        try {
            bp.setText("From :\n" + Build.MANUFACTURER + ",  " + Build.MODEL + ",  " + Build.PRODUCT + ",  " + Build.VERSION.SDK_INT + "\n\n" + data);
            mp.addBodyPart(bp);
            bp = new MimeBodyPart();
            String filename = new File(getContext().getFilesDir(), S.thapuFile).getAbsolutePath();
            DataSource source = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(source));
            bp.setFileName("HM_LOG.txt");
            mp.addBodyPart(bp);
            m.setFrom(new InternetAddress(destination, "MukkiaSevaigal"));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "MukkiaSevaigal"));
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

    private static class SendMailTask extends AsyncTask<Message, Void, Boolean> {

        private WeakReference<Context> context;

        SendMailTask(WeakReference<Context> context) {
            this.context = context;
        }

        private Context getContext() {
            return context.get();
        }

        @Override
        protected void onPreExecute() {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    M.T(getContext(), "Sending error report");
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
                M.T(getContext(), "Error Report Send failed");
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            if (aVoid) {
                M.T(getContext(), "Error report sent");
                getContext().sendBroadcast(new Intent("thavara anupiten ku"));
                new File(getContext().getFilesDir(), S.thapuFile).delete();
            }
        }
    }

    private Context getContext() {
        return context.get();
    }
}
