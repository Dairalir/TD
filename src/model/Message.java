package model;


import tools.TransCoder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Message {
    private Boolean encoded;
    private List<String> msgClear;
    private List<String> msgEncoded;
    private Path msgClearPath;
    private Path msgEncodedPath;
    private Path keyPath;
    private String key;
    private TransCoder transCoder;

    public Message(Boolean encoded, Path msgClearPath,Path msgEncodedPath,Path keyPath) {
        this.encoded = encoded;
        this.msgClearPath = msgClearPath;
        this.msgEncodedPath = msgEncodedPath;
        this.keyPath = keyPath;
        msgClear = new ArrayList<>();
        msgEncoded = new ArrayList<>();
        this.key = this.generateKey();
        this.transCoder = new TransCoder(key);

    }
    private void readNwrite() {
        if (encoded) {
            for (String ligne : msgEncoded) {
                String ligneDecoded = transCoder.decode(ligne);
                System.out.println(ligneDecoded);
            }
            System.out.println("Le message décodé se trouve: " + msgClearPath.toString());
        } else {
            for (String ligne : msgClear) {
                String ligneEncoded = transCoder.encode(ligne);
            }
            System.out.println("Le message encodé se trouve: " + msgEncodedPath.toString());
        }
    }


    private String generateKey() {
        return "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
    }
}

