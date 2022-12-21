package tools;

import org.germain.tool.ManaBox;
import java.util.HashMap;
import java.util.Map;

public class TransCoder {
    private Map<Character,String> encode = new HashMap<Character,String>();
    private Map<String,Character> decode = new HashMap<String,Character>();



    public TransCoder(String keyCrypted) {
        String key = ManaBox.decrypt(keyCrypted);

        for (int i = 0; i < key.length(); i++){
            encode.put(key.charAt(i),getLetterCode(i+26));
            decode.put(getLetterCode(i+26),key.charAt(i));
        }
    }
    public static String getLetterCode(int i) {
        return i < 0 ? "" : getLetterCode((i / 26) - 1) + (char)(65 + i % 26);
    }

    public Map<Character, String> getEncode() {
        return encode;
    }
    public Map<String, Character> getDecode() {
        return decode;
    }
    
    public String encode(String msg){
        String buffer = "";
        for(char ch: msg.toCharArray()){
            buffer += encode.get(ch);
        }
        return buffer;
    }

    public String decode(String msg){
        String buffer = "";
        for (char ch: msg.toCharArray()){
            buffer += decode.get(ch);
        }
        return buffer;
    }

}
