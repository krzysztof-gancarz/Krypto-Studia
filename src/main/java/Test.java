package main.java;



public class Test {
    public static void main(String[] args) {

        
        String klucz = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String message = "tekst";
        byte[] hash = Transformation.toByteArray(Cipher.encodeMessage(message.getBytes(), klucz));
        byte[] dehash = Transformation.toByteArray(Cipher.decodeMessage(hash, klucz));
        String message2 = new String(dehash);
        System.out.println(message2);
        

        
    }
}