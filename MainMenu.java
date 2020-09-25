import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MainMenu implements ActionListener{
    JFrame frame;
    JButton MS;
    JButton CA;

    public static void main(String[] args){
        new MainMenu();
    }
    public MainMenu(){
        frame= new JFrame("5-in-1 Collection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(new GridLayout(2,1));
        JLabel header= new JLabel("5-in-1 Collection!",JLabel.CENTER);
        Box Panel= new Box(BoxLayout.Y_AXIS);
        Panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        MS= new JButton("MineSweep");
        CA= new JButton("Calculator");
        MS.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        CA.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        MS.addActionListener(this);
        CA.addActionListener(this);
        Panel.add(MS);
        Panel.add(CA);
        frame.add(header);
        frame.add(Panel);
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {  
        frame.dispose();
        if(e.getSource()==MS){
            new Minesweep();
        }
        else if(e.getSource()==CA){
            new Calculator();
        }
    }
}