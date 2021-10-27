/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class EscuelaModel {
    //ATIRUBUTOS
    private int escCodigo;
    private String escNombre;
    private String escHabilidad;
    private int escAniosServicio;
    private String escCreador;
    private Date escFechaFundacion;  
    
    //CONSTRUCTOR

    
    public EscuelaModel(int escCodigo, String escNombre){ //Construtor para llenar el Combobox
        this.escCodigo = escCodigo;
        this.escNombre = escNombre;
    }
    

    /**
     * @return the escCodigo
     */
    public int getEscCodigo() {
        return escCodigo;
    }

    /**
     * @return the escNombre
     */
    public String getEscNombre() {
        return escNombre;
    }

    /**
     * @return the escHabilidad
     */
    public String getEscHabilidad() {
        return escHabilidad;
    }

    /**
     * @return the escAniosservicio
     */
    public int getEscAniosservicio() {
        return escAniosServicio;
    }

    /**
     * @return the escCreador
     */
    public String getEscCreador() {
        return escCreador;
    }

    /**
     * @return the escFechafundacion
     */
    public Date getEscFechafundacion() {
        return escFechaFundacion;
    }
    
    @Override
    public String toString(){
        return this.escNombre;
    }
      
}
