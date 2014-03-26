package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.TiffImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class UtilTransferencia {

    /**
     * Crea un PDF a partir de un archivo .TIF
     * @throws    DocumentException
     * @throws    IOException
     */
    public static boolean createPdfFromTIF(String archivoPDF, String archivoTIF) throws IOException, DocumentException {
        boolean bandera = true;

        try {
            // step 1
            Document document = new Document(PageSize.LETTER.rotate());

            // step 2
            PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
            // step 3
            document.open();
            // step 4
            bandera = addTif(document, archivoTIF);

            // step 5
            document.close();
        } catch (Exception e) {
            bandera = false;
        } finally {
            return bandera;
        }
    }

    /**
     * Agrega un single TIF al documento
     * @param document the document to which the pages have to be added
     * @param path     El path del archivo TIFF
     * @throws DocumentException
     * @throws IOException
     */
    public static boolean addTif(Document document, String path) throws DocumentException, IOException {
        boolean bandera = true;
        try {
            RandomAccessFileOrArray ra = new RandomAccessFileOrArray(path);
            int n = TiffImage.getNumberOfPages(ra);
            Image img;
            for (int i = 1; i <= n; i++) {
                img = TiffImage.getTiffImage(ra, i);
                img.scalePercent(10);
                img.scaleToFit(720, 700);

                //img.setRotation(90);
                document.add(img);
            }
        } catch (Exception e) {
            bandera = false;
        } finally {
            return bandera;
        }
    }

    /**
     * Concatena los PDF pasados en el arreglo al archivo resultado
     * @param resultado
     * @param files
     * @throws IOException
     * @throws DocumentException
     * @throws SQLException
     */
    public static boolean concatPDFs(String resultado, String[] files) throws IOException, DocumentException, SQLException {
        boolean bandera = true;

        try {
            Document document = new Document();
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(resultado));
            document.open();
            PdfReader reader;
            int n;

            for (int i = 0; i < files.length; i++) {
                reader = new PdfReader(files[i]);
                n = reader.getNumberOfPages();
                for (int page = 0; page < n;) {
                    copy.addPage(copy.getImportedPage(reader, ++page));
                }
                copy.freeReader(reader);
            }

            document.close();
        } catch (Exception e) {
            bandera = false;
        } finally {
            return bandera;
        }
    }

    public int getCantidadPaginas(String archivo) {
        int noPaginas = 0;
        PdfReader reader = null;
        try {
            reader = new PdfReader(archivo);
            noPaginas = reader.getNumberOfPages();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return noPaginas;
    }
}

