package persona;


/**
 * Class Empresa.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Empresa extends Cliente {

    public Empresa(String name, String fiscalId) {
        super(name, fiscalId, FiscalIdType.CIF);
    }

    @Override
    public void printData() {
        System.out.println("Cliente Empresa");
        System.out.println("Nombre empresa:" + getName());
        System.out.println("Id cliente : " + getId());
        printFiscalData();
        printOrders();
        printAddress();
    }
}