/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class IngredienteModel {
    //ATRIBUTOS
    private int ingrediCodigo;
    private String ingrediNombre;
    private int ingrediPeso;
    private float ingrediReaccion;
    private byte ingrediExiste;
    
    //CONSTRUCTOR
    public IngredienteModel(int ingrediCodigo, String ingrediNombre, int ingrediPeso, float ingrediReaccion, byte ingrediExiste){
        this.ingrediCodigo = ingrediCodigo;
        this.ingrediNombre = ingrediNombre;
        this.ingrediPeso = ingrediPeso;
        this.ingrediReaccion = ingrediReaccion;
        this.ingrediExiste = ingrediExiste;
    }
    
}
