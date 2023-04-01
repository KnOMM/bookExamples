package enumerations;

enum Apple2{
    Apple1(10),Apple2(15),Apple3(20);

    private int price;

    Apple2(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class EnumConst {
    public static void main(String[] args) {
        System.out.println(Apple2.Apple3);
        System.out.println(Apple2.Apple3.getPrice());
        System.out.println(Apple2.Apple2.ordinal());
        System.out.println(Apple2.Apple1.ordinal());
        System.out.println(Apple2.Apple1.equals(Apple2.Apple1));
        System.out.println(Apple2.Apple1.equals(Apple2.Apple2));

        System.out.println(Character.valueOf('5'));
        System.out.println(new Boolean(true));
        System.out.println(Boolean.FALSE);
        System.out.println(Boolean.valueOf("TrUe"));

        Integer iob = Integer.valueOf("100");
        Integer iob2 = Integer.valueOf("100");
        System.out.println(iob);
    }
}
