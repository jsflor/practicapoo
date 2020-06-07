package persona;


import java.util.ArrayList;

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
    private ArrayList<Integer> pedidos;

    protected Persona(String name, String fiscalId, FiscalIdType fiscalIdType) {
        this.name = name;
        this.fiscalIdType = fiscalIdType;
        this.fiscalId = fiscalId;
    }

    public abstract void printData();

    public abstract int getId();

    public void printFiscalData(){
        switch (getFiscalIdType()){
            case DNI:
                System.out.println("DNI " + getFiscalId());
                break;
            case CIF:
                System.out.println("CIF " + getFiscalId());
                break;
        }
    }

    public void printAddress(){
        if(getAddress() != null){
            System.out.println("Calle: " + getAddress().getStreet());
            System.out.println("Ciudad: " + getAddress().getCity());
            System.out.println("Cp: " + getAddress().getZipCode());
            System.out.println("Pais: " + getAddress().getCountry());
            System.out.println("Tlf. contacto: " + getAddress().getContactPhone());
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

    public ArrayList<Integer> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Integer> pedidos) {
        this.pedidos = pedidos;
    }
}