public class Unicode {

    public static void main(String[] args) {
        // \u0000 ~ \uFFFF
        char a = (char)Integer.parseInt("0048", 16);
        System.out.println(a);

        char b = '\u0048';
        System.out.println(b);

        // HELLO
        System.out.println("\u0048\u0045\u004C\u004C\u004F");
    }

}
