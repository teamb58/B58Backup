package com.B58works.Backup;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

import android.os.*;
import android.content.*;
import android.view.View;
import android.widget.*;

public class a extends Handler {
    public final MainActivity a;

    a(final MainActivity a) {
        this.a = a;
    }

    public final void handleMessage(final Message message) {
        switch (message.what) {
            case 105: {
                final MainActivity a = this.a;
                final Context d = MainActivity.d;
                MainActivity.e();
                MainActivity.a(new g(a, d));
                this.a.f.setAdapter((ListAdapter)MainActivity.f());
                this.a.findViewById(R.id.tittle_process).setVisibility(View.VISIBLE);
                MainActivity.a(this.a);
                break;
            }
            case 106: {
                final MainActivity a2 = this.a;
                final MainActivity a3 = this.a;
                MainActivity.a(a2, MainActivity.a((Context)this.a.getApplication()));
                MainActivity.f().notifyDataSetChanged();
                if (MainActivity.a()) {
                    this.a.findViewById(R.id.tittle_process).setVisibility(View.VISIBLE);
                    break;
                }
                this.a.findViewById(R.id.tittle_process).setVisibility(View.INVISIBLE);
                break;
            }
            case 107: {
                Toast.makeText(MainActivity.d, R.string.sd_no_write, Toast.LENGTH_SHORT).show();
                break;
            }
            case 108: {
                MainActivity.e().add(message.obj);
                MainActivity.f().notifyDataSetChanged();
                break;
            }
        }
    }
}
