package main.java;
public class Cpiher {
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
        for(int iteration=1;iteration<10;i++) {
            for(int i=0;i<message.length;i++) {
                for(int j=0;j<4;j++) {
                    message[i][j] = Transformation.change(message[i][j]);
                }
            }
            for(int i=0;i<message.length/4;i++) {
                message[1+i] = Transformation.shiftLeft(message[1+i]);
                message[2+i] = Transformation.shiftLeft(message[2+i]);
                message[2+i] = Transformation.shiftLeft(message[2+i]);
                message[3+i] = Transformation.shiftLeft(message[3+i]);
                message[3+i] = Transformation.shiftLeft(message[3+i]);
                message[3+i] = Transformation.shiftLeft(message[3+i]);
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
        for(int i=0;i<message.length/4;i++) {
            message[1+i] = Transformation.shiftLeft(message[1+i]);
            message[2+i] = Transformation.shiftLeft(message[2+i]);
            message[2+i] = Transformation.shiftLeft(message[2+i]);
            message[3+i] = Transformation.shiftLeft(message[3+i]);
            message[3+i] = Transformation.shiftLeft(message[3+i]);
            message[3+i] = Transformation.shiftLeft(message[3+i]);
        }
        for(int i=0;i<message.length;i++) Transformation.mixColumns(message[i]);
        for(int i=0;i<message.length;i++) {
            for(int j=0;j<4;j++) {
                message[i][j] = (char)((int)message[i][j] ^ key[i%4+iteration*4][j]);
            }
        }
        return message;
    }
}