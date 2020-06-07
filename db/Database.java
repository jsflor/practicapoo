package db;

/**
 * Class Database is a wrapper for all db actions.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Database {

    private MueblesCollection muebles;
    private PersonasCollection personas;
    private PedidosCollection pedidos;

    /**
     * class constructor
     */
    public Database() {
        muebles = new MueblesCollection();
        personas = new PersonasCollection();
        pedidos = new PedidosCollection();
    }

    /**
     * @return muebles
     */
    public MueblesCollection getMuebles() {
        return muebles;
    }

    /**
     * @param muebles to set
     */
    public void setMuebles(MueblesCollection muebles) {
        this.muebles = muebles;
    }

    /**
     * @return personas
     */
    public PersonasCollection getPersonas() {
        return personas;
    }

    /**
     * @param personas to set
     */
    public void setPersonas(PersonasCollection personas) {
        this.personas = personas;
    }

    /**
     * @return pedidos
     */
    public PedidosCollection getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos to set
     */
    public void setPedidos(PedidosCollection pedidos) {
        this.pedidos = pedidos;
    }
}