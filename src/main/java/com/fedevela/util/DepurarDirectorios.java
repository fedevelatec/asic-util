package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DepurarDirectorios {

    public DepurarDirectorios() {
    }

    public void depurarDirectorio(String directorioImagenes, String app) {
        File directory = new File(directorioImagenes);
        File subdir, arch = null;
        //List ddir = new ArrayList(), dfiles = new ArrayList();

        if (directory.exists()) {
            System.out.println("Directorio: " + directory.getPath());
            String filename[] = directory.list();
            FileWriter out, fout;

            for (int i = 0; i < filename.length; i++) {
                subdir = new File(directorioImagenes + File.separator + filename[i]);
                System.out.println("Subdirectorio: " + subdir.getPath());
                if (!subdir.isFile()) {
                    String subfile[] = subdir.list();
                    System.out.println("Subdirectorio size: " + subdir.length());
                    //SI ES DIRECTORIO
                    if (subfile.length == 0) {

                        arch = new File("C:\\Kodak\\XVCS6C\\Apps\\" + app + "\\" + filename[i] + ".BTC");
                        if (!arch.exists())
                            arch = new File("C:\\Kodak\\XVCS6A\\Apps\\" + app + "\\" + filename[i] + ".BTC");

                        if (arch.exists()) {
                            if (arch.delete())
                                System.out.println("Se elimino el archivo: " + arch.getName());
                            else
                                System.out.println("No se elimino el archivo: " + arch.getName());
                        }

                        if (subdir.delete())
                            System.out.println("Se elimino el archivo: " + subdir.getName());
                        else
                            System.out.println("No se elimino el archivo: " + subdir.getName());
                        //PARA BORRAR LOS ARCHIVOS DAT DE LOS LOTES PROCESADOS
                        arch = new File(subdir.getPath() + "\\" + filename[i] + ".DAT");
                        if (arch.exists()) {
                            if (arch.delete())
                                System.out.println("Se elimino el archivo: " + arch.getName());
                        }
                    }else{
                        for (int x = 0; x < subfile.length; x++) {
                            File archivo = new File(directorioImagenes + File.separator + filename[i]+File.separator + subfile[x]);
                            System.out.println("Archivo: " + archivo.getPath() + " --->" + archivo.getName());
                        }
                    }
                }
            }
        }
    }

    //ELIMINA LOS .DAT Y .TXT
    public void depurarDirectorio(String directorioImagenes, List expedientes) {
        File directory = new File(directorioImagenes);
        File arch = null;

        if (directory.exists()) {
            FileWriter out;
            for (int i = 0; i < expedientes.size(); i++) {
                String nunicodoc = (String) expedientes.get(i);
                arch = new File(directorioImagenes + "\\" + nunicodoc + ".DAT");
                if (arch.exists()) {
                    try {
                        out = new FileWriter(arch);
                        out.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    if (!arch.delete()) {
                        System.out.println("No se elimino el archivo: " + arch.getName());
                    }
                }

                arch = new File(directorioImagenes + "\\" + nunicodoc + ".txt");
                if (arch.exists()) {
                    try {
                        out = new FileWriter(arch);
                        out.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    if (!arch.delete()) {
                        System.out.println("No se elimino el archivo: " + arch.getName());
                    }
                }
            }
        }
    }


    public void depurarDirectorioAvaluos(String directorioImagenes, String app) {
        File directory = new File(directorioImagenes);
        File subdir, subsub, arch = null;
        List ddir = new ArrayList(), dfiles = new ArrayList();

        if (directory.exists()) {
            System.out.println("Directorio: " + directory.getPath());
            String filename[] = directory.list();
            FileWriter out, fout;

            for (int i = 0; i < filename.length; i++) {
                subdir = new File(directorioImagenes + File.separator + filename[i]);
                System.out.println("Subdirectorio: " + subdir.getPath());
                if (!subdir.isFile()) {
                    String subfile[] = subdir.list();
                    //System.out.println("Subdirectorio size: " + subfile.length);
                    //SI EL DIRECTORIO
                    if (subfile.length == 0) {
                        arch = new File("C:\\Kodak\\XVCS6C\\Apps\\" + app + "\\" + filename[i] + ".BTC");
                        if (!arch.exists())
                            arch = new File("C:\\Kodak\\XVCS6A\\Apps\\" + app + "\\" + filename[i] + ".BTC");

                        if (arch.exists()) {
                            if (arch.delete()) {
                                System.out.println("Se elimino el archivo: " + arch.getName());
                            } else {
                                dfiles.add(arch.getName());
                                System.out.println("No se elimino el archivo: " + arch.getName());
                            }
                        }

                        if (subdir.delete()) {
                            System.out.println("Se elimino el archivo: " + subdir.getName());
                        } else {
                            ddir.add(subdir.getName());
                            System.out.println("No se elimino el archivo: " + subdir.getName());
                        }
                    }else{
                        for (int x = 0; x < subfile.length; x++) {
                            subsub = new File(directorioImagenes + File.separator + filename[i]+File.separator + subfile[x]);
                            String subfsubfile[] = subsub.list();
                            //System.out.println("SubSub: " + subsub);
                            if(subfsubfile.length == 0){
                                if (subsub.delete()) {
                                    System.out.println("Se elimino el archivo: " + subsub.getName());
                                } else {
                                    ddir.add(subsub.getName());
                                    System.out.println("No Se elimino el archivo: " + subsub.getName());
                                }
                            }

                        }

                        String subfileAgain[] = subdir.list();
                        System.out.println("Subdirectorio size: " + subfileAgain.length);
                        //SI EL DIRECTORIO
                        if (subfileAgain.length == 0) {
                            arch = new File("C:\\Kodak\\XVCS6C\\Apps\\" + app + "\\" + filename[i] + ".BTC");
                            if (!arch.exists())
                                arch = new File("C:\\Kodak\\XVCS6A\\Apps\\" + app + "\\" + filename[i] + ".BTC");

                            if (arch.exists()) {
                                if (!arch.delete()) {
                                    System.out.println("No se elimino el archivo: " + arch.getName());
                                } else {
                                    dfiles.add(arch.getName());
                                    System.out.println("Se elimino el archivo: " + arch.getName());
                                }
                            }
                            if (subdir.delete()) {
                                System.out.println("Se elimino el archivo: " + subdir.getName());
                            } else {
                                ddir.add(subdir.getName());
                                System.out.println("No se elimino el archivo: " + subdir.getName());
                            }
                        }
                    }


                }
            }
        }
    }


}

