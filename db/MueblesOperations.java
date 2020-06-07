package db;

import mueble.Mueble;
import java.util.List;

/**
 * Interface MueblesOperations with Muebles operations.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */

public interface MueblesOperations {

    /**
     * @param filter MESA or SILLA
     * @param id of Mueble
     * @return Mueble found
     * @throws Exception Mueble not found
     */
    Mueble getMuebleById(String filter, String id) throws Exception;

    /**
     * @param filter type of Mueble
     * @return Muebles found
     */
    List<Mueble> getMueblesByType(String filter);

    /**
     * @param m Mueble to insert in DB
     */
    void insertOneMueble(Mueble m);
}
