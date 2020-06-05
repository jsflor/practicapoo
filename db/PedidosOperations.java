package db;

import pedido.Pedido;

/**
 * Write a description of interface PedidosOperations here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */

public interface PedidosOperations {
    Pedido getPedidoById(String id) throws Exception;
    void insertOnePedido(Pedido p);

}
