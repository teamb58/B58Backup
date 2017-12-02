package com.B58works.Backup.b1;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

import java.text.*;
import java.io.*;
import android.content.pm.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.util.*;

import static android.graphics.Bitmap.*;

public class a {

    public static SimpleDateFormat n;
    static StringBuffer o;
    static DecimalFormat p;
    static float q;
    static float r;
    static float s;
    private static PackageInfo t;
    private static ApplicationInfo u;
    private static Drawable v;
    private static File w;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public int h;
    public long i;
    public boolean j;
    public Bitmap k;
    public boolean l;
    public boolean m;

    static {
        n = new SimpleDateFormat("yyyy-MM-dd");
        p = new DecimalFormat("########.00");
    }

    public a() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = 0L;
        this.h = 0;
        this.i = 0L;
        this.j = false;
        this.k = null;
        this.l = false;
        this.m = false;
    }

    public a(final String publicSourceDir, final PackageManager packageManager) {
        Bitmap k = null;
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = 0L;
        this.h = 0;
        this.i = 0L;
        this.j = false;
        this.k = null;
        this.l = false;
        this.m = false;
        this.a = publicSourceDir;
        w = new File(publicSourceDir);
        this.g = w.length();
        this.e = a(this.g);
        this.i = w.lastModified();
        this.f = n.format(this.i);
        if ((t = packageManager.getPackageArchiveInfo(publicSourceDir, PackageManager.GET_ACTIVITIES)) == null) {
            return;
        }
        u = t.applicationInfo;
        this.c = t.packageName;
        this.d = t.versionName;
        this.h = t.versionCode;
        Label_0302:
        while (true) {
            if (u == null) {
                break Label_0302;
            }
            while (true) {
                u.sourceDir = publicSourceDir;
                u.publicSourceDir = publicSourceDir;
                this.b = packageManager.getApplicationLabel(u).toString();
                while (true) {
                    Bitmap bitmap = null;
                    Label_0436: {
                        while (true) {
                            try {
                                final Drawable drawable = v = u.loadIcon(packageManager);
                                k = null;
                                if (drawable == null) {
                                    this.j = true;
                                    if (k != null) {
                                        this.k = k;
                                    }
                                    this.l = true;
                                    return;
                                }
                                final boolean instance = Bitmap.class.isInstance(v);
                                k = null;
                                if (instance) {
                                    bitmap = ((BitmapDrawable)v).getBitmap();
                                }
                                else {
                                    final Drawable v = com.B58works.Backup.b1.a.v;
                                    final int intrinsicWidth = v.getIntrinsicWidth();
                                    final int intrinsicHeight = v.getIntrinsicHeight();
                                    final int opacity = v.getOpacity();
                                    k = null;
                                    if (opacity == -1) {
                                        break Label_0436;
                                    }
                                    final Bitmap.Config bitmap$Config = Bitmap.Config.ARGB_8888;
                                    bitmap = createBitmap(intrinsicWidth, intrinsicHeight, bitmap$Config);
                                    final Canvas canvas = new Canvas(bitmap);
                                    v.setBounds(0, 0, v.getIntrinsicWidth(), v.getIntrinsicHeight());
                                    v.draw(canvas);
                                }
                            }
                            catch (OutOfMemoryError outOfMemoryError) {
                                Log.e("ApkIconLoader", "OutOfMemoryError:" + outOfMemoryError.toString());
                                if (k != null) {
                                    this.k = k;
                                }
                                continue Label_0302;
                            }
                            finally {
                                if (k != null) {
                                    this.k = k;
                                }
                            }
                            break;
                        }
                    }
                    k = bitmap;
                    continue;
                }
            }
        }
    }

    public static String a(final long n) {
        o = new StringBuffer();
        if (n >= 1024L) {
            if ((q = n / 1024.0f) >= 1024.0f) {
                if ((r = q / 1024.0f) >= 1024.0f) {
                    s = r / 1024.0f;
                    o.append(p.format(s));
                    o.append("G");
                }
                else {
                    o.append(p.format(r));
                    o.append("M");
                }
            }
            else {
                o.append(p.format(q));
                o.append("K");
            }
        }
        else {
            o.append(n);
            o.append("B");
        }
        return o.toString();
    }
}
