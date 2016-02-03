
import java.util.Random;

public class Cypher {
    public static String generate(long length){
        return Cypher.generate(length,System.currentTimeMillis());
    }
    public static String generate(long length,long seed){
        String cypher = "";
        Random random = new Random(seed);
        for(int i=0;i<length;i++){
            cypher += (char)(random.nextInt(94)+32);
        }
        return cypher;
    }
}
