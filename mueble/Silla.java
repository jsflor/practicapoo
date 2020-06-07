package mueble;


/**
 * Class Silla.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Silla extends Mueble{

    private final int id;
    private static int count = 0;

    protected Silla(String articleName, float price, Material material) {
        super(articleName, price, material);
        id = count;
        count++;
    }

    @Override
    public void printData() {
        System.out.println("Silla");
        System.out.println("Id : " + getId());
        printFeatures();
    }

    @Override
    public int getId() {
        return id;
    }
}
