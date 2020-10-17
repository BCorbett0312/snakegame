import java.util.Random;

public class Apple {

    //Array of possible x-axis locations
    private final Integer[] appleXPos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275,
            300, 325, 350, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675,
            700, 725, 750, 775, 800, 825, 850};

    //Array of possible y-axis locations
    private final Integer[] appleYPos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
            350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650};

    //Use these to return a random location for an apple
    private Random random = new Random();
    private Integer xPos;
    private Integer yPos;


    public Apple(){
        xPos = random.nextInt(33);
        yPos = random.nextInt(23);
    }

    public Integer getXLocation() {
        return appleXPos[xPos];
    }

    public Integer getYLocation() {
        return appleYPos[yPos];
    }

    public void makeNewApple(){
        xPos = random.nextInt(33);
        yPos = random.nextInt(23);
    }
}
