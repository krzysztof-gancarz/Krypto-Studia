package main.java;



public class Test {
    public static void main(String[] args) {
        String klucz = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String message = "text";
        byte[] hash = Transformation.toByteArray(Cipher.encodeMessage(message.getBytes(), klucz));
        for (int i=0; i<hash.length; i++) {
            System.out.println(hash[i]);
        }
        byte[] dehash = Transformation.toByteArray(Cipher.decodeMessage(hash, klucz));
        String message2 = new String(dehash);
        System.out.println(message2);
    }
}