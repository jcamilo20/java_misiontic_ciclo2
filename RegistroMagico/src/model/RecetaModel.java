/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class RecetaModel {
    //ATRIBUTOS
    private int recId;
    private int pocCodigoFK;
    private int ingrediCodigoFK;
    private String recFecha; // ***confirmar si es string para fecha d/m/anio** + tiempo
    
    //CONSTRUCTOR
    public RecetaModel(int recId, int pocCodigoFK, int ingrediCodigoFK, String recFecha){
        this.recId = recId;
        this.pocCodigoFK = pocCodigoFK;
        this.ingrediCodigoFK = ingrediCodigoFK;
        this.recFecha = recFecha;
    }
   
}
