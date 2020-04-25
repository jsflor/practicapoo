package db;


import mueble.*;
import persona.*;

import java.util.ArrayList;

/**
 * Write a description of class Database here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Database {

    private ArrayList<Mueble> muebles;
    private ArrayList<Persona> personas;

    public Database() {}

    public ArrayList<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(ArrayList<Mueble> muebles) {
        this.muebles = muebles;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}