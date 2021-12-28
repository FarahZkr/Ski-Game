package com.company;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<EntityA> a = new LinkedList<EntityA>();
    private LinkedList<EntityB> b = new LinkedList<EntityB>();
    private LinkedList<EntityC> c = new LinkedList<EntityC>();

    EntityA entA;
    EntityB entB;
    EntityC entC;


    private Jeu jeu;

    Random r = new Random();
    public Controller(Jeu jeu) throws SlickException {
        this.jeu=jeu;


    }

    public void update() throws SlickException {
        //Pour ENTITY A
        for (int i = 0; i < a.size(); i++) {
            entA = a.get(i);
            entA.update();
        }
        //POUR ENTITY B
        for (int i = 0; i < b.size(); i++) {
            entB = b.get(i);
            entB.update();
        }
        //Pour ENTITY C
        for (int i = 0; i < c.size(); i++) {
            entC=c.get(i);
            entC.update();
        }
    }
    public void render(Graphics g) {
        //Pour A
        for (int i = 0; i < a.size(); i++) {
            entA = a.get(i);
            entA.render(g);
        }
        //POUR B
        for (int i = 0; i < b.size(); i++) {
            entB = b.get(i);
            entB.render(g);
        }
        //Pour C
        for (int i = 0; i < c.size(); i++) {
            entC=c.get(i);
            entC.render(g);
        }
    }
    public void addEntity(EntityA block){
        a.add(block);
    }
    public void removeEntity(EntityA block){
        a.remove(block);
    }
    public void addEntity(EntityB block){
        b.add(block);
    }
    public void removeEntity(EntityB block){
        b.remove(block);
    }
    public void addEntity(EntityC block){
        c.add(block);
    }
    public void removeEntity(EntityC block){
        c.remove(block);
    }

    public LinkedList<EntityA> getEntityA(){
        return a;
    }
    public LinkedList<EntityB> getEntityB(){
        return b;
    }
    public LinkedList<EntityC> getEntityC(){
        return c;
    }
}
