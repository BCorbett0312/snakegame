import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {



    private Integer moves = 0;

    private Boolean toPlay;
    private Render render;

    private Timer timer;
    private Integer delay = 100;

    private Snake snake;
    private Apple apple;


    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        render = new Render();
        this.apple = new Apple();
        snake = new Snake();
    }

    public void paint(Graphics g){

        if (moves == 0) {
            toPlay = true;
            snake.getSnakeXLength()[0] = 50;
            snake.getSnakeYLength()[0] = 100;
        }
        render.drawBoard(g, snake);
        render.drawSnake(g, snake);
        checkIfAppleEaten();
        render.drawApple(g, apple);
        checkForEatSelf(g);


        g.dispose();

    }

    public void checkIfAppleEaten(){

        if(apple.getXLocation() == snake.getSnakeXLength()[0] && apple.getYLocation() == snake.getSnakeYLength()[0]){
            snake.setScore(snake.getScore()+3);
            snake.setLength(snake.getLength()+ 1);
            apple.makeNewApple();
            speedUp();
        }

    }

    public void checkForEatSelf(Graphics g){
        for(int b = 1; b < snake.getLength(); b++){
            if (snake.getSnakeXLength()[b] == snake.getSnakeXLength()[0] && snake.getSnakeYLength()[b] == snake.getSnakeYLength()[0]){
                snake.setDirection(Direction.NONE);
                toPlay = false;
                render.drawLoseState(g, snake);
            }
        }
    }

    public void speedUp(){
        if(timer.getDelay() > 10){
            timer.setDelay(timer.getDelay()-1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(snake.getDirection() == Direction.RIGHT){
            snakeExitRight();
        }
        if(snake.getDirection() == Direction.LEFT){
            snakeExitLeft();
        }
        if(snake.getDirection() == Direction.DOWN){
            snakeExitDown();
        }
        if(snake.getDirection() == Direction.UP){
            snakeExitUp();
        }
    }

    public void snakeExitUp(){
        for(int r  = snake.getLength()-1; r>=0; r--){
            snake.getSnakeXLength()[r+1] = snake.getSnakeXLength()[r];
        }
        for(int r = snake.getLength(); r>=0; r--){
            if(r == 0){
                snake.getSnakeYLength()[r] = snake.getSnakeYLength()[r] - 25;
            }
            else{
                snake.getSnakeYLength()[r] = snake.getSnakeYLength()[r-1];
            }
            if(snake.getSnakeYLength()[r] < 75){
                snake.getSnakeYLength()[r] = 625;
            }
        }
        repaint();
    }

    public void snakeExitDown(){
        for(int r  = snake.getLength()-1; r>=0; r--){
            snake.getSnakeXLength()[r+1] = snake.getSnakeXLength()[r];
        }
        for(int r = snake.getLength(); r>=0; r--){
            if(r == 0){
                snake.getSnakeYLength()[r] = snake.getSnakeYLength()[r] +25;
            }
            else{
                snake.getSnakeYLength()[r] = snake.getSnakeYLength()[r-1];
            }
            if(snake.getSnakeYLength()[r] > 625){
                snake.getSnakeYLength()[r] = 75;
            }
        }
        repaint();
    }

    public void snakeExitLeft(){
        for(int r  = snake.getLength()-1; r>=0; r--){
            snake.getSnakeYLength()[r+1] = snake.getSnakeYLength()[r];
        }
        for(int r = snake.getLength(); r>=0; r--){
            if(r == 0){
                snake.getSnakeXLength()[r] = snake.getSnakeXLength()[r] - 25;
            }
            else{
                snake.getSnakeXLength()[r] = snake.getSnakeXLength()[r-1];
            }
            if(snake.getSnakeXLength()[r] < 25){
                snake.getSnakeXLength()[r] = 850;
            }
        }
        repaint();
    }

    public void snakeExitRight(){
        for(int r  = snake.getLength()-1; r>=0; r--){
            snake.getSnakeYLength()[r+1] = snake.getSnakeYLength()[r];
        }
        for(int r = snake.getLength(); r>=0; r--){
            if(r == 0){
                snake.getSnakeXLength()[r] = snake.getSnakeXLength()[r] +25;
            }
            else{
                snake.getSnakeXLength()[r] = snake.getSnakeXLength()[r-1];
            }
            if(snake.getSnakeXLength()[r]>850){
                snake.getSnakeXLength()[r] = 25;
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(!toPlay) {
                moves = 0;
                snake.setScore(0);
                snake.setLength(1);
                repaint();
            }
        } else{
            if(toPlay) {
                updateGameAfterPress(e);
            }
        }


    }

    public void keyReleased(KeyEvent e) {

    }

    public void updateGameAfterPress(KeyEvent e){
        moves++;
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(snake.getDirection()!= Direction.LEFT){
                    snake.setDirection(Direction.RIGHT);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(snake.getDirection()!=Direction.RIGHT){
                    snake.setDirection(Direction.LEFT);
                }
                break;
            case KeyEvent.VK_UP:
                if (snake.getDirection()!=Direction.DOWN){
                    snake.setDirection(Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(snake.getDirection()!=Direction.UP){
                    snake.setDirection(Direction.DOWN);
                }
                break;
        }
    }



}
