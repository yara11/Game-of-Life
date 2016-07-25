
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class GameOfLife {
    boolean grid[][];
    JButton[][] buttonGrid;
    int rows,cols;
    
    public GameOfLife(boolean g[][]) {
        rows = g.length;
        cols = g[0].length;
        grid = g;
        buttonGrid = new JButton[rows][cols];
        gameGui();
    }
    
    boolean isValid(int x,int y) {
        return x>=0 && x < rows && y>=0 && y <cols;
    }
    
    int neighbourCount(int x,int y) {
        int live = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j<=1; j++){
                if(i ==0 && j == 0)
                    continue;
                if(isValid(x+i,y+j) && grid[x+i][y+j] == true){
                    live++;
                }
            }
        }
        return live;
    }
    
    boolean check(boolean val, int neigh) {
        if(neigh == 2){
            return val;
        }
        else if(neigh == 3){
            return true;
        }
        return false;
    }
    
    public void nextState(){
        boolean[][] next = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                next[i][j] = check(grid[i][j], neighbourCount(i,j));
                if(grid[i][j])
                    buttonGrid[i][j].setBackground(Color.black);
                else buttonGrid[i][j].setBackground(Color.white);
            }
        }
        grid = next;
        //return next;
    }
    
//    public void printGame() {
//        for(int i = 0; i < rows; i++){
//            for(int j = 0; j < cols; j++) {
//                if(grid[i][j] == true) {
//                   System.out.print("*"); 
//                } else {
//                    System.out.print("-");
//                }
//                
//            }
//            System.out.println();
//        }
//    }
    
    public void gameGui() {
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(rows, cols));
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                buttonGrid[i][j] = new JButton();
                //buttonGrid[i][j].setBackground(Color.white);
                if(grid[i][j])
                    buttonGrid[i][j].setBackground(Color.black);
                else buttonGrid[i][j].setBackground(Color.white);
                frame.add(buttonGrid[i][j]);
            }
        }
        frame.pack();
        frame.setVisible(true);
               
    }
    
    public static void main(String[] args) throws InterruptedException {
        boolean[][] matrix = {{false,false,false,false,false},
                                {false,false,false,false,false},
                                {false,true,true,true,false},
                                {false,false,false,false,false},
                                {false,false,false,false,false}};
        GameOfLife game = new GameOfLife(matrix);
        while(true) {
  //          game.printGame();
            Thread.currentThread().sleep(2000);
            game.nextState();
        }
    }
}
