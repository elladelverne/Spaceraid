/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceraid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author 801621
 */
public class Spaceship {
    private int SPEED;
    private int x, y, vx, vy;
    private int width, height;
    private Color color;
    private Rectangle bounds;
    private boolean alive = true;
    
    public Spaceship(int cWidth, int cHeight) {
        this.SPEED = 5;
        this.x = 0;
        this.y = cHeight /2;
        this.vx = 0;
        this.vy = 0;
        this.width = 20;
        this.height = 20;
        this.color = Color.BLUE;
        this.bounds = new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }
    
     public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
     
      public void move(String direction) {        
        if (direction.equals("right"))
            vx = SPEED;
        else if (direction.equals("left"))
            vx = -SPEED;
        else if (direction.equals("up"))
            vy = -SPEED;
        else if (direction.equals("down"))
            vy = SPEED;
    }
   
      public void stop() {
        this.vx = 0;
        this.vy = 0;
    }

}
