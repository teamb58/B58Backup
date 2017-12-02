package com.B58works.Backup.manager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class q extends BaseAdapter {

    public static SimpleDateFormat h;
    static StringBuffer i;
    static float k;
    static float l;
    static float m;
    static DecimalFormat j;

    static {
        h = new SimpleDateFormat("yyyy-MM-dd");
        i = new StringBuffer();
        j = new DecimalFormat("########.00");

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public static String a(final long n) {
        return h.format(n);
    }

    public static String b(final long n) {
       i = new StringBuffer();
        if (n >= 1024L) {
            if ((k = n / 1024.0f) >= 1024.0f) {
                if ((l = k / 1024.0f) >= 1024.0f) {
                    m = l / 1024.0f;
                    i.append(j.format(m));
                    i.append(" G");
                }
                else {
                    i.append(j.format(l));
                    i.append(" M");
                }
            }
            else {
                i.append(j.format(k));
                i.append(" K");
            }
        }
        else {
            i.append(n);
            i.append(" B");
        }
        return i.toString();
    }
}
