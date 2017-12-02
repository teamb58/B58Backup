package folder.select;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.B58works.Backup.MainActivity;
import com.B58works.Backup.R;
import com.B58works.Backup.aa;
import com.B58works.Backup.manager.MountReceiver;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bharath.R(58) on 25-11-2017.
 */

public class FolderSelectActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final String a;
    public static final String b;
    static ArrayList c;
    static ArrayList d;
    ListView e;
    c f;
    TextView g;
    Button h;
    Button i;
    Button j;
    private String k;

    static {
        a = FolderSelectActivity.class.getName();
        b = MainActivity.h;
        FolderSelectActivity.c = new ArrayList();
        FolderSelectActivity.d = new ArrayList();
    }

    public FolderSelectActivity() {
        this.k = "";
    }
    @Override
    public void onClick(final View view) {
        Label_0044: {
            switch (view.getId()) {
                case 2131099739: {
                    final String absolutePath = new File(this.k).getParentFile().getAbsolutePath();
                    com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "upToParentFolder(),partenPath:" + absolutePath);
                    while (true) {
                        for (int size = FolderSelectActivity.c.size(), i = 0; i < size; ++i) {
                            com.B58works.Backup.manager.a.b(FolderSelectActivity.a, "   getPathState:" + (String)FolderSelectActivity.c.get(i));
                            if (((String)FolderSelectActivity.c.get(i)).startsWith(absolutePath) && absolutePath.length() < ((String)FolderSelectActivity.c.get(i)).length()) {
                                final int n = 2;
                                ArrayList list = null;
                                switch (n) {
                                    default: {
                                        list = null;
                                        break;
                                    }
                                    case 0: {
                                        this.k = absolutePath;
                                        com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "  show new location :" + this.k);
                                        list = this.a(new File(this.k));
                                        break;
                                    }
                                    case 2: {
                                        com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "  show all storage:");
                                        this.k = (String)this.getText(R.string.stop_system_app);
                                        this.h.setVisibility(View.INVISIBLE);
                                        list = this.b(FolderSelectActivity.c);
                                        this.a(true);
                                        break;
                                    }
                                }
                                this.a(list);
                                break Label_0044;
                            }
                        }
                        final int n = 0;
                        continue;
                    }
                }
                case 2131099741: {
                    final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(view.getContext());
                    final View inflate = LayoutInflater.from((Context)this).inflate(R.layout.backup_path_dialog, (ViewGroup)null);
                    alertDialog$Builder.setView(inflate).setTitle(this.getText(R.string.new_folder)).setPositiveButton(R.string.yes, (DialogInterface.OnClickListener)new b(this, inflate)).setNeutralButton(R.string.no, (DialogInterface.OnClickListener)null).show();
                    ((InputMethodManager)this.getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(inflate.findViewById(R.id.backup_path_textedit), 0);
                    break;
                }
                case 2131099737: {
                    final Context context = view.getContext();
                    final String k = this.k;
                    Toast.makeText(context, R.string.backup_path_change, Toast.LENGTH_SHORT).show();
                    final SharedPreferences.Editor edit = context.getSharedPreferences("prf", 0).edit();
                    edit.putString("backup_path", k);
                    edit.commit();
                    final Intent intent = new Intent();
                    intent.putExtra("result", this.k);
                    this.setResult(-1, intent);
                    this.finish();
                    break;
                }
                case 2131099742: {
                    this.setResult(0, (Intent)null);
                    this.finish();
                    break;
                }
            }
        }
    }

    public static String a(final Context context) {
        int n = 1;
        FolderSelectActivity.c = MountReceiver.a();
        String s = context.getSharedPreferences("prf", 0).getString("backup_path", "");
        Label_0098: {
            Label_0094: {
                if (s.length() > n) {
                    com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "isPathAvailable,path:" + s + "#");
                    while (true) {
                        Label_0136: {
                            if (s.length() <= 0) {
                                break Label_0136;
                            }
                            final File file = new File(s);
                            if (!file.exists() || (!file.canWrite() && (!file.mkdir() || !file.canWrite()))) {
                                break Label_0136;
                            }
                            if (n == 0) {
                                break Label_0094;
                            }
                            break Label_0098;
                        }
                        n = 0;
                        continue;
                    }
                }
            }
            s = FolderSelectActivity.b;
        }
        com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "getBackupPath:" + s);
        return s;
    }
    public static void a(final FolderSelectActivity folderSelectActivity, final Context context, final String s, final String s2) {
        final File file = new File(s + File.separator + s2);
        int n;
        if (file.exists()) {
            n = 2131361923;
        }
        else if (file.mkdir()) {
            n = 2131361922;
            folderSelectActivity.a(folderSelectActivity.a(new File(s)));
        }
        else {
            n = 2131361924;
        }
        Toast.makeText(context, n, Toast.LENGTH_SHORT).show();
    }

    public static String a(final FolderSelectActivity folderSelectActivity) {
        return folderSelectActivity.k;
    }

    private void a(final ArrayList d) {
        this.g.setText((CharSequence)this.k);
        FolderSelectActivity.d = d;
        if (this.f != null) {
            this.f = new c(this, FolderSelectActivity.d, this.getLayoutInflater());
            this.e.setAdapter((ListAdapter)this.f);
        }
    }

    private void a(final boolean b) {
        int visibility = 8;
        boolean enabled = true;
        this.i.setEnabled(!b && enabled);
        final Button j = this.j;
        if (b) {
            enabled = false;
        }
        j.setEnabled(enabled);
        final Button h = this.h;
        int visibility2;
        if (b) {
            visibility2 = visibility;
        }
        else {
            visibility2 = 0;
        }
        h.setVisibility(visibility2);
        final TextView g = this.g;
        if (!b) {
            visibility = 0;
        }
        g.setVisibility(visibility);
    }
    private ArrayList b(final ArrayList list) {
        final ArrayList<e> list2 = new ArrayList<e>();
        for (int size = list.size(), i = 0; i < size; ++i) {
            list2.add(new e(this, new File((String) list.get(i)).getName(), (String) list.get(i)));
            com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "getStorageList.add():" + list.get(i));
        }
        return list2;
    }

    private ArrayList a(final File file) {
        int i = 0;
        final ArrayList<Object> list = new ArrayList<Object>();
        final File[] listFiles = file.listFiles(new aa((byte)0));
        if (listFiles == null || listFiles.length <= 0) {
            com.B58works.Backup.manager.a.b(FolderSelectActivity.a, "ilelist == null," + file.getAbsolutePath());
        }
        else {
            while (i < listFiles.length) {
                list.add(new e(this, listFiles[i].getName(), listFiles[i].getAbsolutePath()));
                com.B58works.Backup.manager.a.a(FolderSelectActivity.a, "getFolderList.add():" + listFiles[i].getName() + "  " + listFiles[i].getAbsolutePath());
                ++i;
            }
            Collections.sort(list, new folder.select.a(this));
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.k = ((e)d.get(i)).b;
        this.a(this.a(new File(this.k)));
        this.a(false);

    }
}
