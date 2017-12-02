package com.B58works.Backup;

import android.os.AsyncTask;


/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class j extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
        return this.b();
    }

    int a;
    public final MainActivity b;

    private j(final MainActivity b) {
        this.b = b;
    }

    public j(final MainActivity a, final byte b) {
        this(a);
    }

    private void a() {
        com.B58works.Backup.manager.a.a("onProgressUpdate");
        MainActivity.b(this.b).sendEmptyMessage(106);
    }

    private Long b()
    {
        com.B58works.Backup.manager.a.b("doInBackground");
        while (!MainActivity.c(this.b).isEmpty())
        {
            synchronized (MainActivity.e())
            {
                com.B58works.Backup.manager.a.b("selectList.size:" + MainActivity.c(this.b).size() + " appList.size:" + MainActivity.e().size());
                synchronized (MainActivity.c(this.b))
                {
                    this.a = ((h)MainActivity.c(this.b).get(0)).a;
                    MainActivity.c(this.b).remove(0);
                }
            }
            synchronized (MainActivity.e())
            {
                ((com.B58works.Backup.appmanager.a)MainActivity.e().get(this.a)).t = 1;
                MainActivity.b(this.b).sendEmptyMessage(106);
                this.b.a(this.a);
                a();
                continue;

            }
        }
        super.onPostExecute(null);
        return null;
    }
    
    protected final void onPostExecute(final Object o) {
        com.B58works.Backup.manager.a.b("onPostExecute");
        apkService.a(MainActivity.i = false);
        MainActivity.b(this.b).sendEmptyMessageDelayed(106, 200L);
    }

    protected final void onPreExecute() {
        com.B58works.Backup.manager.a.b("onPreExecute");
        synchronized (MainActivity.e()) {
            com.B58works.Backup.manager.a.b("selectList.size:" + MainActivity.c(this.b).size() + " appList.size:" + MainActivity.e().size());
            // monitorexit(MainActivity.e())
            MainActivity.i = true;
            super.onPreExecute();
        }
    }

    protected final void onProgressUpdate(final Object[] array) {
        this.a();
    }
}
