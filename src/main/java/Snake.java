import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Integer length;
    private int[] snakeXLength;
    private int[] snakeYLength;
    private Direction direction;

    private Integer score;

    public Snake() {
        length = 0;
        snakeXLength = new int[750];
        snakeYLength = new int[750];
        direction = Direction.RIGHT;
        score = 0;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int[] getSnakeXLength() {
        return snakeXLength;
    }


    public int[] getSnakeYLength() {
        return snakeYLength;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getScore(){
        return this.score;
    }
}
