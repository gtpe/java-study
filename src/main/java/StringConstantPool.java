public class StringConstantPool {

    public static void main(String[] args) {
        String a = new String("Hello");
        String b = new String("Hello");
        System.out.println(a == b); // false

        String c = "Hello";
        String d = "Hello";
        System.out.println(c == d); // true
    }

}
