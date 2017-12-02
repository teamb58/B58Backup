package com.B58works.Backup;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */
import com.B58works.Backup.manager.q;
import com.B58works.Backup.appmanager.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class c extends Thread {

    public final MainActivity a;

    c(final MainActivity a) {
        this.a = a;
    }

    @Override
    public final void run() {
        Process.setThreadPriority(-19);
        final List installedPackages = MainActivity.d.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); ++i) {
            final PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if ((0x1 & packageInfo.applicationInfo.flags) == 0x0 || (0x80 & packageInfo.applicationInfo.flags) != 0x0) {
                final String sourceDir = packageInfo.applicationInfo.sourceDir;
                final File file = new File(sourceDir);
                if (file.exists()) {
                    final a obj = new a();
                    obj.e = sourceDir;
                    obj.a = packageInfo.applicationInfo.loadLabel(MainActivity.d.getPackageManager()).toString();
                    obj.b = packageInfo.packageName;
                    obj.c = packageInfo.versionName;
                    obj.j = packageInfo.applicationInfo.loadIcon(MainActivity.d.getPackageManager());
                    obj.h = file.length();
                    obj.d = q.b(obj.h);
                    obj.g = file.lastModified();
                    obj.f = q.a(obj.g);
                    final MainActivity a = this.a;
                    final MainActivity a2 = this.a;
                    obj.t = MainActivity.a(MainActivity.a(obj.a, obj.c));
                    final Message message = new Message();
                    message.what = 108;
                    message.obj = obj;
                    MainActivity.b(this.a).sendMessage(message);
                    this.a.b.put(packageInfo.packageName, packageInfo.versionCode);
                }
            }
        }
        MainActivity.b(this.a).sendEmptyMessage(106);
    }
}
