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
    Persona getPersonaById(String filter, String id) throws Exception;
    List<Persona> getPersonasByType(String filter);
    void insertOnePersona(Persona p);
}
