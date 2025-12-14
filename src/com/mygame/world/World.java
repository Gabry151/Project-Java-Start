package com.mygame.world;


import java.awt.Rectangle;
import java.util.ArrayList;

import com.mygame.*;

public class World {
    private WorldState world;
    private ArrayList<Rectangle> walls = new ArrayList<>();
    private ArrayList<Rectangle> deadZones = new ArrayList<>();
    private ArrayList<Rectangle> backZones = new ArrayList<>();
    private ArrayList<Rectangle> goalZones = new ArrayList<>();

    public ArrayList<Rectangle> getWalls() { return walls; }
    public ArrayList<Rectangle> getDeadZones() { return deadZones; }
    public ArrayList<Rectangle> getBackZones() { return backZones; }
    public ArrayList<Rectangle> getGoalZones() { return goalZones; }
    
    
    public World(WorldState world){ set(world); }

    public WorldState getWorld() { return world; };

    public void set(WorldState world){
        this.world = world;

        if (world instanceof World1){
            world1();
        }
        if (world instanceof World2){
            world2();
        }
    }

    public void NextWorld(Player player) {
        world.handleNext(this, player);
    }

    public void PreviousWorld(Player player) {
        world.handlePrevious(this, player);
    }

    private void world1(){
        Reset();

        // wall 1
        walls.add(new Rectangle(0, 0, 12, 800));
        walls.add(new Rectangle(775, 150, 50, 450));
        walls.add(new Rectangle(0, 0, 100, 25));
        walls.add(new Rectangle(150, 0, 650, 25));

        // platform 1
        walls.add(new Rectangle(12, 500, 212, 50));

        // platform 2
        walls.add(new Rectangle(350, 325, 100, 50));

        // platform 3
        walls.add(new Rectangle(550, 150, 250, 50));

        // Bottom deadzone
        deadZones.add(new Rectangle(-400, 550, 1600, 50));
        
        // goal zone
        goalZones.add(new Rectangle(775, 25, 50, 125));
    }

    private void world2(){
        Reset();

        //walls
        walls.add(new Rectangle(0, 150, 12, 450));
        walls.add(new Rectangle(775, 0, 50, 150));
        walls.add(new Rectangle(0, 0, 800, 25));
        
        //platforms
        walls.add(new Rectangle(0, 150, 325, 50));
        walls.add(new Rectangle(375, 150, 425, 50));

        walls.add(new Rectangle(0, 350, 475, 50));
        walls.add(new Rectangle(575, 350, 225, 50));

        // Bottom deadzone
        deadZones.add(new Rectangle(-400, 550, 1600, 50));

        backZones.add(new Rectangle(0, 25, 12, 125));

        // goal zone
        goalZones.add(new Rectangle(775, 200, 50, 150));
    }

    private void Reset(){
        walls.clear();
        deadZones.clear();
        backZones.clear();
        goalZones.clear();
    }
}
