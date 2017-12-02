package folder.select;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.B58works.Backup.R;

import java.util.ArrayList;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class c extends BaseAdapter {
    ArrayList a;
    public final FolderSelectActivity b;
    private LayoutInflater c;

    c(final FolderSelectActivity b, final ArrayList a, final LayoutInflater c) {
        this.b = b;
        this.a = a;
        this.c = c;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(final int n) {
        return this.a.get(n);
    }

    public final long getItemId(final int n) {
        return n;
    }

    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        d d;
        if (inflate == null) {
            inflate = this.c.inflate(R.layout.select_folder_item, (ViewGroup)null);
            final d tag = new d(this);
            tag.a = (TextView)inflate.findViewById(R.id.folder);
            inflate.findViewById(R.id.check).setVisibility(View.GONE);
            inflate.setTag((Object)tag);
            d = tag;
        }
        else {
            d = (d)inflate.getTag();
        }
        d.a.setText(((e)this.a.get(n)).a);
        return inflate;
    }
}
