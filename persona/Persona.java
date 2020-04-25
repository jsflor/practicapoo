package persona;


/**
 * Write a description of class Persona here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Persona {

    private String name;
    private String fiscalId;
    private FiscalIdType fiscalIdType;
    private Address address;

    protected Persona(String name, String fiscalId, FiscalIdType fiscalIdType) {
        this.name = name;
        this.fiscalIdType = fiscalIdType;
        this.fiscalId = fiscalId;
    }

    public abstract void printData();

    public void printFiscalData(){
        switch (fiscalIdType){
            case DNI:
                System.out.println("DNI " + getFiscalId());
            case CIF:
                System.out.println("cif " + getFiscalId());
        }
    }

    public void printAddress(){
        if(address != null){
            System.out.println("Calle: " + address.getStreet());
            System.out.println("Ciudad: " + address.getCity());
            System.out.println("Cp: " + address.getZipCode());
            System.out.println("Pais: " + address.getCountry());
            System.out.println("Tlf. contacto: " + address.getContactPhone());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiscalId() {
        return fiscalId;
    }

    public void setFiscalId(String fiscalId) {
        this.fiscalId = fiscalId;
    }

    public FiscalIdType getFiscalIdType() {
        return fiscalIdType;
    }

    public void setFiscalIdType(FiscalIdType fiscalIdType) {
        this.fiscalIdType = fiscalIdType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}