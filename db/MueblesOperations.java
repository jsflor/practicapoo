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

    List<Mueble> getAllMuebles(String filter);
    Mueble getMuebleById(String id);
    void insertOneMueble(Mueble m);
    void updateOneMueble(Mueble m);
    void deleteOneMueble(String id);

}
