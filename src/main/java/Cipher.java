package main.java;
public class Cipher {
    public static char[][] encodeMessage(String text)
    {
        char[][] message = Transformation.splitMessage(text);
        int[][] key = KeyGen.generate();
        
        //runda inicjujaca
        for(int i=0;i<message.length;i++) {
            for(int j=0;j<4;j++) {
                message[i][j] = (char)((int)message[i][j] ^ key[i%4][j]);
            }
        }
        
        
        
        //rundy szyfrujace
        for(int iteration=1;iteration<10;iteration++) {
            for(int i=0;i<message.length;i++) {
                for(int j=0;j<4;j++) {
                    message[i][j] = Transformation.change(message[i][j]);
                }
            }
            
            
            message = Transformation.shiftRowLeft(message);
            for (char[] cs : message) {
                for (char cr : cs) {
                    System.out.println(Integer.toHexString((int)cr));
                }
                
            }
            for(int i=0;i<message.length;i++) Transformation.mixColumns(message[i]);
            
            for(int i=0;i<message.length;i++) {
                for(int j=0;j<4;j++) {
                    message[i][j] = (char)((int)message[i][j] ^ key[i%4+iteration*4][j]);
                }
            }

        }
        //runda kończąca
        for(int i=0;i<message.length;i++) {
            for(int j=0;j<4;j++) {
                message[i][j] = Transformation.change(message[i][j]);
            }
        }
        message = Transformation.shiftRowLeft(message);
        for(int i=0;i<message.length;i++) {
            for(int j=0;j<4;j++) {
                message[i][j] = (char)((int)message[i][j] ^ key[i%4+10*4][j]);
            }
        }
        return message;
    }
}