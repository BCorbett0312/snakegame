import javax.swing.*;
import java.awt.*;

public class Render extends Component {


    public Render() {

    }

    public void drawBoard(Graphics g, Snake snake){
        drawTitleBorder(g);
        drawTitleBox(g);
        drawGameplayBorder(g);
        drawBackground(g);
        drawScores(g, snake);
        drawLengthOfSnake(g, snake);
    }

    public void drawLoseState(Graphics g, Snake snake){
        drawGameOver(g);
        drawRestart(g);
    }

    private void drawTitleBorder(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);
    }

    private void drawTitleBox(Graphics g){
        if(getClass().getClassLoader().getResource("snaketitle.jpg") != null) {
            ImageIcon titleImage = new ImageIcon(getClass().getClassLoader().getResource("snaketitle.jpg"));
            titleImage.paintIcon(this, g, 25, 11);
        }
    }

    private void drawGameplayBorder(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
    }

    private void drawBackground(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(25,75, 850, 575);
    }

    private void drawScores(Graphics g, Snake snake){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Score:  "+ snake.getScore(), 780, 30);
    }

    private void drawLengthOfSnake(Graphics g, Snake snake){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + snake.getLength(), 780, 50);
    }

    public void drawSnake(Graphics g, Snake snake){
        drawRightHead(g, snake);
        for(int index = 0; index <= snake.getLength(); index++){
            if(index == 0 && snake.getDirection() == Direction.RIGHT){
                drawRightHead(g, snake);
            }
            if(index == 0 && snake.getDirection() == Direction.LEFT){
                drawLeftHead(g, snake);
            }
            if(index == 0 && snake.getDirection() == Direction.DOWN){
                drawDownHead(g, snake);
            }
            if(index == 0 && snake.getDirection() == Direction.UP){
                drawUpHead(g, snake);
            }
            if(index != 0){
                drawBodySegment(g, snake, index);
            }
        }
    }

    private void drawRightHead(Graphics g, Snake snake){
        ImageIcon rightMouth = new ImageIcon(getClass().getClassLoader().getResource("rightmouth.png"));
        rightMouth.paintIcon(this, g, snake.getSnakeXLength()[0], snake.getSnakeYLength()[0]);
    }

    private void drawLeftHead(Graphics g, Snake snake){
        ImageIcon leftMouth = new ImageIcon(getClass().getClassLoader().getResource("leftmouth.png"));
        leftMouth.paintIcon(this, g, snake.getSnakeXLength()[0], snake.getSnakeYLength()[0]);
    }
    private void drawDownHead(Graphics g, Snake snake){
        ImageIcon downMouth = new ImageIcon(getClass().getClassLoader().getResource("downmouth.png"));
        downMouth.paintIcon(this, g, snake.getSnakeXLength()[0], snake.getSnakeYLength()[0]);
    }
    private void drawUpHead(Graphics g, Snake snake){
        ImageIcon upMouth = new ImageIcon(getClass().getClassLoader().getResource("upmouth.png"));
        upMouth.paintIcon(this, g, snake.getSnakeXLength()[0], snake.getSnakeYLength()[0]);
    }

    private void drawBodySegment(Graphics g, Snake snake, Integer index){
        ImageIcon snakeImage = new ImageIcon(getClass().getClassLoader().getResource("snakeimage.png"));
        snakeImage.paintIcon(this, g, snake.getSnakeXLength()[index], snake.getSnakeYLength()[index]);
    }

    public void drawApple(Graphics g, Apple apple){
        ImageIcon appleImage = new ImageIcon(getClass().getClassLoader().getResource("enemy.png"));
        appleImage.paintIcon(this, g, apple.getXLocation(), apple.getYLocation());
    }

    private void drawGameOver(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString("Game Over", 300, 300);
    }

    private void drawRestart(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Press Space to Restart", 350, 340);
    }
}
