package com.B58works.Backup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.B58works.Backup.appmanager.a;
/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class g extends BaseAdapter {

    Context a;
    LayoutInflater b;
    a c;
    final /* synthetic */ MainActivity d;

    public g(final MainActivity d, final Context a) {
        this.d = d;
        this.a = a;
        this.b = (LayoutInflater)MainActivity.d.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return MainActivity.l.size();
    }

    @Override
    public Object getItem(int n) {
        return MainActivity.l.get(n);
    }

    @Override
    public long getItemId(int n) {
        return n;
    }

    @Override
    public View getView(int n, View inflate, ViewGroup viewGroup) {
        this.c = (a)MainActivity.l.get(n);
        i i;
        if (inflate == null) {
            inflate = this.b.inflate(R.layout.app_backup_item2,null);
            final i tag = new i(this.d, (byte)0);
            tag.g = (ProgressBar)inflate.findViewById(R.id.process);
            tag.f = (TextView)inflate.findViewById(R.id.action_tv);
            tag.a = (ImageView)inflate.findViewById(R.id.app_icon);
            tag.b = (TextView)inflate.findViewById(R.id.app_name);
            tag.c = (TextView)inflate.findViewById(R.id.app_size);
            tag.d = (TextView)inflate.findViewById(R.id.app_version);
            tag.e = (ImageView)inflate.findViewById(R.id.action_icon);
            inflate.setTag((Object)tag);
            i = tag;
        }
        else {
            i = (i)inflate.getTag();
        }
        i.a.setImageDrawable(this.c.j);
        i.b.setText((CharSequence)this.c.a);
        i.c.setText((CharSequence)new StringBuilder().append(this.c.d).toString());
        i.d.setText((CharSequence)new StringBuilder().append(this.c.c).toString());
        i.f.setText((CharSequence)new StringBuilder().append(this.c.f).toString());
        if (this.c.t == 4) {
            i.e.setImageResource(R.drawable.btn_check_on);
            i.h = true;
        }
        else if (this.c.t == 0) {
            i.h = true;
            i.e.setImageResource(R.drawable.btn_check_off);
        }
        else if (this.c.t == 2 || this.c.t == 1) {
            i.h = false;
        }
        if (i.h) {
            if (i.e.getVisibility() != View.VISIBLE) {
                i.e.setVisibility(View.VISIBLE);
            }
            if (i.g.getVisibility() != View.INVISIBLE) {
                i.g.setVisibility(View.INVISIBLE);
            }
        }
        else {
            if (i.e.getVisibility() != View.INVISIBLE) {
                i.e.setVisibility(View.INVISIBLE);
            }
            if (i.g.getVisibility() != View.VISIBLE) {
                i.g.setVisibility(View.VISIBLE);
            }
        }
        return inflate;
    }
}
