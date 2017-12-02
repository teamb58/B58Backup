package com.B58works.Backup.c1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class a extends SQLiteOpenHelper {

    private static String a;

    static {
        a = "apkCache";
    }
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "onCreate()");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + a + " (path VARCHAR PRIMARY KEY,appName VARCHAR,packageName VARCHAR,versionName VARCHAR,size VARCHAR,date VARCHAR,realtime INTEGER(4),realsize INTEGER(4),versionCode INTEGER,maped INTEGER,inited INTEGER,icon BLOB)");
    }

    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "onUpgrade()");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + a);
        this.onCreate(sqLiteDatabase);
    }

    public a(final Context context, final String a1) {
        super(context, a1, (SQLiteDatabase.CursorFactory)null, 2);
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "ApkCacheHelper()");
        a = a1;
    }

    public static void a(final SQLiteDatabase sqLiteDatabase, final com.B58works.Backup.b1.a a) {
        int n = 1;
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "insert(),mApk:" + a.b);
        final ContentValues contentValues = new ContentValues();
        contentValues.put("path", a.a);
        contentValues.put("appName", a.b);
        contentValues.put("packageName", a.c);
        contentValues.put("versionName", a.d);
        contentValues.put("size", a.e);
        contentValues.put("date", a.f);
        contentValues.put("realsize", a.g);
        contentValues.put("versionCode", a.h);
        contentValues.put("realtime", a.i);
        int n2;
        if (a.j) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        contentValues.put("maped", n2);
        if (!a.l) {
            n = 0;
        }
        contentValues.put("inited", n);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (a.j) {
            a.k.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)byteArrayOutputStream);
        }
        contentValues.put("icon", byteArrayOutputStream.toByteArray());
        if (sqLiteDatabase != null) {
            sqLiteDatabase.insert(a.a, (String)null, contentValues);
        }
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "insert(),done");
    }

    public static boolean a(final String s, final SQLiteDatabase sqLiteDatabase) {
        com.B58works.Backup.manager.a.c("ApkCacheHelper", "ExistInTable()");
        final Cursor rawQuery = sqLiteDatabase.rawQuery("select * from " + com.B58works.Backup.c1.a.a, (String[])null);
        final int columnIndex = rawQuery.getColumnIndex("path");
        final boolean moveToFirst = rawQuery.moveToFirst();
        boolean b = false;
        Label_0073: {
            if (moveToFirst) {
                while (!s.equalsIgnoreCase(rawQuery.getString(columnIndex))) {
                    if (!rawQuery.moveToNext()) {
                        b = false;
                        break Label_0073;
                    }
                }
                b = true;
            }
        }
        rawQuery.close();
        return b;
    }
}
