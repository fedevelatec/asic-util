package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


import java.io.File;
import javax.swing.filechooser.FileFilter;


public class FiltroExtensionXLS extends FileFilter {
    public boolean accept(File f) {
        if (f.getName().endsWith(".xls") || f.getName().endsWith(".XLS")) return true;
        return false;
    }


    public String getDescription() {
        return "Archivos de Microsoft Excel";
    }
}

