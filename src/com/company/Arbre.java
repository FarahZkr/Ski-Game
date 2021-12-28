package com.company;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

public class Arbre extends GameObject implements EntityB{
    private Jeu jeu;
    private Controller c;
    private Image arbre;
    Random r = new Random();




    public Arbre(double x, double y, Controller c, Jeu jeu) throws SlickException

    {
        super(x,y);
        this.c=c;
        this.jeu=jeu;

        arbre= new Image("res/arbre.png");
    }

    public void update() {
        y -= 1; //speed of arbre
        if (y < -97) {
            int randomY= r.nextInt(550)+600;
            y =  randomY;
           int randomX= r.nextInt(700);

            x = randomX;

        }


    }


    public void render(Graphics g) {
    arbre.draw((int)x,(int)y, 95,97);
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 90, 95);
    }


}
