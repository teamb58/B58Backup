package com.B58works.Backup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.B58works.Backup.appmanager.a;

import folder.select.FolderSelectActivity;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    public static final String a;
    public static Activity c;
    public static Context d;
    public static String h;
    public static boolean i;
    public static ArrayList l;
    private static ArrayList m;
    private static ArrayList n;
    private static ArrayList o;
    private static ArrayList p;
    private static g s;
    public HashMap b;
    List e;
    ListView f;
    PackageManager g;
    apkService j;
    String k;
    private Vector q;
    private ArrayList r;
    private boolean t;
    private j u;
    private Handler v;

    static {
        a = MainActivity.class.getName();
        MainActivity.l = new ArrayList();
        MainActivity.m = new ArrayList();
        MainActivity.n = new ArrayList();
        MainActivity.o = new ArrayList();
        MainActivity.p = new ArrayList();
        MainActivity.h = Environment.getExternalStorageDirectory() + "/apkBackup";
        MainActivity.i = false;
    }

    public MainActivity() {
        this.b = new HashMap();
        this.q = new Vector();
        this.r = new ArrayList();
        this.t = false;
        this.u = new j(this, (byte)0);
        this.v = new com.B58works.Backup.a(this);
        this.j = new apkService();
        this.k = "";
    }

    static int a(final String s) {
        com.B58works.Backup.manager.a.a("get_state:" + s);
        int n;
        if (new File(s).exists()) {
            n = 4;
        }
        else {
            n = 0;
        }
        return n;
    }

    public static g a(final g s) {
        return MainActivity.s = s;
    }

    public static String a(final Context context) {
        return context.getSharedPreferences("prf", 0).getString("app_backup_sort", "appName");
    }

    static String a(final String s, final String s2) {
        return MainActivity.h + File.separator + s + "_" + s2 + ".apk";
    }

    public static void a(final MainActivity MainActivity) {
        if (MainActivity.e != null && !MainActivity.e.isEmpty()) {
            MainActivity.e.clear();
            MainActivity.s.notifyDataSetChanged();
        }
        synchronized (MainActivity.l) {
            if (MainActivity.l != null && !MainActivity.l.isEmpty()) {
                MainActivity.l.clear();
                com.B58works.Backup.manager.a.a("appList.clear()");
            }
            MainActivity.s.notifyDataSetChanged();
            // monitorexit(MainActivity.l)
            new c(MainActivity).start();
        }
    }

    public static void a(final MainActivity MainActivity, final String s) {
        Collections.sort((List<Object>)MainActivity.l, new b(MainActivity, s));
    }

    public static boolean a() {
        return MainActivity.i;
    }

    public static Handler b(final MainActivity MainActivity) {
        return MainActivity.v;
    }

    private void b(int paramInt)
    {
        while (true)
        {
            synchronized (l)
            {
                if (((com.B58works.Backup.appmanager.a)l.get(paramInt)).t == 0)
                {
                    ((com.B58works.Backup.appmanager.a)l.get(paramInt)).t = 2;
                    s.notifyDataSetChanged();
                }
                synchronized (this.r)
                {
                    this.r.add(new h(this, paramInt));
                    if (!this.u.getStatus().equals(AsyncTask.Status.RUNNING))
                    {
                        if (this.u.getStatus().equals(AsyncTask.Status.FINISHED))
                        {
                            this.u = new j(this, (byte)0);
                            this.u.execute(new String[] { "" });
                        }
                    }
                    else
                        return;
                }
            }
            if (this.u.getStatus().equals(AsyncTask.Status.PENDING))
                this.u.execute(new String[] { "" });
        }
    }

    private void b(final String s) {
        this.findViewById(R.id.backup_path).setVisibility(View.VISIBLE);
        ((TextView)this.findViewById(R.id.backup_path)).setText((CharSequence)((Object)this.getText(R.string.backup_path) + ":" + s));
    }

    private static boolean b(final String s, final String s2) {
        boolean b = false;
        com.B58works.Backup.manager.a.a("copy file:" + s);
        try {
            final File file = new File(s);
            if (!new File(MainActivity.h).exists()) {
                new File(MainActivity.h).mkdirs();
            }
            new File(s2).createNewFile();
            if (file.exists()) {
                final FileInputStream fileInputStream = new FileInputStream(s);
                final FileOutputStream fileOutputStream = new FileOutputStream(s2);
                final byte[] array = new byte[1444];
                while (true) {
                    final int read = fileInputStream.read(array);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(array, 0, read);
                }
                fileInputStream.close();
            }
            b = true;
        }
        catch (Exception ex) {}
        return b;
    }

    private static String c(final int n) {
        return a(((com.B58works.Backup.appmanager.a)l.get(n)).a, ((com.B58works.Backup.appmanager.a)l.get(n)).c);
    }

    public static ArrayList c(final MainActivity MainActivity) {
        return MainActivity.r;
    }

    public static int d() {
        final String externalStorageState = Environment.getExternalStorageState();
        int n;
        if ("mounted".equals(externalStorageState)) {
            n = 2;
        }
        else if ("mounted_ro".equals(externalStorageState)) {
            n = 1;
        }
        else {
            n = 0;
        }
        return n;
    }

    private static boolean d(final int n) {
        com.B58works.Backup.manager.a.a("appexit? " + c(n));
        return new File(c(n)).exists();
    }

    public static ArrayList e() {
        return MainActivity.l;
    }

    public static g f() {
        return MainActivity.s;
    }

    final void a(final int n) {
        if (d() != 2) {
            this.v.sendEmptyMessage(107);
        }
        else if (!d(n)) {
            synchronized (MainActivity.l) {
                this.k = c(n);
                b(((com.B58works.Backup.appmanager.a)l.get(n)).e, this.k);
                ((com.B58works.Backup.appmanager.a)l.get(n)).t = a(this.k);
                // monitorexit(MainActivity.l)
                this.j.a(new com.B58works.Backup.b1.a(this.k, MainActivity.d.getPackageManager()), this.getApplicationContext());
            }
        }
    }

    final void b() {
        final File[] listFiles = new File(MainActivity.h).listFiles();
        if (listFiles.length > 0) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                listFiles[i].delete();
            }
            synchronized (MainActivity.l) {
                for (int j = MainActivity.l.size(), n = 0; j > n; ++n) {
                    ((com.B58works.Backup.appmanager.a)MainActivity.l.get(n)).t = 0;
                }
                // monitorexit(MainActivity.l)
                this.v.sendEmptyMessageDelayed(105, 50L);
            }
        }
    }

    final void c() {
        int i = 0;
        if (d() != 2) {
            Toast.makeText((Context)this, R.string.sd_no_write, Toast.LENGTH_SHORT).show();
        }
        else {
            while (i < MainActivity.l.size()) {
                this.b(i);
                ++i;
            }
        }
    }

    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n2 == -1) {
            final String string = intent.getExtras().getString("result");
            if (string != null && string.length() > 1) {
                this.b(MainActivity.h = string);
            }
            com.B58works.Backup.manager.a.b(MainActivity.class.getName(), "onActivityResult:" + string);
        }
    }

    public boolean onContextItemSelected(final MenuItem menuItem) {
        final AdapterView.AdapterContextMenuInfo adapterView$AdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)menuItem.getMenuInfo();
        boolean b = false;
        switch (menuItem.getItemId()) {
            default: {
                b = super.onContextItemSelected(menuItem);
                break;
            }
            case 123: {
                final int n = (int)adapterView$AdapterContextMenuInfo.id;
                if (d() != 2) {
                    Toast.makeText((Context)this, R.string.sd_no_write, Toast.LENGTH_SHORT).show();
                }
                else {
                    new File(c(n)).delete();
                    synchronized (MainActivity.l) {
                        ((com.B58works.Backup.appmanager.a)MainActivity.l.get(n)).t = a(c(n));
                        com.B58works.Backup.manager.a.a("delete file:" + ((com.B58works.Backup.appmanager.a)MainActivity.l.get(n)).a + ",   position:" + n);
                        // monitorexit(MainActivity.l)
                        this.v.sendEmptyMessage(106);
                    }
                }
                b = super.onContextItemSelected(menuItem);
                break;
            }
        }
        return b;
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.app_backup);
        (this.f = this.findViewById(R.id.app_list)).setOnItemClickListener(this);
        MainActivity.c = this;
        MainActivity.d = this.getApplicationContext();
        this.g = MainActivity.c.getPackageManager();
        this.registerForContextMenu(this.f);
        com.B58works.Backup.manager.a.a("onCreate");
        h = FolderSelectActivity.a(getApplicationContext());
        b(h);
    }

    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
    }

    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.app_backup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        com.B58works.Backup.manager.a.a("onDestroy");
        super.onDestroy();
    }

    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.b(n);
    }

    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131099806: {
                new AlertDialog.Builder((Context)this).setMessage(R.string.backup_all_confirm).setPositiveButton(R.string.yes, (DialogInterface.OnClickListener)new e(this)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener)null).show();
                break;
            }
            case 2131099682: {
                this.startActivityForResult(new Intent((Context)this, (Class)FolderSelectActivity.class), 1);
                break;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(final Menu menu) {
        final boolean b = this.u != null && (this.u.getStatus().equals((Object)AsyncTask.Status.FINISHED) || this.u.getStatus().equals((Object)AsyncTask.Status.PENDING));
        menu.findItem(R.id.backup_all).setVisible(b);
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume() {
        com.B58works.Backup.manager.a.a("onResume");
        ((ImageView)this.findViewById(R.id.back_btn)).setOnClickListener((View.OnClickListener)new d(this));
        ((TextView)this.findViewById(R.id.title_text)).setText(this.getText(R.string.head_title_app_backup));
        if (!MainActivity.i) {
            this.v.sendEmptyMessageDelayed(105, 50L);
        }
        else {
            this.f.setAdapter((ListAdapter)MainActivity.s);
            this.findViewById(R.id.tittle_process).setVisibility(View.VISIBLE);
        }
        super.onResume();
    }

}
