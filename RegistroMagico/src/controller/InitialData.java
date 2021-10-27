/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import access.EscuelaDAO;
import model.EscuelaModel;
import access.PocionDAO;
import model.PocionModel;


public class InitialData {
    private ArrayList<EscuelaModel>       escuelas       = null;
    private ArrayList<PocionModel>     pociones = null;



    /**
     * Zero-parameters constructor
     */
    public  InitialData (){
        EscuelaDAO escuelaDAO = new EscuelaDAO();
        this.escuelas = escuelaDAO.getAllEscuelas();     
        
        PocionDAO posionDAO = new PocionDAO();
        this.pociones = posionDAO.obtenerRegistros();
            
    }

    /**
     * @return the escuelas
     */
    public ArrayList<EscuelaModel> getEscuelas() {
        return escuelas;
    }

    /**
     * @param escuelas the escuelas to set
     */
    public void setEscuelas(ArrayList<EscuelaModel> escuelas) {
        this.escuelas = escuelas;
    }

    /**
     * @return the pociones
     */
    public ArrayList<PocionModel> getPociones() {
        return pociones;
    }

    /**
     * @param pociones the pociones to set
     */
    public void setPociones(ArrayList<PocionModel> pociones) {
        this.pociones = pociones;
    }







}