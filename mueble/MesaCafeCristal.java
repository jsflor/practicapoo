package mueble;


/**
 * class MesaCafeCristal.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MesaCafeCristal extends MesaCafe {
    public MesaCafeCristal(String articleName, float price) {
        super(articleName, price, Material.CRISTAL);
    }
}