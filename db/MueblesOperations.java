package db;

import mueble.Mueble;
import java.util.List;

/**
 * Write a description of interface MueblesOperations here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */

public interface MueblesOperations {
    Mueble getMuebleById(String filter, String id) throws Exception;
    List<Mueble> getMueblesByType(String filter);
    void insertOneMueble(Mueble m);
}
