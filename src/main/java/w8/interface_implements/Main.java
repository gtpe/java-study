package w8.interface_implements;

public class Main {

    /*public static void wash(Washable washable) {
        washable.wash();
    }*/

    public static void wash(Object object) {
        if(object instanceof Washable) {
            ((Washable)object).wash();
        } else {
            System.out.println("Can't wash this.");
        }
    }

    public static void main(String[] args) {
        wash(new Cup());
        wash(new CoffeeCup());
        wash(new Dog());
        wash(new Fish());
    }

}
