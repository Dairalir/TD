package GUI;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import model.Message;

public class GUI {
    public static void init(){
        Scanner sc = new Scanner(System.in);
        String ret;
        boolean encore = true;
        do {
            System.out.println("==============================================");
            System.out.println("|| System d'encodage et de décodage de message ||");
            System.out.println("|| 1: Décoder un message                       ||");
            System.out.println("|| 2: Encoder un message                       ||");
            System.out.println("|| 3: quitter                                  ||");
            System.out.println("==============================================");

            ret = sc.nextLine();

            switch (ret) {
                case "1":
                    System.out.println("Entrez le nom du fichier a décoder");
                    String msgEncoder = sc.nextLine();
                    System.out.println("Entrez le nom du fichier contenant la clé de décodage");
                    String keyDecode = sc.nextLine();
                    Path msgClearPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "clear.txt");
                    Path msgEncodedPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", msgEncoder+".txt");
                    Path msgKeyPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", keyDecode+".txt");
                    Message msgDecoded = new Message(true, msgClearPath, msgEncodedPath, msgKeyPath);
                    msgDecoded.readNwrite();
                    System.out.println("le message encoder se trouve dans le fichier /home/stagiaire/IdeaProjects/TD/src/input/encoded.txt");
                    break;
                case "2":
                    System.out.println("Entrez le nom du fichier a encoder");
                    String msgClear = sc.nextLine();
                    System.out.println("Entrez le nom du fichier contenant la clé d'encodage");
                    String keyEncode = sc.nextLine();
                    msgClearPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", msgClear+".txt");
                    msgEncodedPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", "encoded.txt");
                    msgKeyPath = Paths.get("/home/stagiaire/IdeaProjects/TD/src/input", keyEncode+".txt");
                    Message msg = new Message(false, msgClearPath, msgEncodedPath, msgKeyPath);
                    msg.readNwrite();
                    System.out.println("le message décoder se trouve dans le fichier /home/stagiaire/IdeaProjects/TD/src/input/clear.txt");
                    break;
                case "3":
                    System.out.println("===========================================");
                    System.out.println("|            Merci et à bientôt           |");
                    System.out.println("===========================================");
                    encore= false;
                    break;
                default:
                    System.out.println("entrez un fichier existant");
                    break;
            }
        } while (encore);
    }

}
