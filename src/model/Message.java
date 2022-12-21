package model;


import java.util.Scanner;

public class Message {
    public boolean encoded() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre message");
        String msg = sc.nextLine();

        Boolean b1 = true;
        Boolean b2 = false;
        if(msg.){
            b2 = true;
            if(b1.equals(b2)){
                System.out.println("Le message est encoder");
            }
        }else{
            System.out.println("Le message n'est pas encoder");
        }
    }
}

