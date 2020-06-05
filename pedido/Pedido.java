package pedido;


import mueble.Mueble;

import java.util.ArrayList;

/**
 * Write a description of class Pedido here.
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
    private OrderState estadoPedido;
    private ArrayList<String> incidencias;
    private static int count = 0;

    public Pedido(ArrayList<Mueble> muebles, int customerId, int responsibleId, float price) {
        this.muebles = muebles;
        this.customerId = customerId;
        this.responsibleId = responsibleId;
        this.price = price;
        this.estadoPedido = OrderState.PENDIENTE;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Mueble> getMuebles() {
        return muebles;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public ArrayList<String> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<String> incidencias) {
        this.incidencias = incidencias;
    }

    public OrderState getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(OrderState estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}