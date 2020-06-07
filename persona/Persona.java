package persona;


import java.util.ArrayList;

/**
 * Abstract class Persona.
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

    /**
     * @param name of Persona
     * @param fiscalId of Persona
     * @param fiscalIdType of Personas's fiscalId
     */
    protected Persona(String name, String fiscalId, FiscalIdType fiscalIdType) {
        this.name = name;
        this.fiscalIdType = fiscalIdType;
        this.fiscalId = fiscalId;
        this.pedidos = new ArrayList<>();
    }

    /**
     * print Persona details
     */
    public abstract void printData();

    /**
     * @return id
     */
    public abstract int getId();

    /**
     * print fiscal data details
     */
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

    /**
     * print address data details
     */
    public void printAddress(){
        if(getAddress() != null){
            System.out.println("Calle: " + getAddress().getStreet());
            System.out.println("Ciudad: " + getAddress().getCity());
            System.out.println("Cp: " + getAddress().getZipCode());
            System.out.println("Pais: " + getAddress().getCountry());
            System.out.println("Tlf. contacto: " + getAddress().getContactPhone());
        }
    }

    /**
     * print orders
     */
    public void printOrders(){
        if(getPedidos() != null && getPedidos().size() > 0){
            System.out.println("#" + getPedidos().size() + " Pedidos: ");
            for(int i = 0; i < getPedidos().size(); i++){
                System.out.println("Id: " + getPedidos().get(i));
            }
        }
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return fiscalId
     */
    public String getFiscalId() {
        return fiscalId;
    }

    /**
     * @param fiscalId to set
     */
    public void setFiscalId(String fiscalId) {
        this.fiscalId = fiscalId;
    }

    /**
     * @return fiscalId type
     */
    public FiscalIdType getFiscalIdType() {
        return fiscalIdType;
    }

    /**
     * @param fiscalIdType to set
     */
    public void setFiscalIdType(FiscalIdType fiscalIdType) {
        this.fiscalIdType = fiscalIdType;
    }

    /**
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return pedidos
     */
    public ArrayList<Integer> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos to set
     */
    public void setPedidos(ArrayList<Integer> pedidos) {
        this.pedidos = pedidos;
    }
}