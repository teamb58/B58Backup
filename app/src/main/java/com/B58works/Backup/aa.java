package com.B58works.Backup;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Bharath.R(58) on 02-12-2017.
 */

public class aa implements FileFilter {
    private boolean a;

    public aa() {
        this.a = false;
    }

    public aa(final byte b) {
        this.a = true;
    }

    @Override
    public final boolean accept(final File file) {
        return file.isDirectory() && file.canRead() && (!this.a || file.canWrite());
    }
}
