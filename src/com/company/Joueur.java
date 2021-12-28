package com.company;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Joueur extends GameObject implements EntityA{

    private Image skieurDroite;
    private Image skieurGauche;
    private Jeu jeu;


    private Controller c;
    private float speed=0.2f;

    public Joueur(double x, double y, Jeu jeu, Controller c) throws SlickException {
        super(x, y);

        this.jeu = jeu;
        this.c = c;
        skieurDroite= new Image("res/skieurdroit.png");
        skieurGauche= new Image("res/skieurgauche.png");
    }

    public void update() {

        if(jeu.direction==1) {
            x += 1;
        }
        if(jeu.direction==2) {
            x -= 1;
        }
        for (int i = 0; i < jeu.c.size(); i++) {
            EntityC tempC = jeu.c.get(i);
            if (Collision.collision(this, tempC)) {

                c.removeEntity(tempC);

                jeu.score += 50;
            }
        }
        for (int i = 0; i < jeu.b.size(); i++) {
            EntityB tempB = jeu.b.get(i);
            if (Collision.collision(this, tempB)) {
            Jeu.state= Jeu.STATE.END;
            }
        } if (x <= 0)
            x = 0;
        if (x >= Main.longueur - 40)
            x = Main.longueur - 40;
    }


    public void render(Graphics g) {

        if(Jeu.direction==1){
            g.drawImage(skieurDroite.getScaledCopy(43, 39), (int) x, (int) y, null);



        } else if (Jeu.direction == 2) {
            g.drawImage(skieurGauche.getScaledCopy(43, 39), (int) x, (int) y, null);

        }

    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 40, 37);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
