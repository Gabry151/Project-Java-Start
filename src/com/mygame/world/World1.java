package com.mygame.world;

import com.mygame.*;
import com.mygame.statics.*;

public class World1 extends WorldState{
    @Override
    public void handleNext(World world, Player player) {
        world.set(new World2());
        player.setLocation(new Vector2(50, 100));
    }

    @Override
    public void handlePrevious(World world, Player player) {
        System.out.println("ERROR: no previous world.");
    }
}
