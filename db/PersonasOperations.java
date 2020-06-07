package db;

import persona.Persona;
import java.util.List;

/**
 * Interface PersonasOperations with Personas operations.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public interface PersonasOperations {

    /**
     * @param filter CLIENTE or EMPLEADO
     * @param id of Persona
     * @return Persona found
     * @throws Exception Persona not found
     */
    Persona getPersonaById(String filter, String id) throws Exception;

    /**
     * @param filter CLIENTE or EMPLEADO
     * @return Personas found
     */
    List<Persona> getPersonasByType(String filter);

    /**
     * @param p Persona to insert in DB
     */
    void insertOnePersona(Persona p);
}
