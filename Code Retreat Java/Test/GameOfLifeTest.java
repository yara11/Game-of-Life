
import java.util.Arrays;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class GameOfLifeTest {

    @Test
    public void isValidTest() {
        boolean[][] z = {{false}, {false}};
        GameOfLife gol = new GameOfLife(z);
        assert (gol.isValid(-1, -1) == false && gol.isValid(1, 0) == true);
    }

    @Test
    public void neighbourCountTest() {
        boolean[][] z = {{true, true, false, false}, {true, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        GameOfLife gol = new GameOfLife(z);
        assert (gol.neighbourCount(0, 0) == 2 && gol.neighbourCount(3, 3) == 0);
    }

    @Test
    public void checkTest() {

        boolean[][] z = {{true, true, false, false}, {true, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        GameOfLife gol = new GameOfLife(z);
        assert (gol.check(true, 3) == true);
    }

    @Test
    public void nextStateTest() {
        boolean[][] init = {{true, true, false, false}, {true, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        boolean[][] fin = {{true, true, false, false}, {true, true, false, false}, {false, false, false, false}, {false, false, false, false}};
        GameOfLife gol = new GameOfLife(init);
        //assert(Arrays.equals(gol.nextState(), fin));
        boolean passed = true;
        boolean[][] result = gol.nextState();
        for (int i = 0; i < gol.rows; i++) {
            for (int j = 0; j < gol.cols; j++) {
                if (fin[i][j] != result[i][j]) {
                    passed = false;
                    break;
                }
            }
        }
        assert (passed);
    }

    @Test
    public void nextStateTest2() {
        boolean[][] init = {{true}, {true}};
        boolean[][] fin = {{false}, {false}};
        GameOfLife gol = new GameOfLife(init);
        boolean passed = true;
        boolean[][] result = gol.nextState();
        for (int i = 0; i < gol.rows; i++) {
            for (int j = 0; j < gol.cols; j++) {
                if (fin[i][j] != result[i][j]) {
                    passed = false;
                    break;
                }
            }
        }
        assert (passed);
    }
}
