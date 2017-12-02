package com.B58works.Backup;

import android.content.DialogInterface;

/**
 * Created by Bharath.R(58) on 02-12-2017.
 */

public class e implements DialogInterface.OnClickListener {
    public final MainActivity a;

    e(final MainActivity a) {
        this.a = a;
    }

    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.c();
    }
}
