package com.B58works.Backup;

import android.view.View;

/**
 * Created by Bharath.R(58) on 02-12-2017.
 */

public class d implements View.OnClickListener{
    public final MainActivity a;

    d(final MainActivity a) {
        this.a = a;
    }

    public final void onClick(final View view) {
        this.a.finish();
    }
}
