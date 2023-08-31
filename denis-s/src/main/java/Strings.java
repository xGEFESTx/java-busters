public class Strings {

    public static String stringy(int size) {
        // Your code here
        String s = "";
        for (int i = 1; i <= size; i++) {
            if (i % 2 != 0){
                s = s + "1";
            } else {
                s = s + "0";
            }
        }
        return  s;
    }

    public static void main(String[] args) {

        System.out.println(stringy(5));


    }
}
