package main.java;
public class KeyGen {
    private int key[][] = {
        {0xF2, 0x25, 0xE9, 0x5C},
        {0x70, 0xFF, 0xAE, 0x78},
        {0x12, 0x7F, 0xB6, 0xA5},
        {0x48, 0xB7, 0x4C, 0xDD}
    };

    public void generate() {
        
        int w[] = key[3];
        for(int i=1;i<=10;i++) {
            w = Transformation.shiftLeft(w);
            w = Transformation.changeArr(w);
            w[0] = Transformation.rcon(w[0], i);
            for(int j=0; j<4;j++) {
                w = Transformation.xorArr(key[key.length-4], w);
                key = Transformation.extendKey(key, w);
            }
            
        }
        

    }
}