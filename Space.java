/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceraid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 801621
 */
public class Space extends JPanel{
    private ArrayList<Missile>missiles = new ArrayList();
    private ArrayList<Asteroid> asteroids = new ArrayList<>(); 
    private ArrayList<AlienCraft> aliencrafts = new ArrayList<>();
    private ArrayList<Threat> threats = new ArrayList<>();
    private Spaceship spaceship;
    Timer timer;

    public Space(){
        super();
        spaceship = new Spaceship(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/30);
        for (int i = 0; i < 10; i++) {
            int y = (int) (Math.random() * 600);
            AlienCraft aliencraft = new AlienCraft(y);
            threats.add(aliencraft);
            aliencrafts.add(aliencraft);
        }  
        for (int i = 0; i < 10; i++) {
            int y = (int) (Math.random() * 600);
            Asteroid asteroid = new Asteroid(y);
            threats.add(asteroid);
            asteroids.add(asteroid);
        }
        
    }    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        for (Threat threat : threats) {
            if(threat.isAlive()){
                threat.draw(g);
            }  
            else{
                threat.die();
            }
        }
        spaceship.draw(g);
        for (Missile missile : missiles){
            if(missile.isAlive()) missile.draw(g);
        }  
    }    
    
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            for(Missile missile: missiles){
                missile.update();
            }
            for (Threat threat : threats) {
                threat.update();  
            }
            spaceship.update();
            repaint();
            missileVsEnemy();
        }
    }

     private void missileVsEnemy(){
        for(Missile missile: missiles){
            for (Threat threat : threats) { 
                if(missile.getBounds().intersects(threat.getBounds())){
                threat.die();
                missile.die(); 
                }
            }
        }
     }
    
public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            spaceship.move("right");
            System.out.println("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            spaceship.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
           spaceship.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           spaceship.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            spaceship.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            spaceship.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            spaceship.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            spaceship.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Missile temp = new Missile(spaceship.getX(),spaceship.getY());
            missiles.add(temp);
        }
            
    }
    
}
