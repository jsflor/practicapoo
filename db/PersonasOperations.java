package db;

import persona.Persona;
import java.util.List;

/**
 * Write a description of interface PersonasOperations here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */

public interface PersonasOperations {

    List<Persona> getAllPersonas(String filter);
    Persona getPersonaById(String id);
    void insertOnePersona(Persona p);
    void updateOnePersona(Persona p);
    void deleteOnePersona(String id);

}
