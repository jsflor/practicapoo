package mueble;


/**
 * Write a description of class Mueble here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Mueble{

    private final Material material;
    private String modelName;
    private float price;
    private boolean order;
    private int orderId;

    protected Mueble(String modelName, float price, Material material) {
        this.modelName = modelName;
        this.price = price;
        this.material = material;
        this.order = false;
    }

    public abstract void printData();

    public abstract int getId();

    public void printFeatures(){
        System.out.println("Modelo : " + getModelName());
        System.out.println("Precio : " + getPrice());
        printMaterial();
        if(belongsToOrder()){
            System.out.println("Orden id : " + getOrderId());
        }
    }

    public void printMaterial(){
        switch (material){
            case CRISTAL:
                System.out.println("Material: Cristal");
                break;
            case MADERA:
                System.out.println("Material: Madera");
            case PLASTICO:
                System.out.println("Material: Plastico");
                break;
            case METAL:
                System.out.println("Material: Metal");
                break;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean belongsToOrder() {
        return order;
    }

    public void setBelongsToOrder(boolean order) {
        this.order = order;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Material getMaterial() {
        return material;
    }
}
