package w8.interface_implements;

public class Dog extends Animal implements Washable {

    @Override
    public void wash() {
        System.out.println("Washing a Dog.");
    }

}
