package yogesh.firzen.mukkiasevaigal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Activity for Error Handler
 */
public class Thapu extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_t);
        final String dest = getIntent().getStringExtra(S.thapuDest);
        final String email = getIntent().getStringExtra(S.thapuMail);
        final String pass = getIntent().getStringExtra(S.thapuPass);
        registerReceiver(br, new IntentFilter("thavara anupiten"));
        new SaveLog().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new WeakReference<Context>(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.NammaDiaAlert)
                .setTitle("Ah interesting!")
                .setMessage(R.string.error)
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        dialog = builder.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dest != null) {
                    new ThapuSender(new WeakReference<Context>(Thapu.this), dest, email, pass).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    new ThapuSender(new WeakReference<Context>(Thapu.this), email, pass).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }
            }
        });
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            dialog.dismiss();
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }

    private static class SaveLog extends AsyncTask<WeakReference<Context>, Void, Void> {
        @SafeVarargs
        @Override
        protected final Void doInBackground(WeakReference<Context>... params) {
            S.thapuThedar(params[0].get());
            return null;
        }
    }
}
