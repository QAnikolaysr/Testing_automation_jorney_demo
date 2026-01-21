public class FirstTest {
    public static void main(String[] args) {
        String name = "Vladislav";
        String name2 = "Vladislav";
        String name5 = "Hallo";
        String name3 = new String("Vladislav" );
        String name33 = name5 + " , " + name2;

        System.out.println(name == name2);
        System.out.println(name3 == name2);
        System.out.println(name3.equals(name2));
        System.out.println(name.equals(name2));
        System.out.println(name33);

    }



}
