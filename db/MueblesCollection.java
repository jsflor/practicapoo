package db;


import mueble.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a description of class MueblesCollection here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MueblesCollection implements MueblesOperations{

    private List<Mueble> muebles;

    public MueblesCollection() {
        muebles = new ArrayList<>();
    }

    @Override
    public List<Mueble> getAllMuebles(String filter) {
        return getMueblesByType(filter);
    }

    @Override
    public List<Mueble> getMuebleById(String filter, String id) {
       List<Mueble> mueblesFiltered = getMueblesByType(filter);
        List<Mueble> result = new ArrayList<>();
       for (Mueble m: mueblesFiltered){
            if(id.equals(Integer.toString(m.getId()))){
                result.add(m);
            }
       }
       return result;
    }

    @Override
    public List<Mueble> getMueblesByType(String filter) {
        List<Mueble> result;
        switch (filter){
            case "MESACAFECRISTAL":
                result = getMuebles().stream()
                        .filter(m -> m instanceof MesaCafeCristal)
                        .collect(Collectors.toList());
                break;
            case "MESACAFEMADERA":
                result = getMuebles().stream()
                        .filter(m -> m instanceof MesaCafeMadera)
                        .collect(Collectors.toList());
                break;
            case "MESADORMITORIO":
                result = getMuebles().stream()
                        .filter(m -> m instanceof MesaDormitorio)
                        .collect(Collectors.toList());
                break;
            case "MESACOMEDOR":
                result = getMuebles().stream()
                        .filter(m -> m instanceof MesaComedor)
                        .collect(Collectors.toList());
                break;
            case "SILLAPLEGABLE":
                result = getMuebles().stream()
                        .filter(m -> m instanceof SillaPlegable)
                        .collect(Collectors.toList());
                break;
            case "SILLACOCINA":
                result = getMuebles().stream()
                        .filter(m -> m instanceof SillaCocina)
                        .collect(Collectors.toList());
                break;
            case "SILLAOFICINARUEDAS":
                result = getMuebles().stream()
                        .filter(m -> m instanceof SillaOficinaRuedas)
                        .collect(Collectors.toList());
                break;
            case "SILLAOFICINASINRUEDAS":
                result = getMuebles().stream()
                        .filter(m -> m instanceof SillaOficinaSinRuedas)
                        .collect(Collectors.toList());
                break;
            default:
                result = getMuebles();
        }
        return result;
    }

    @Override
    public void insertOneMueble(Mueble m) {
        getMuebles().add(m);
        System.out.println("Añadido nuevo mueble con id: " + m.getId());
    }

    @Override
    public void updateOneMueble(Mueble m) {
        getMuebles().removeIf(mu -> mu.getId() == m.getId());
        getMuebles().add(m);
        System.out.println("Actualizado mueble con id: " + m.getId());
    }

    @Override
    public void deleteOneMueble(String id) {
        getMuebles().removeIf(m -> id.equals(Integer.toString(m.getId())));
        System.out.println("Borrado mueble con id: " + id);
    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }
}