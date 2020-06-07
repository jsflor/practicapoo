package persona;


/**
 * Abstract class Cliente.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Cliente extends Persona {

    private final int id;
    private static int count = 0;

    protected Cliente(String name, String fiscalId, FiscalIdType fiscalIdType) {
        super(name, fiscalId, fiscalIdType);
        id = count;
        count++;
    }

    @Override
    public int getId() {
        return id;
    }
}