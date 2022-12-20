package tools;

import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TransCoder {
    private Map<Character,String> encode = new HashMap<Character,String>();
    private Map<String,Character> decode = new HashMap<String,Character>();

    public TransCoder(String keyCrypted) {
        String key = ManaBox.decrypt(keyCrypted);

        }

    public Map<Character, String> getEncode() {

        return encode;
    }
    public Map<String, Character> getDecode() {

        return decode;
    }
    
    public String encode(String msg){

        return msg;
    }

    public String decode(String msg){

        return msg;
    }

    @Test
    public void createMapTest() {
        String testGermain = "6lUjKOzUj4e/Gelw9c6sDLqHniwulClN6XSayZ+HRF/kbZx+CMf95jxrhm4YFSY26OnxVlsrzGkO00IMeAFs3g==";
        TransCoder transcodeTest = new TransCoder(testGermain);
        Assert.assertNotNull(transcodeTest.getEncode());
        System.out.println(transcodeTest.getEncode().toString());
        Assert.assertNotNull(transcodeTest.getDecode());
        System.out.println(transcodeTest.getDecode().toString());
    }
}
