package tools;

import org.apache.commons.lang3.StringUtils;
import org.germain.tool.ManaBox;
import java.util.HashMap;
import java.util.Map;

public class TransCoder {
    private Map<Character,String> encode = new HashMap<Character,String>();
    private Map<String,Character> decode = new HashMap<String,Character>();


    public TransCoder(String keyCrypted) {
        String key = ManaBox.decrypt(keyCrypted);
//On parcours la clé decripter comme un tableau et on assigne
//aux 2 tableaux associatif les valeur de la clé à chaque code de lettres correspondante.
        for (int i = 0; i < key.length(); i++){
            encode.put(key.charAt(i),getLetterCode(i+26));
            decode.put(getLetterCode(i+26),key.charAt(i));
        }
    }
    //Fonction pour récuperé le code des caractère selon leurs position dans la table ASCII
    //On se limite aux 25 lettres de l'alphabet en maj donc 0 = A et donc 26 = AA.
    public static String getLetterCode(int i) {
        return i < 0 ? "" : getLetterCode((i / 26) - 1) + (char)(65 + i % 26);
    }

    public Map<Character, String> getEncode() {
        return encode;
    }
    public Map<String, Character> getDecode() {
        return decode;
    }

    //on récupère le message non encoder, on le parcours et on ajoute le code correspondant a chaque caractere
    //que l'ont vient ajouter a la variable buffer qui devient le msg encoder.
    public String encode(String msg){
        String lissage =  StringUtils.stripAccents(msg);
        String buffer = "";
        for(char ch: lissage.toCharArray()){
            buffer += encode.get(ch);
        }
        return buffer;
    }
    //meme chose mais a l'inverse on récupère un message coder.
    //on veut les valeur 2 par 2 donc dans la boucle for au lieu de i++ on fait i = i+2
    //on utilise substring pour prendre les caractere pour les 2 premiers (0,2) le 2 indique l'arret mais ne l'inclus pas

    public String decode(String msg){
        String buffer = "";
        for(int i = 0; i < msg.length(); i = i+2){
            String code = msg.substring(i,i+2);
            buffer += decode.get(code);
        }
        return buffer;
    }
}
