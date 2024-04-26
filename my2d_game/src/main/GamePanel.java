package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    // FPS
    int FPS = 60;

    KeyHandles keyH = new KeyHandles();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);  // For better rendering.
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game Loop of the game.
        double drawInterval = 1000000000/FPS; // How much you draw per second.
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        if (keyH.isDownPressed() == true) {
            playerY+= playerSpeed;
        }
        else if (keyH.isUpPressed() == true) {
            playerY-= playerSpeed;
        }
        else if (keyH.isLeftPressed() == true) {
            playerX-= playerSpeed;
        }
        else if (keyH.isRightPressed() == true) {
            playerX+= playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // Gives you more options.

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize); // Represents player atm.

        g2.dispose();
    }

}
