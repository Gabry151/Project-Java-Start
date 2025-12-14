package com.mygame.statics;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) { this.x = x; this.y = y; }

    public static Vector2 Add(Vector2 a, Vector2 b){
        Vector2 temp = new Vector2(a.x + b.x, a.y + b.y);
        return temp;
    }

    public static float Distance(Vector2 a, Vector2 b){
        float tempX = (a.x - b.x) * (a.x - b.x);
        float tempY = (a.y - b.y) * (a.y - b.y);
        float temp = (float)Math.sqrt(tempX + tempY);
        return temp;
    }

    public static Vector2 zero() { return new Vector2(0, 0); }
}
