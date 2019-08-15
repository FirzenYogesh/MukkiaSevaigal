package yogesh.firzen.mukkiasevaigal

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

import java.io.File

/**
 * Created by user on 10-05-2016.
 */
@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
class D {

    private val db: DB? = null


    private inner class DB : SQLiteOpenHelper {

        private constructor(context: Context, db: String) : super(context, db, null, 1, null) {}

        private constructor(context: Context, db: String, handler: DatabaseErrorHandler) : super(context, db, null, 1, handler) {}

        private constructor(context: Context, db: String, ver: Int) : super(context, db, null, ver, null) {}

        private constructor(context: Context, db: String, ver: Int, handler: DatabaseErrorHandler) : super(context, db, null, ver, handler) {}

        private constructor(context: Context, db: String, factory: SQLiteDatabase.CursorFactory) : super(context, db, factory, 1, null) {}

        private constructor(context: Context, db: String, factory: SQLiteDatabase.CursorFactory, handler: DatabaseErrorHandler) : super(context, db, factory, 1, handler) {}

        private constructor(context: Context, db: String, factory: SQLiteDatabase.CursorFactory, ver: Int) : super(context, db, factory, ver, null) {}

        private constructor(context: Context, db: String, factory: SQLiteDatabase.CursorFactory, ver: Int, handler: DatabaseErrorHandler) : super(context, db, factory, ver, handler) {}

        private constructor(context: Context, db: File) : super(context, db.absolutePath, null, 1, null) {}

        private constructor(context: Context, db: File, handler: DatabaseErrorHandler) : super(context, db.absolutePath, null, 1, handler) {}

        private constructor(context: Context, db: File, ver: Int) : super(context, db.absolutePath, null, ver, null) {}

        private constructor(context: Context, db: File, ver: Int, handler: DatabaseErrorHandler) : super(context, db.absolutePath, null, ver, handler) {}

        private constructor(context: Context, db: File, factory: SQLiteDatabase.CursorFactory) : super(context, db.absolutePath, factory, 1, null) {}

        private constructor(context: Context, db: File, factory: SQLiteDatabase.CursorFactory, handler: DatabaseErrorHandler) : super(context, db.absolutePath, factory, 1, handler) {}

        private constructor(context: Context, db: File, factory: SQLiteDatabase.CursorFactory, ver: Int) : super(context, db.absolutePath, factory, ver, null) {}

        private constructor(context: Context, db: File, factory: SQLiteDatabase.CursorFactory, ver: Int, handler: DatabaseErrorHandler) : super(context, db.absolutePath, factory, ver, handler) {}

        override fun onCreate(db: SQLiteDatabase) {

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
    }

    companion object {

        fun createDB(context: Context, name: String) {
            //db =
        }
    }
}
