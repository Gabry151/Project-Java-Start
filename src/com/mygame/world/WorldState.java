package com.mygame.world;

import com.mygame.*;

public abstract class WorldState {
    public abstract void handleNext(World world, Player player);
    public abstract void handlePrevious(World world, Player player);
}
