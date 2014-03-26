package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
    private ArrayList datos = new ArrayList();
    private String[] columnas;
    private Class[] tipos;


    //Constructor
    public ModeloTabla(String[] columnas) {
        this.setColumnas(columnas);
    }


    //Regresa el nombre de una columna
    public String getColumnName(int columna) {
        return columnas[columna].toString();
    }


    //Regresa el numero de filas en la tabla
    public int getRowCount() {
        return getDatos().size();
    }


    //Regresa el numero de columnas
    public int getColumnCount() {
        return getColumnas().length;
    }


    //Regresa el valor de una celda
    public Object getValueAt(int idxFila, int idxColumna) {
        Object[] fila = (Object[]) datos.get(idxFila);
        return fila[idxColumna];
    }


    //Actualiza el valor de una celda
    public void setValueAt(Object valor, int idxFila, int idxColumna) {
        Object[] fila = (Object[])datos.get(idxFila);
        fila[idxColumna] = valor;
        fireTableCellUpdated(idxFila, idxColumna);
    }


    //Regresa el tipo de dato de una columna
    public Class getColumnClass(int idxColumna) {
        return tipos[idxColumna];
    }


    //Agrega una fila a la tabla
    public void agregarFila(Object[] fila) {
        datos.add(fila);
        fireTableDataChanged();
    }


    //Elimina una fila de la tabla
    public void EliminarFila(int idxFila) {
        datos.remove(idxFila);
        fireTableDataChanged();
    }


    //Regresa el encabezado de las tablas
    public String[] getColumnas() {
        return columnas;
    }


    //Asigna el encabezado de las columnas
    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }


    //Regresa los datos de la tabla
    public ArrayList getDatos() {
        return datos;
    }


    //Asigna los datos de la tabla
    public void setDatos(ArrayList datos) {
        this.datos = datos;
    }


    //Regresa los tipos de datos de la tabla
    public Class[] getTipos() {
        return tipos;
    }


    //Asigna los tipos de datos de la tabla
    public void setTipos(Class[] tipos) {
        this.tipos = tipos;
    }
}
