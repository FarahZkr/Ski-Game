package com.company;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public interface EntityC {
    public void update();
    public void render(Graphics g);

    public Rectangle getBounds();

}
