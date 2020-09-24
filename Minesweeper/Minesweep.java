import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.lang.Math;
import java.applet.Applet;
import java.awt.Graphics;
//Could make a button class to add attributes a nd make code cleaner.
public class Minesweep implements ActionListener{
    JFrame frame;
    JToggleButton[][] list;
    boolean Mines[][];
    boolean LookedAt[][];
    JMenu Menu;
    JMenuItem item1;
    ImageIcon Bomb;
    public static void main(String[] args){
        new Minesweep();
    }
    public Minesweep(){
        frame = new JFrame("Minesweep");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(new GridLayout(4,4));
        Bomb= new ImageIcon("Mine.png", "boom.");
        JMenuBar Bar= new JMenuBar();
        Menu= new JMenu("Options");
        item1= new JMenuItem("Reset");    
        Menu.add(item1);
        Bar.add(Menu);
        AddGame();
        item1.addActionListener(this);
        frame.setJMenuBar(Bar);
        frame.setVisible(true);
    }

    public void AddGame(){
        Mines=new boolean[4][4];
        LookedAt= new boolean [4][4];
        for(int row=0;row<Mines.length;row++){
            for(int col=0;col<Mines[row].length;col++){
                if(Math.random()>0.75){
                    Mines[row][col]=true;
                }
            }
        }
        list= new JToggleButton[4][4];
        for(int row=0;row<list.length;row++){
            for(int col=0;col<list[row].length;col++){
                addToggleButton(row,col);
            }
        }
    }

    private void addToggleButton(int row,int col){
        JToggleButton button=new JToggleButton();
        list[row][col]=button;
        frame.add(button);  
        button.addActionListener(this); 
    }

    public int CheckMine(int row,int col){
        int MineCheck=0;
        int end=Mines.length-1;
        if(row!=0){
            if(Mines[row-1][col]){
                MineCheck++;
            }
        }
        if(row!=end){
            if(Mines[row+1][col]){
                MineCheck++;
            }
        }
        if(col!=0){
            if(Mines[row][col-1]){
                MineCheck++;
            }
        }
        if(col!=end){
            if(Mines[row][col+1]){
                MineCheck++;
            }
        }

        if(row!=0 && col!=0){
            if(Mines[row-1][col-1]){
                MineCheck++;
            }
        }

        if(row!=end && col!=0){
            if(Mines[row+1][col-1]){
                MineCheck++;
            }
        }

        if(row!=0 && col!=end){
            if(Mines[row-1][col+1]){
                MineCheck++;
            }
        }

        if(row!=end && col!=end){
            if(Mines[row+1][col+1]){
                MineCheck++;
            }
        }


        return MineCheck;
    }

    public void Restart(){
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        AddGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==item1){
            Restart();
            AddGame();
        }
        for(int row=0;row<list.length;row++){
            for(int col=0;col<list[row].length;col++){
                if(list[row][col].isSelected() && !LookedAt[row][col]){
                    list[row][col].setEnabled(false);
                    JOptionPane.showMessageDialog(frame,"Mines around block is: "+CheckMine(row, col));
                    if(Mines[row][col]){
                        frame.getContentPane().removeAll();
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        //JLabel BombLabel= new JLabel(Bomb);
                        //BombLabel.setBounds(200,500,100,125);
                        //frame.add(BombLabel);
                        JOptionPane.showMessageDialog(frame,"Mortis");
                        Restart();
                    }
                    LookedAt[row][col]=true;
                    
                }
            }
        }
    }


    
}
