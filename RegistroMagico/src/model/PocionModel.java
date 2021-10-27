/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class PocionModel {
    //ATRIBUTOS
    private int pocCodigo;
    private String pocNombre;
    private float pocLitros;
    private int pocVecesUsada;
    private int escCodigoFK;
    private String escNombre;
    
    //CONSTRUCTOR
          
    public PocionModel(int pocCodigo, String pocNombre, float pocLitros, int pocVecesUsada, String escNombre){ // Seleccionar (SELECT) para mostrar en tabla a usuario
        this.pocCodigo = pocCodigo;
        this.pocNombre = pocNombre;
        this.pocLitros = pocLitros;
        this.pocVecesUsada = pocVecesUsada;
        this.escNombre = escNombre;
    }
    
    public PocionModel(float pocLitros, int pocVecesUsada, int pocCodigo){ // Para modificar valores en bd (UPDATE)
        
        this.pocLitros = pocLitros;
        this.pocVecesUsada = pocVecesUsada;
        this.pocCodigo = pocCodigo;
    }


    /**
     * @return the pocCodigo
     */
    public int getPocCodigo() {
        return pocCodigo;
    }

    /**
     * @param pocCodigo the pocCodigo to set
     */
    public void setPocCodigo(int pocCodigo) {
        this.pocCodigo = pocCodigo;
    }

    /**
     * @return the pocNombre
     */
    public String getPocNombre() {
        return pocNombre;
    }

    /**
     * @param pocNombre the pocNombre to set
     */
    public void setPocNombre(String pocNombre) {
        this.pocNombre = pocNombre;
    }

    /**
     * @return the pocLitros
     */
    public float getPocLitros() {
        return pocLitros;
    }

    /**
     * @param pocLitros the pocLitros to set
     */
    public void setPocLitros(float pocLitros) {
        this.pocLitros = pocLitros;
    }

    /**
     * @return the pocVecesUsada
     */
    public int getPocVecesUsada() {
        return pocVecesUsada;
    }

    /**
     * @param pocVecesUsada the pocVecesUsada to set
     */
    public void setPocVecesUsada(int pocVecesUsada) {
        this.pocVecesUsada = pocVecesUsada;
    }

    /**
     * @return the escCodigoFK
     */
    public int getEscCodigoFK() {
        return escCodigoFK;
    }

    /**
     * @param escCodigoFK the escCodigoFK to set
     */
    public void setEscCodigoFK(int escCodigoFK) {
        this.escCodigoFK = escCodigoFK;
    }

    /**
     * @return the escNombre
     */
    public String getEscNombre() {
        return escNombre;
    }

    /**
     * @param escNombre the escNombre to set
     */
    public void setEscNombre(String escNombre) {
        this.escNombre = escNombre;
    }

    public Object[] toArray(){
        Object[] data = {pocCodigo, pocNombre, pocLitros, pocVecesUsada, escNombre};
        return data;
    }
    
    @Override
    public String toString(){
        return Integer.toString(pocCodigo);
    }
    
}
