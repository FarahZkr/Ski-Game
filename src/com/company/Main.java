package com.company;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static int longueur=800,hauteur=600;
    public static void main(String[] args) {

        try{
            AppGameContainer app = new AppGameContainer(new Jeu());
            app.setDisplayMode(longueur, hauteur,false);
            app.setShowFPS(false);
            app.setVSync(true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
