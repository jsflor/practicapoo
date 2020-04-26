package db;


import persona.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class PersonasCollection here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class PersonasCollection implements PersonasOperations{

    private List<Persona> personas;

    public PersonasCollection() {
        personas = new ArrayList<>();
    }

    @Override
    public List<Persona> getAllPersonas(String filter) {
        return null;
    }

    @Override
    public Persona getPersonaById(String id) {
        return null;
    }

    @Override
    public void insertOnePersona(Persona p) {

    }

    @Override
    public void updateOnePersona(Persona p) {

    }

    @Override
    public void deleteOnePersona(String id) {

    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}