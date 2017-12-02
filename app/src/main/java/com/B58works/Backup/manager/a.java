package com.B58works.Backup.manager;

import android.util.Log;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class a {
    public static Boolean a;
    static String b;

    static {
        com.B58works.Backup.manager.a.a = false;
        com.B58works.Backup.manager.a.b = "DBG";
    }

    public static void a(final String s) {
        if (com.B58works.Backup.manager.a.a) {
            Log.d(com.B58works.Backup.manager.a.b, new StringBuilder().append(s).toString());
        }
    }

    public static void a(final String s, final String s2) {
        if (com.B58works.Backup.manager.a.a) {
            Log.d(s, new StringBuilder().append(s2).toString());
        }
    }

    public static void b(final String s) {
        if (com.B58works.Backup.manager.a.a) {
            Log.e(com.B58works.Backup.manager.a.b, new StringBuilder().append(s).toString());
        }
    }

    public static void b(final String s, final String s2) {
        if (com.B58works.Backup.manager.a.a) {
            Log.e(s, new StringBuilder().append(s2).toString());
        }
    }

    public static void c(final String s) {
        b(s);
    }

    public static void c(final String s, final String s2) {
        a(s, s2);
    }

    public static void d(final String s, final String s2) {
        b(s, s2);
    }

    public static void e(final String s, final String s2) {
        if (com.B58works.Backup.manager.a.a) {
            Log.v(s, new StringBuilder().append(s2).toString());
        }
    }
}
