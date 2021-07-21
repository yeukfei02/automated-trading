public class Main {
    public static void main(String[] args) {
       try {
           Trading trading = new Trading();
           trading.run();
       } catch (Exception e) {
           System.out.println("error = " + e.getMessage());
       }
    }
}
