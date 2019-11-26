package main.java;



public class Test {
    public static void main(String[] args) {

        
        char[][] message=Cipher.encodeMessage("texttexttexttexttexttexttext");
        System.out.println("zaszyfrowana wiadomość");
        for (char[] cs : message) {
            for (char cr : cs) {
                System.out.println(Integer.toHexString((int)cr));
            }
            
        }
        message=Cipher.decodeMessage(message);
        System.out.println("odszyfrowana");
        for (char[] cs : message) {
            for (char cr : cs) {
                System.out.println(Integer.toHexString((int)cr));
            }
            
        }

    }
}