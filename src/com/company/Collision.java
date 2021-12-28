package com.company;

public class Collision {


    public static boolean collision(EntityA entA,EntityB entB){
        if(entA.getBounds()==null){
            return false;
        }


        if(entA.getBounds().intersects(entB.getBounds())){
            return true;


        }


        return false;
    }
    public static boolean collision(EntityB entB, EntityA entA){


        if(entB.getBounds()==null){
            return false;
        }

        if(entB.getBounds().intersects(entA.getBounds())){
            return true;
        }


        return false;
    }
    public static boolean collision(EntityA entA, EntityC entC){


        if(entA.getBounds()==null){
            return false;
        }

        if(entA.getBounds().intersects(entC.getBounds())){
            return true;
        }

        return false;
    }

}
