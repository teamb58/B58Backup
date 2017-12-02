package folder.select;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import com.B58works.Backup.R;

/**
 * Created by Bharath.R(58) on 02-12-2017.
 */

public class b implements DialogInterface.OnClickListener {
    public final View a;
    public final FolderSelectActivity b;

    b(final FolderSelectActivity b, final View a) {
        this.b = b;
        this.a = a;
    }

    public final void onClick(final DialogInterface dialogInterface, final int n) {
        final String string = ((EditText)this.a.findViewById(R.id.backup_path_textedit)).getText().toString();
        com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "str:" + string);
        FolderSelectActivity.a(this.b, this.a.getContext(), FolderSelectActivity.a(this.b), string);
    }
}
