package folder.select;

import android.content.Context;

import com.B58works.Backup.manager.MountReceiver;

import java.io.File;
import java.util.Comparator;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class a implements Comparator {
    public final FolderSelectActivity a;

    a(final FolderSelectActivity a) {
        this.a = a;
    }

    @Override
    public final int compare(final Object o, final Object o2) {
        e locale1 = (e)o;
        e locale2 = (e)o2;
        return locale1.b.compareToIgnoreCase(locale2.b);
    }

}
