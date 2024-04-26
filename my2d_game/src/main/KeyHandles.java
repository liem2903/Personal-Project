package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandles implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, pressed;
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            pressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
            pressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            pressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            pressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
            pressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            pressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            pressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
