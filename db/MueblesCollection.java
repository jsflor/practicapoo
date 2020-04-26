package db;


import mueble.Mueble;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    @Override
    public Mueble getMuebleById(String id) {
        return null;
    }

    @Override
    public void insertOneMueble(Mueble m) {

    }

    @Override
    public void updateOneMueble(Mueble m) {

    }

    @Override
    public void deleteOneMueble(String id) {

    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }
}