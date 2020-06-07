package db;

import pedido.Pedido;

/**
 * Interface PedidosOperations with Pedidos operations.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public interface PedidosOperations {

    /**
     * @param id of Pedido
     * @return Pedido found
     * @throws Exception Pedido not found
     */
    Pedido getPedidoById(String id) throws Exception;

    /**
     * @param p Pedido to insert in DB
     */
    void insertOnePedido(Pedido p);

}
