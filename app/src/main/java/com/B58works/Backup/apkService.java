package com.B58works.Backup;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;

import com.B58works.Backup.manager.a;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class apkService extends Service {

    protected static boolean c;
    protected static w g;
    boolean h;
    com.B58works.Backup.c1.a i;
    SQLiteDatabase j;

    @Override
    public IBinder onBind(Intent intent) {
        a.c("apkService", "onBind");
        return null;
    }

    public static void a(final boolean b) {
        if (apkService.g != null) {
            if (!apkService.c) {
                apkService.g.a(b);
            }
        }
        else {
            a.c("apkService", "mlistener == null");
        }
    }
    private void a(final boolean b, final Context context) {
        if (b) {
            if (!this.h) {
                this.i = new com.B58works.Backup.c1.a(context, "apkCache");
                this.j = this.i.getWritableDatabase();
                this.h = true;
            }
        }
        else if (this.h) {
            this.j.close();
            this.i.close();
            this.h = false;
        }
    }

    public final void a(final com.B58works.Backup.b1.a a12, final Context context) {
        a(true, context);
        if (!com.B58works.Backup.c1.a.a(a12.a, this.j))
            com.B58works.Backup.c1.a.a(this.j, a12);
        a(false, context);
    }
}
