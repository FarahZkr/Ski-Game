package com.company;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.tests.SoundURLTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Jeu extends BasicGame {

    private Image background;
    public static int direction=1;
    private Controller controller;
    private int x,y;
    private float speed=0.2f;
    public LinkedList<EntityA> a;
    public LinkedList<EntityB> b;
    public LinkedList<EntityC> c;
    public static int score=0;
    private int arbreCount=2;
    private Image imageScore;
    private Drapeau drapeau;
    private Image replay;
    private Image gameover;
    private Arbre arbre;
    private Image play;
    private long tempsInitial;
    private Image quitButton;
    TrueTypeFont fnt1;
    java.awt.Font fnt;


    Random r = new Random();
    private int randomX;
    private int randomY;
    private Joueur joueur;
    public enum STATE {
        MENU,
        GAME,
        END
    }
    public static STATE state = STATE.MENU;

    public Jeu() {
        super("Jeu Ski");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.background= new Image("res/blanc.jpg");
        this.replay= new Image("res/replay.png");
        this.play= new Image("res/playButton.png");
        this.gameover= new Image("res/gameover.png");
        this.imageScore= new Image("res/score.png");
        this.quitButton= new Image("res/quitButton.png");
        controller= new Controller(this);
        fnt = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 25);
        fnt1 = new TrueTypeFont(fnt, true);


        for (int i = 0; i <7; i++) {
            randomX= r.nextInt(700);
            randomY= r.nextInt(550)+600;
            arbre= new Arbre(randomX,randomY,controller,this);

            controller.addEntity(arbre);

            }

        for (int i = 0; i < 6; i++) {
            randomX= r.nextInt(700);
            randomY= r.nextInt(550)+600;
            drapeau=new Drapeau(randomX,randomY,controller,this);
            controller.addEntity(drapeau);

        }
        //controller.addArbre(arbreCount);
        //arbre= new Arbre(randomX,randomY,controller,this);
        x=400-43;
                y=90;
        joueur = new Joueur(400-43, 90, this, controller);
        a = controller.getEntityA();
        b = controller.getEntityB();
        c = controller.getEntityC();

        tempsInitial = System.currentTimeMillis();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        if (state == STATE.GAME) {

            long tempsFinal = System.currentTimeMillis();
            if (tempsFinal - tempsInitial >= 10) {
                score++;
            }
            joueur.update();
            controller.update();



        }
        if (state == STATE.MENU) {
            int posX = Mouse.getX();
            int posY = Mouse.getY();

            //PLAY BUTTON
            if ((posX > 315 && posX < 484) && (posY > 382 && posY < 441)) {

                if (Mouse.isButtonDown(0)) {
                    state = STATE.GAME;
                    tempsInitial = System.currentTimeMillis();
                }
            }
            //QUIT BUTTON
            if ((posX > 320 && posX < 485) && (posY > 192 && posY < 252)) {

                if (Mouse.isButtonDown(0)) {
                    System.exit(0);
                }
            }


        }

        if (state == STATE.END) {


            b.clear();
            a.clear();
            c.clear();
            int posX = Mouse.getX();
            int posY = Mouse.getY();

            //REPLAY BUTTON
            if ((posX > 319 && posX < 492) && (posY > 382 && posY < 434)) {

                if (Mouse.isButtonDown(0)) {
                    tempsInitial = System.currentTimeMillis();
                    state = STATE.GAME;

                    score = 0;

                    joueur.setY(90);
                    joueur.setX(400-43);

                    for (int j = 0; j < 7; j++) {
                        randomX = r.nextInt(700);
                        randomY = r.nextInt(550) + 600;
                        arbre = new Arbre(randomX, randomY, controller, this);

                        controller.addEntity(arbre);

                    }

                    for (int j = 0; j < 6; j++) {
                        randomX = r.nextInt(700);
                        randomY = r.nextInt(550) + 600;
                        drapeau = new Drapeau(randomX, randomY, controller, this);
                        controller.addEntity(drapeau);

                    }

                }
            }
            //QUIT BUTTON
            if ((posX > 320 && posX < 485) && (posY > 192 && posY < 252)) {

                if (Mouse.isButtonDown(0)) {
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key){
            case Input.KEY_A:
                case Input.KEY_LEFT:
                direction=2;break;
            case Input.KEY_D:
            case Input.KEY_RIGHT:
                direction=1;break;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if(state==STATE.MENU){
            background.draw(0, 0, 800, 600);
            play.draw(300,110,190,160);
            quitButton.draw(300,300,190,160);
        }
        if(state==STATE.GAME) {

            background.draw(0, 0, 800, 600);
            controller.render(graphics);
            joueur.render(graphics);
            imageScore.draw(639,3,60,20);
            fnt1.drawString(710, -2, String.valueOf(score), Color.cyan);
        }
        if(state==STATE.END){
            background.draw(0, 0, 800, 600);
            replay.draw(315,110,190,180);
            quitButton.draw(300,300,190,160);
            gameover.draw(240,50);

        }

    }
}
