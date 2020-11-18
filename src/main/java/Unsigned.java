public class Unsigned {

    public static void main(String[] args) {

        int unsignedInt = Integer.parseUnsignedInt("4294967295");
        // System.out.println(unsignedInt);
        System.out.println("# unsignedInt: " + Integer.toUnsignedString(unsignedInt));

        long unsignedLong = Long.parseUnsignedLong("18446744073709551615");
        // System.out.println(unsignedLong);
        System.out.println("# unsignedLong: " + Long.toUnsignedString(unsignedLong));

    }

}
