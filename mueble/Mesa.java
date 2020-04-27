package mueble;


/**
 * Write a description of class Mesa here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Mesa extends Mueble{

    private final int id;
    private static int count = 0;

    protected Mesa(String articleName, int price, Material material) {
        super(articleName, price, material);
        id = count;
        count++;
    }

    @Override
    public void printData() {
        System.out.println("Mesa");
        System.out.println("Id : " + getId());
        printFeatures();
    }

    @Override
    public int getId() {
        return id;
    }
}
