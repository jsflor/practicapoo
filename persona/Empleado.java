package persona;


/**
 * Write a description of class Empleado here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Empleado extends Persona {

    private final int id;
    private static int count = 0;

    protected Empleado(String name, String fiscalId) {
        super(name, fiscalId, FiscalIdType.DNI);
        id = count;
        count++;
    }

    @Override
    public void printData() {
        System.out.println("Empleado");
        System.out.println("Nombre :" + getName());
        System.out.println("Id empleado : " + getId());
        printFiscalData();
        printAddress();
    }

    @Override
    public int getId() {
        return id;
    }
}