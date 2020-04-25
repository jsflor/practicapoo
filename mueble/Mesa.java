package mueble;


/**
 * Write a description of class Mesa here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Mesa extends Mueble{

    protected Mesa(String articleName, int price, Material material) {
        super(articleName, price, material);
    }
}
