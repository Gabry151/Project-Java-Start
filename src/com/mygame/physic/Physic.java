package com.mygame.physic;


import java.awt.Rectangle;

import com.mygame.statics.*;
import com.mygame.world.*;

public class Physic {
    private World world;
    private float gravity;

    public Physic(World world, float gravity){
        this.world = world;
        this.gravity = gravity;
    }
    
    public void applyPhysic(IPhysicianObject obj){
        applyGravity(obj);
        applyVelocity(obj);
        applyFriction(obj);
    }


    public void setForce(IPhysicianObject obj, float DirX, float DirY, float force){
        obj.setVelocity(DirX * force, DirY * force);
    }

    public void addForce(IPhysicianObject obj, float DirX, float DirY, float force){
        Vector2 temp = Vector2.Add(obj.getVelocity(), new Vector2(DirX * force, DirY * force));
        obj.setVelocity(temp.x, temp.y);
    }

    
    private void applyGravity(IPhysicianObject obj) {
        Vector2 vel = obj.getVelocity();
        vel.y += gravity; // aggiungi accelerazione
        obj.setVelocity(vel.x, vel.y);
    }

    private void applyVelocity(IPhysicianObject obj){
        Vector2 vel = obj.getVelocity();
        Rectangle objRect = new Rectangle(obj.getRect());

        Rectangle nextXRect = new Rectangle((int)(objRect.x + vel.x), objRect.y, objRect.width, objRect.height);
        Rectangle nextYRect = new Rectangle(objRect.x, (int)(objRect.y + vel.y), objRect.width, objRect.height);

        boolean collisionX = isColliding(nextXRect);
        boolean collisionY = isColliding(nextYRect);

        if (collisionX) { vel.x = 0; } else { objRect.x += vel.x; }
        if (collisionY) { vel.y = 0; } else { objRect.y += vel.y; }

        obj.setLocation(objRect.x, objRect.y);
        obj.setVelocity(vel.x, vel.y);
    }

    private void applyFriction(IPhysicianObject obj) {
        Vector2 vel = obj.getVelocity();

        if (vel.x > 0)
            addForce(obj, -vel.x, 0, 1f);
        if (vel.x < 0)
            addForce(obj, -vel.x, 0, 1f);
    }

    private boolean isColliding(Rectangle rectangle){
        for (Rectangle wall : world.getWalls()) {
            if (rectangle.intersects(wall)) {
                return true;
            }
        }
        return false;
    }
}
