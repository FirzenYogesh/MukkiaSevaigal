package yogesh.firzen.mukkiasevaigal;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by user on 10-05-2016.
 */
public class D {

    private DB db;

    public static void createDB(Context context, String name) {
        //db =
    }


    private class DB extends SQLiteOpenHelper {

        private DB(Context context, String db) {
            super(context, db, null, 1, null);
        }

        private DB(Context context, String db, DatabaseErrorHandler handler) {
            super(context, db, null, 1, handler);
        }

        private DB(Context context, String db, int ver) {
            super(context, db, null, ver, null);
        }

        private DB(Context context, String db, int ver, DatabaseErrorHandler handler) {
            super(context, db, null, ver, handler);
        }

        private DB(Context context, String db, SQLiteDatabase.CursorFactory factory) {
            super(context, db, factory, 1, null);
        }

        private DB(Context context, String db, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler handler) {
            super(context, db, factory, 1, handler);
        }

        private DB(Context context, String db, SQLiteDatabase.CursorFactory factory, int ver) {
            super(context, db, factory, ver, null);
        }

        private DB(Context context, String db, SQLiteDatabase.CursorFactory factory, int ver, DatabaseErrorHandler handler) {
            super(context, db, factory, ver, handler);
        }

        private DB(Context context, File db) {
            super(context, db.getAbsolutePath(), null, 1, null);
        }

        private DB(Context context, File db, DatabaseErrorHandler handler) {
            super(context, db.getAbsolutePath(), null, 1, handler);
        }

        private DB(Context context, File db, int ver) {
            super(context, db.getAbsolutePath(), null, ver, null);
        }

        private DB(Context context, File db, int ver, DatabaseErrorHandler handler) {
            super(context, db.getAbsolutePath(), null, ver, handler);
        }

        private DB(Context context, File db, SQLiteDatabase.CursorFactory factory) {
            super(context, db.getAbsolutePath(), factory, 1, null);
        }

        private DB(Context context, File db, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler handler) {
            super(context, db.getAbsolutePath(), factory, 1, handler);
        }

        private DB(Context context, File db, SQLiteDatabase.CursorFactory factory, int ver) {
            super(context, db.getAbsolutePath(), factory, ver, null);
        }

        private DB(Context context, File db, SQLiteDatabase.CursorFactory factory, int ver, DatabaseErrorHandler handler) {
            super(context, db.getAbsolutePath(), factory, ver, handler);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
