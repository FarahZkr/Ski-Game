package com.company;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

public class Drapeau extends GameObject implements EntityC  {

    private Image drapeau;
    private Jeu jeu;
    private Controller c;
    Random r = new Random();

    public Drapeau(double x, double y, Controller c, Jeu jeu) throws SlickException {
        super(x, y);
        this.c = c;
        this.jeu = jeu;
        drapeau= new Image("res/drapeau.png");
    }
    public void update() {

        y -= 1; //speed of arbre
        if (y < -32) {
            int randomY= r.nextInt(550)+600;
            y =  randomY;
            int randomX= r.nextInt(700);

            x = randomX;

        }
    }


    public void render(Graphics g) {
drapeau.draw((int) x, (int) y,19,32);
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 18, 32);
    }
}
