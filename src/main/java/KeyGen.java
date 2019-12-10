package main.java;

public class KeyGen {
    /*private static byte testkey[][] = {
        {0x2B, 0x7E, 0x15, 0x16},
        {0x28, 0xAE, 0xD2, 0xA6},
        {0xAB, 0xF7, 0x15, 0x88},
        {0x09, 0xCF, 0x4F, 0x3C}
    };*/
    public static int[][] generate(String keyString) {
        int[][] key = Transformation.toHexKeyInt(keyString); 
        int w[] = key[3].clone();
        for(int i=0;i<10;i++) {
            w = Transformation.shiftLeft(w);
            w = Transformation.changeArr(w);
            w[0] = Transformation.rcon(w[0], i);
            for(int j=0;j<4;j++)
            {
            w = Transformation.xorArr(key[key.length-4], w);
            key = Transformation.extendKey(key, w);
            }
            
        }
        
        return key;
    }

    public static byte[][] generatebyte(String keyString) {
        byte[][] key = Transformation.toHexKey(keyString); 
        byte w[] = key[3].clone();
        for(int i=0;i<10;i++) {
            w = Transformation.shiftLeft(w);
            w = Transformation.changeArr(w);
            w[0] = Transformation.rcon(w[0], i);
            for(int j=0;j<4;j++)
            {
            w = Transformation.xorArr(key[key.length-4], w);
            key = Transformation.extendKey(key, w);
            }
            
        }
        
        return key;
    }
}