package test.java;

import model.Message;
import org.apache.commons.lang3.StringUtils;
import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;
import tools.TransCoder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class ReadKeyTest {
    @Test
    public void readKeyTest() {
        // La clé cryptée donnée plus haut
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        // La clé décryptée que nous devrions obtenir
        String keyDecrypted = "CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
        // le test d'égalité entre la clé attendue et la sortie de la méthode de la librairie. Si le décryptage ne fonctionne pas nous aurons le message définit ici
        Assert.assertEquals("La librairie de décryptage est mal installée", keyDecrypted, ManaBox.decrypt(keyCrypted));

    }

    @Test
    public void lissageTest() {
        String msg = "éééçç";
        String lissage = StringUtils.stripAccents(msg);
        System.out.println(lissage);
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

    @Test
    public void testEncode() {
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        String msg = "Salut";
        TransCoder test = new TransCoder(keyCrypted);
        System.out.println(test.encode(msg));
    }

    @Test
    public void testDecode() {
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        String msg = "BYAPASBNBGAPASBGASBNASAFBHBGBNAHAJBNAZAFBLADBNAPASASAJAMAPADBNBJBJBJ";
        TransCoder test = new TransCoder(keyCrypted);
        System.out.println(test.decode(msg));
    }

    @Test
    public void msgTestClear() throws IOException {
        Path msgClearPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "clear.txt");
        Path msgEncodedPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "encoded.txt");
        Path msgKeyPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "key.txt");
        Message msgTest = new Message(false, msgClearPath, msgEncodedPath, msgKeyPath);
        msgTest.readNwrite();
    }
    @Test
    public void msgTestClea() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier a encoder");
        String msgClear = sc.nextLine();
        System.out.println("Entrez le nom du fichier contenant la clé d'encodage");
        String keyEncode = sc.nextLine();
        Path msgClearPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", msgClear);
        Path msgEncodedPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "encoded.txt");
        Path msgKeyPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", keyEncode);
        Message msgEncoded = new Message(false, msgClearPath, msgEncodedPath, msgKeyPath);
        msgEncoded.readNwrite();
    }
}

