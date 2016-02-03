
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by postmordum on 6/29/15.
 */
public class Cesar {
    String encrypt(String cypher,String text){
        //String text = body;
        int kp = 0;
        String encrypt = "";
        for(int i=0;i<text.length();i++){
            if(kp >= cypher.length()){
                kp = 0;
            }
            char t = text.charAt(i);
            char c = cypher.charAt(kp++);
            char e = this.shiftForward(c,t);
            //System.out.println(t+":"+c+":"+e);
            encrypt += e;
        }
        return encrypt;
    }
    String decrypt(String cypher,String text){
        int kp = 0;
        String decrypt = "";
        for(int i=0;i<text.length();i++){
            if(kp >= cypher.length()){
                kp = 0;
            }
            char t = text.charAt(i);
            char c = cypher.charAt(kp++);
            char d = this.shiftBackword(c,t);
            //System.out.println(t+":"+c+":"+d);
            decrypt += d;
        }
        return decrypt;
    }
    private char shiftForward(char shift,char ltr){
        int shifted = ltr;
        if(ltr>31&&ltr<127){
            shifted = (ltr + shift);
            while(shifted > 126){
                int gap = shifted - 126;
                shifted = gap + 31;
            }
        }
        return (char)shifted;
    }
    private char shiftBackword(char shift,char ltr){
        int shifted = ltr;
        if(ltr>31&&ltr<127){
            shifted = (ltr - shift);
            while(shifted < 32){
                int gap = 32 - shifted;
                shifted = 127 - gap;
            }
        }
        return (char)shifted;
    }
}

