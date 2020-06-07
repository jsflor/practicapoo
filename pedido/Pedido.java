package pedido;


import mueble.Mueble;

import java.util.ArrayList;

/**
 * Class Pedido for save new muebles orders.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Pedido {

    private final int id;
    private float price;
    private final ArrayList<Mueble> muebles;
    private int customerId;
    private int responsibleId;
    private static int count = 0;

    /**
     * @param muebles List of Muebles
     * @param customerId Cliente id
     * @param responsibleId Empleado id
     * @param price total price
     */
    public Pedido(ArrayList<Mueble> muebles, int customerId, int responsibleId, float price) {
        this.muebles = muebles;
        this.customerId = customerId;
        this.responsibleId = responsibleId;
        this.price = price;
        this.id = count;
        count++;
    }

    /**
     * print Pedido details
     */
    public void printPedido(){
        System.out.println("Pedido");
        System.out.println("Id: " + getId());
        System.out.println("Id Cliente: " + getCustomerId());
        System.out.println("Id Empleado: " + getResponsibleId());
        System.out.println("Precio total: " + getPrice());
        System.out.println("#" + getMuebles().size() + " Muebles: ");
        for (Mueble m: getMuebles()){
            m.printData();
        }
    }

    /**
     * @return order id
     */
    public int getId() {
        return id;
    }

    /**
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return muebles of Pedido
     */
    public ArrayList<Mueble> getMuebles() {
        return muebles;
    }

    /**
     * @return Cliente id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return Empleado id
     */
    public int getResponsibleId() {
        return responsibleId;
    }

    /**
     * @param responsibleId to set
     */
    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }
}