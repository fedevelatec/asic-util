package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


import java.io.File;
import java.io.FileFilter;


public class FiltroExtensionTIF implements FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.getName().endsWith(".tif") || f.getName().endsWith(".TIF")) return true;
        return false;
    }


    public String getDescription() {
        return "Archivos TIF";
    }
}