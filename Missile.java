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
public class Missile {
    //Fields
    private int x, y, vx, vy, width, height;
    private boolean alive;
    private final int SPEED = 7;
    private final Color COLOR = Color.RED;
    private Rectangle bounds;
    
    //Constructor
    public Missile(int x, int y){
        this.x = x;
        this.y = y;
        this.vx = SPEED;
        this.vy = 0;
        this.width = 10;
        this.height = 2;
        this.alive = true;
    }
    public void die(){
        this.alive = false;
        this.vx = 0;
        this.vy = 0;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
    public void update(){
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }
    public void draw(Graphics g){
        g.setColor(COLOR);
        g.fillRect(x, y, width, height);
        
    }
}