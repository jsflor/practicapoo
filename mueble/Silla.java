package mueble;


/**
 * Write a description of class Silla here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Silla extends Mueble{

    protected Silla(String articleName, int price, Material material) {
        super(articleName, price, material);
    }
}
