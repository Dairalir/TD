package model;


import tools.TransCoder;

import java.util.Scanner;

public class Message {
    public boolean encoded() {
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        Scanner sc = new Scanner(System.in);
        TransCoder tc = new TransCoder(keyCrypted);
        System.out.println("Entrez votre message");
        String msg = sc.nextLine();

        Boolean b1 = true;
        Boolean b2 = false;
        if(tc.decode(msg) == ){
            b2 = true;
            if(b1.equals(b2)){
                System.out.println("Le message est encoder");
            }
        }else{
            System.out.println("Le message n'est pas encoder");
        }
    }
}

