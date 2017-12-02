package com.B58works.Backup.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Bharath.R(58) on 02-12-2017.
 */

public class MountReceiver extends BroadcastReceiver {
    public static String a;
    private static final String[] b;

    static {
        MountReceiver.a = MountReceiver.class.getName();
        b = new String[] { "df" };
    }

    public static ArrayList a() {
        final String[] b = b();
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < b.length; ++i) {
            if (b[i].startsWith("/") && b[i].length() >= 2) {
                final File file = new File(b[i]);
                if (file.exists() && file.isDirectory() && file.canWrite() && !b[i].startsWith("/data")) {
                    hashMap.put(b[i], b[i]);
                    com.B58works.Backup.manager.a.b(MountReceiver.a, "  cann save file," + b[i]);
                }
                else {
                    com.B58works.Backup.manager.a.a(MountReceiver.a, "  can't save file," + b[i]);
                }
            }
        }
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getValue());
        }
        return list;
    }

    private static String[] b() {
        Label_0043_Outer:
        while (true) {
           String a = "";
            while (true) {
                while (true) break;
                final String replaceAll = "";
                continue;
            }
        }
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        final Uri data = intent.getData();
        com.B58works.Backup.manager.a.a(MountReceiver.a, "path:" + data.getPath() + "  uri:" + data.toString() + "  intent:" + intent.toString());
        if (!action.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED") && !action.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED") && !action.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED") && !action.equalsIgnoreCase("android.intent.action.MEDIA_SHARED") && !action.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) {
            action.equalsIgnoreCase("android.intent.action.MEDIA_BAD_REMOVAL");
        }
        a();
    }
}
