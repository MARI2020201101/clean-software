package ch06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BollingGameDemo {
    private Game g;
    @BeforeEach
    void setUp(){
        g = new Game();
    }
    @Test
    public void testScoreNoThrows(){
        Frame f = new Frame();
        f.add(5);
        assertEquals(5,f.getScore());
    }

    @Test
    public void testOneThrow(){
        g.add(5);
        assertEquals(5, g.score());
    }

    @Test
    public void testTwoThrowsNoMark(){
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
        assertEquals(1, g.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(2, g.getCurrentFrame());
    }

    @Test
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(3, g.getCurrentFrame());
    }


}
class Frame{

    private int score;

    public void add(int pins){
        this.score+=pins;
    }
    public int getScore(){
        return score;
    }
}
class Game{
    private int itsScore;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private boolean firstThrow = true;
    private int itsCurrentFrame = 1;

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if(firstThrow){
            firstThrow = false;
            itsCurrentFrame++;
        }else{
            firstThrow = true;
        }
    }

    public int score() {
        return scoreForFrame(getCurrentFrame()-1);
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        int ball = 0;
        for(int currentFrame = 0;currentFrame < theFrame ; currentFrame++){
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;

            if(frameScore==10){
                score += frameScore + itsThrows[ball];
            }
            else{
                score += frameScore;
            }
        }
        return score;
    }
}