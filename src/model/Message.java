package model;
import tools.TransCoder;
import java.io.IOException;
import java.nio.file.Files;
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
        System.out.println(this.key);
        this.transCoder = new TransCoder(key);
    }
    public void readNwrite() {
        if (encoded) {
            this.msgEncoded = this.lireFichier(msgEncodedPath);
            System.out.println(msgEncoded.toString());
            this.msgClear = this.decode(this.msgEncoded);
            this.ecrireDansFichier(msgClearPath, msgClear);
        } else {
            this.msgClear = this.lireFichier(msgClearPath);
            this.msgEncoded = this.encode(this.msgClear);
            this.ecrireDansFichier(msgEncodedPath, msgEncoded);
        }
    }

    private List<String> lireFichier(Path path) {

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> decode(List<String> lignes) {
        for (String ligne : lignes) {
            this.msgClear.add(this.transCoder.decode(ligne));
        }
        return msgClear;
    }

    private List<String> encode(List<String> lignes) {
        for (String ligne : lignes) {
            this.msgEncoded.add(this.transCoder.encode(ligne));
        }
        return msgEncoded;
    }

    private void ecrireDansFichier(Path path, List<String> lignes) {
        try {
            Files.write(path,lignes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateKey() {
        try {
            return Files.readString(keyPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
