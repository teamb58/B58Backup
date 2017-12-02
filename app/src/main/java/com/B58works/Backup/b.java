package com.B58works.Backup;

import java.util.Comparator;

import com.B58works.Backup.appmanager.a;
/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class b implements Comparator {
    public final String a;
    public final MainActivity b;

    b(final MainActivity b, final String a) {
        this.b = b;
        this.a = a;
    }

    @Override
    public final int compare(final Object o, final Object o2) {
        int compareToIgnoreCase = -1;
        final a a = (a)o;
        final a a2 = (a)o2;
        if (this.a.equalsIgnoreCase("installTime")) {
            if (Long.valueOf(a.g) <= Long.valueOf(a2.g)) {
                compareToIgnoreCase = 1;
            }
        }
        else if (!this.a.equalsIgnoreCase("appName") && this.a.equalsIgnoreCase("appSize")) {
            if (Long.valueOf(a.h) <= Long.valueOf(a2.h)) {
                compareToIgnoreCase = 1;
            }
        }
        else {
            compareToIgnoreCase = a.a.compareToIgnoreCase(a2.a);
        }
        return compareToIgnoreCase;
    }
}
