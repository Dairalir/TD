package model;


import tools.TransCoder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Message {
    private Boolean encoded;
    private List<String> msgClear;
    private List<String> msgEncode;
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
        msgEncode = new ArrayList<>();
        this.key = this.generateKey();
        this.transCoder = new TransCoder(key);

    }
    private String generateKey() {
        return "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
    }
}

