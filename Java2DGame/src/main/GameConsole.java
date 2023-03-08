package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GameConsole extends JPanel implements Runnable {
    //16x16
    final int originalTileSize = 16;
    //scaling small 16x16 up larger
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    //768px width 576px height
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;


    //setting FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);

    KeyHandler keyH = new KeyHandler();

    Thread gameThr;
    Player player = new Player(this,keyH);

    public GameConsole() {
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThr(){
        gameThr = new Thread(this);
        gameThr.start();
    }
    //creates the game loop tracks time of the game
    @Override
    public void run() {
        //1 second divided by 60 so you are drawing the screen 60 times per second or once every 0.1666 seconds
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThr != null) {
            //checking the current time
            //System.nanoTime(); better than mills

            //update then draw
            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000000;

                //no need to sleep
                if(remainingTime < 0){
                    remainingTime = 0;

                }
                //pauses game loop
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //moving player by players speed
    public void update(){
        player.update();


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //draw tiles first then player
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
