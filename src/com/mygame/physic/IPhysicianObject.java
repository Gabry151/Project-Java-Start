package com.mygame.physic;

import java.awt.Rectangle;

import com.mygame.statics.Vector2;

public interface IPhysicianObject {
    public Vector2 getVelocity();
    public void setVelocity(float velX, float velY);

    public Rectangle getRect();
    public void setLocation(int x, int y);
}
