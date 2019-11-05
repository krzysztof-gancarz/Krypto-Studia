package main.java;



public class Test {
    public static void main(String[] args) {

        
        char[][] message=Cipher.encodeMessage("pyrpyrpyrpyrpyrpyrpyrpyrp");
        System.out.println("zaszyfrowana wiadomość");
        for (char[] cs : message) {
            for (char cr : cs) {
                System.out.println(Integer.toHexString((int)cr));
            }
            
        }

    }
}