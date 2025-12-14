package com.mygame;


import javax.swing.*;
import java.awt.*;

import com.mygame.world.*;
import com.mygame.physic.*;

public class Game extends JPanel implements Runnable {
    private Thread thread;
    private boolean isExecuting = false;

    private World world;
    private Physic physic;
    private Player player;


    public Game() {
        setFocusable(true);

        world = new World(new World1());
        physic = new Physic(world, 1f);
        player = new Player(world, physic);

        addKeyListener(player.getControls());
    }

    public void init(){
        requestFocusInWindow();
    }

    public void start() {
        isExecuting = true;
        thread = new Thread(this);
        thread.start();
    }

    private void resetGame(){
        world.set(new World1());
        player.setLocation(100, 0);
    }


    @Override
    public void run() {
        while (isExecuting) {
            update();
            physic.applyPhysic(player);
            repaint();
            try {
                Thread.sleep(16); // circa 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        //move
        player.move();

        if (player.isTouchingDeadZones()) resetGame();

        if (player.isTouchingBackZones()) {
            world.PreviousWorld(player);
        }

        if (player.isTouchingGoalZones()){
            world.NextWorld(player);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rectangle wall : world.getWalls()) {
            g.setColor(Color.BLACK);
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }

        for (Rectangle deadZone : world.getDeadZones()) {
            g.setColor(Color.RED);
            g.fillRect(deadZone.x, deadZone.y, deadZone.width, deadZone.height);
        }

        for (Rectangle backZone : world.getBackZones()) {
            g.setColor(Color.YELLOW);
            g.fillRect(backZone.x, backZone.y, backZone.width, backZone.height);
        }

        for (Rectangle goalZone : world.getGoalZones()){
            g.setColor(Color.GREEN);
            g.fillRect(goalZone.x, goalZone.y, goalZone.width, goalZone.height);
        }

        g.setColor(Color.BLACK);
        g.drawString("Made by Gabry151", 675, 540);

        // paint player
        g.setColor(Color.BLUE);
        Rectangle playerRect = player.getPlayerRect();
        g.fillRect(playerRect.x, playerRect.y, playerRect.width, playerRect.height);
    }
}
