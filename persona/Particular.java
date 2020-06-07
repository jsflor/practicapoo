package persona;


/**
 * Class Particular.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Particular extends Cliente {

    public Particular(String name, String fiscalId) {
        super(name, fiscalId, FiscalIdType.DNI);
    }

    @Override
    public void printData() {
        System.out.println("Cliente Particular");
        System.out.println("Nombre cliente:" + getName());
        System.out.println("Id cliente : " + getId());
        printFiscalData();
        printOrders();
        printAddress();
    }
}