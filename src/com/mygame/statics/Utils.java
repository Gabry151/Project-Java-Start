package com.mygame.statics;


import java.awt.Rectangle;

public class Utils {
    public static double DistanceBetween(Rectangle r1, Rectangle r2) {
        // Calcola la distanza sull'asse X
        double dx = Math.max(r1.getX() - (r2.getX() + r2.getWidth()),
                r2.getX() - (r1.getX() + r1.getWidth()));
        // Calcola la distanza sull'asse Y
        double dy = Math.max(r1.getY() - (r2.getY() + r2.getHeight()),
                r2.getY() - (r1.getY() + r1.getHeight()));

        // Se si sovrappongono su un asse, la distanza lungo quell'asse è 0
        dx = Math.max(0, dx);
        dy = Math.max(0, dy);

        // Distanza euclidea
        return Math.sqrt(dx * dx + dy * dy);
    }
}
