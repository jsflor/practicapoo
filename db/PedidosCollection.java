package db;

import pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class PedidosCollection here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class PedidosCollection implements PedidosOperations {

    private List<Pedido> pedidos;

    public PedidosCollection() {
        pedidos = new ArrayList<>();
    }

    @Override
    public List<Pedido> getAllPedidos(String filter) {
        return null;
    }

    @Override
    public Pedido getPedidoById(String id) {
        return null;
    }

    @Override
    public void insertOnePedido(Pedido p) {

    }

    @Override
    public void updateOnePedido(Pedido p) {

    }

    @Override
    public void deleteOnePedido(String id) {

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
