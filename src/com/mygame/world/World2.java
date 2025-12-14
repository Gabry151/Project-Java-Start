package com.mygame.world;

import com.mygame.*;
import com.mygame.statics.*;

public class World2 extends WorldState {
    @Override
    public void handleNext(World world, Player player) {
        world.set(new World1());
        player.setLocation(new Vector2(100, 0));
        System.out.println("Game won");
    }

    @Override
    public void handlePrevious(World world, Player player) {
        world.set(new World1());
        player.setLocation(new Vector2(700, 100));
    }
}
