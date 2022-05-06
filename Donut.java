package Project6;

public class Donut {

    //instance variables
    private Size size;
    private Flavor flavor;
    private Icing icing;
    private Topping topping;

    public Donut(){
        this.size = Size.REGULAR;
        this.flavor = Flavor.OLD_FASHIONED;
        this.icing = Icing.NONE;
        this.topping = Topping.NONE;
    }

    public Donut (Size size) {
        this.size = size;
        this.flavor = Flavor.OLD_FASHIONED;
        this.icing = Icing.NONE;
        this.topping = Topping.NONE;
    }

    public void setSize (Size size) {
        this.size = size;
    }

    public void setFlavor (Flavor flavor){
        this.flavor = flavor;
    }

    public void setIcing (Icing icing){
        this.icing = icing;
    }

    public void setTopping (Topping topping){
        this.topping = topping;
    }

    public Size getSize(){
        return size;
    }

    public Flavor getFlavor(){
        return flavor;
    }

    public Icing getIcing(){
        return icing;
    }

    public Topping getTopping(){
        return topping;
    }

    public String toString(){
        return String.format("\n\t"+this.size+"\n\t"+this.flavor+"\n\t"+this.icing+"\n\t"+this.topping+"\n\t");
    }
}
