package db;


import persona.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return getPersonasByType(filter);
    }

    @Override
    public List<Persona> getPersonaById(String filter, String id) {
        List<Persona> personasFiltered = getPersonasByType(filter);
        List<Persona> result = new ArrayList<>();
        for (Persona p: personasFiltered){
            if(id.equals(Integer.toString(p.getId()))){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Persona> getPersonasByType(String filter) {
        List<Persona> result;
        switch (filter){
            case "CLIENTE":
                result = getPersonas().stream()
                        .filter(m -> m instanceof Jefe || m instanceof  Comercial
                        || m instanceof ArtesanoHora || m instanceof ArtesanoPlantilla)
                        .collect(Collectors.toList());
                break;
            case "EMPLEADO":
                result = getPersonas().stream()
                        .filter(m -> m instanceof Particular || m instanceof Empresa)
                        .collect(Collectors.toList());
                break;
            default:
                result = new ArrayList<>();
        }
        return result;
    }

    @Override
    public void insertOnePersona(Persona p) {
        getPersonas().add(p);
        System.out.println("Añadida nueva persona con id: " + p.getId());
    }

    @Override
    public void updateOnePersona(Persona p) {
        getPersonas().removeIf(pe -> pe.getId() == p.getId());
        getPersonas().add(p);
        System.out.println("Actualizada persona con id: " + p.getId());
    }

    @Override
    public void deleteOnePersona(String id) {
        getPersonas().removeIf(p -> id.equals(Integer.toString(p.getId())));
        System.out.println("Borrada persona con id: " + id);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}