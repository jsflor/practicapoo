package db;


import mueble.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class MueblesCollection with implementation of Muebles operations.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MueblesCollection implements MueblesOperations{

    private List<Mueble> muebles;

    /**
     * class constructor
     */
    public MueblesCollection() {
        muebles = new ArrayList<>();
    }

    @Override
    public Mueble getMuebleById(String filter, String id) throws Exception {
       List<Mueble> mueblesFiltered = getMueblesByType(filter);
        List<Mueble> result = new ArrayList<>();

       for (Mueble m: mueblesFiltered){
            if(id.equals(Integer.toString(m.getId()))){
                result.add(m);
            }
       }
       if(result.size() > 0){
           return result.get(0);
       } else {
           throw new Exception("No se han encontrado resultados");
       }
    }

    @Override
    public List<Mueble> getMueblesByType(String filter) {
        List<Mueble> result;
        switch (filter){
            case "MESA":
                result = getMuebles().stream()
                        .filter(m -> m instanceof MesaCafeCristal || m instanceof MesaCafeMadera
                            || m instanceof MesaDormitorio || m instanceof MesaComedor)
                        .collect(Collectors.toList());
                break;
            case "SILLA":
                result = getMuebles().stream()
                        .filter(m -> m instanceof SillaPlegable || m instanceof SillaCocina
                                || m instanceof SillaOficinaRuedas || m instanceof SillaOficinaSinRuedas)
                        .collect(Collectors.toList());
                break;
            default:
                result = new ArrayList<>();
        }
        return result;
    }

    @Override
    public void insertOneMueble(Mueble m) {
        getMuebles().add(m);
        System.out.println("Añadido nuevo mueble con id: " + m.getId());
    }

    /**
     * @return muebles
     */
    public List<Mueble> getMuebles() {
        return muebles;
    }

    /**
     * @param muebles to set
     */
    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }
}