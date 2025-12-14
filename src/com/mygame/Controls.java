package com.mygame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
    private boolean upPressed, downPressed, leftPressed, rightPressed;
    private Player player;

    public boolean GetUpPressed() { return upPressed; }
    public void SetUpPressed(boolean value) { upPressed = value; }
    public boolean GetDownPressed() { return downPressed; }
    public boolean GetLeftPressed() { return leftPressed; }
    public boolean GetRightPressed() { return rightPressed; }

    public Controls(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) upPressed = true;
        if (code == KeyEvent.VK_S) downPressed = true;
        if (code == KeyEvent.VK_A) leftPressed = true;
        if (code == KeyEvent.VK_D) rightPressed = true;

        if (code == KeyEvent.VK_SPACE) player.jump();
    }

    @Override public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) upPressed = false;
        if (code == KeyEvent.VK_S) downPressed = false;
        if (code == KeyEvent.VK_A) leftPressed = false;
        if (code == KeyEvent.VK_D) rightPressed = false;
    }

    @Override public void keyTyped(KeyEvent e) {}
}
