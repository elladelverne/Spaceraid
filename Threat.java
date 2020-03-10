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
public abstract class Threat {
    private int speed;
    private int x, y, vx, vy;
    private int width, height;
    private Color color;
    private Rectangle bounds;
    private boolean alive = true;
    
    public Threat(int speed, int x, int y, int width, int height, Color color) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.vx = (int) -(this.speed);
        this.vy = 0;
        this.width = width;
        this.height = height;
        this.color = color;
        this.bounds = new Rectangle(x, y, width, height);
    }

      public void die(){
        this.alive = false;
        this.vx = 0;
        this.vy = 0;
        this.x = 800;
        this.y = 0;
    }
    
    public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }

    public abstract void draw(Graphics g);

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    
    
}
