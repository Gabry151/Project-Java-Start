package com.mygame;


import java.awt.Rectangle;

import com.mygame.physic.*;
import com.mygame.world.*;
import com.mygame.statics.Vector2;

public class Player implements IPhysicianObject{
    private Rectangle playerRect;
    private int width = 50, height = 50;
    private int x = 100, y = 0, speed = 5;
    public float jumpForce = 20;
    public Vector2 velocity = new Vector2(0, 0);

    private Controls controls;
    private World world;
    private Physic physic;

    public Controls getControls() { return controls; }

    public Rectangle getPlayerRect() { return playerRect; }
    public void setPlayerRect(Rectangle rectangle) { this.playerRect = new Rectangle(rectangle); }

    //physic implementation
    public Vector2 getVelocity() { return velocity; }
    public void setVelocity(float velX, float velY) { velocity = new Vector2(velX, velY); }
    public Rectangle getRect() { return playerRect; }
    public void setLocation(int x, int y) { playerRect.setLocation(x, y); }
    public void setLocation(Vector2 pos) { playerRect.setLocation((int) pos.x, (int) pos.y); }


    public Player(World world, Physic physic){
        controls = new Controls(this);
        playerRect = new Rectangle(x, y, width, height);

        this.world = world;
        this.physic = physic;
    }

    public void move(){
        if (controls.GetLeftPressed()) physic.addForce(this, -1, 0, speed);
        if (controls.GetRightPressed()) physic.addForce(this, 1, 0, speed);
    }

    public void jump(){
        if (velocity.y != 0) return;
        physic.setForce(this, 0, -1, jumpForce);
    }

    public boolean isTouchingDeadZones(){
        for (Rectangle deadZone : world.getDeadZones()) {
            if (playerRect.intersects(deadZone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTouchingBackZones() {
        for (Rectangle backZone : world.getBackZones()) {
            if (playerRect.intersects(backZone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTouchingGoalZones(){
        for (Rectangle goalZone : world.getGoalZones()) {
            if (playerRect.intersects(goalZone)) {
                return true;
            }
        }
        return false;
    }
}
