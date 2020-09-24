import javax.swing.*;

import java.awt.Label;
import java.awt.event.*;
import java.util.ArrayList;
public class Calculator implements ActionListener {
    public int x_place;
    public int y_place;
    public int z;
    public String x="";
    public String answer="";
    public ArrayList<String> equation=new ArrayList<String>();
    public int exp=0;
    public Label Display=new Label("0",Label.RIGHT);
    public Calculator(){
        JFrame frame= new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        JButton button1 = new JButton("1");
        button1.addActionListener(this);
        JButton button2 = new JButton("2");
        button2.addActionListener(this);

        JButton button3 = new JButton("3");
        button3.addActionListener(this);

        JButton button4 = new JButton("4");
        button4.addActionListener(this);

        JButton button5 = new JButton("5");
        button5.addActionListener(this);

        JButton button6 = new JButton("6");
        button6.addActionListener(this);

        JButton button7 = new JButton("7");
        button7.addActionListener(this);

        JButton button8 = new JButton("8");
        button8.addActionListener(this);

        JButton button9 = new JButton("9");
        button9.addActionListener(this);

        JButton button0 = new JButton("0");
        button0.addActionListener(this);


        JButton Plus = new JButton(new AbstractAction("+"){
            @Override
            public void actionPerformed(ActionEvent e){
                equation.add(x);

                for(int i=0; i < equation.size(); i++){
                    System.out.print( equation.get(i) );
                }

                System.out.println("");
                
                if(exp==0 && !x.equals("")){
                    exp=1;
                    equation.add("+");
                    x="";
                }
                else if(!answer.equals("") && equation.size()==1){
                    exp=1;
                    equation.add("+");
                    x="";
                }

                else{
                    Operation(Integer.parseInt(equation.get(0)),Integer.parseInt(equation.get(2)),equation.get(1));
                    equation.add("+");
                }
            }
        });

        JButton Minus = new JButton(new AbstractAction("-"){
            @Override
            public void actionPerformed(ActionEvent e){
                equation.add(x);

                if(exp==0 && !x.equals("")){
                    exp=1;
                    equation.add("-");
                    x="";
                    

                }

                else if(!answer.equals("") && equation.size()==1){
                    exp=1;
                    equation.add("-");
                    x="";
                }

                else{
                    Operation(Integer.parseInt(equation.get(0)),Integer.parseInt(equation.get(2)),equation.get(1));
                    equation.add("-");
                }
            }
        });

        JButton Multi = new JButton(new AbstractAction("*"){
            @Override
            public void actionPerformed(ActionEvent e){
                equation.add(x);
                
                if(exp==0 && !x.equals("")){
                    exp=1;
                    equation.add("*");
                    x="";
                    

                }

                else if(!answer.equals("") && equation.size()==1){
                    exp=1;
                    equation.add("*");
                    x="";
                }

                else{
                    Operation(Integer.parseInt(equation.get(0)),Integer.parseInt(equation.get(2)),equation.get(1));
                    equation.add("*");
                }
            }
        });

        JButton Divide = new JButton(new AbstractAction("/"){
            @Override
            public void actionPerformed(ActionEvent e){
                equation.add(x);
                
                if(exp==0 && !x.equals("")){
                    exp=1;
                    equation.add("/");
                    x="";
                    

                }

                else if(!answer.equals("") && equation.size()==1){
                    exp=1;
                    equation.add("/");
                    x="";
                }

                else{
                    Operation(Integer.parseInt(equation.get(0)),Integer.parseInt(equation.get(2)),equation.get(1));
                    equation.add("/");
                }
            }
        });


        JButton Erase = new JButton(new AbstractAction("C/E"){
            @Override
            public void actionPerformed(ActionEvent e){
                x="";
                z=0;
                exp=0;
                answer="";
                Display.setText("0");
                equation=new ArrayList<String>();
            }
        });

        JButton Equals = new JButton(new AbstractAction("="){
            @Override
            public void actionPerformed(ActionEvent e){
                if(equation.size()==2 && !x.equals("")){
                    equation.add(x);
                    Operation(Integer.parseInt(equation.get(0)),Integer.parseInt(equation.get(2)),equation.get(1));
                    exp=0;
                }
            }
        });

        button1.setBounds(50,260,50,20);
        button2.setBounds(150,260,50,20);
        button3.setBounds(250,260,50,20);
        button4.setBounds(50,300,50,20);
        button5.setBounds(150,300,50,20);
        button6.setBounds(250,300,50,20);
        button7.setBounds(50,340,50,20);
        button8.setBounds(150,340,50,20);
        button9.setBounds(250,340,50,20);
        button0.setBounds(150,380,50,20);

        Plus.setBounds(325,260,50,20);
        Minus.setBounds(325,300,50,20);
        Multi.setBounds(325,340,50,20);
        Divide.setBounds(325,380,50,20);

        Erase.setBounds(310,220,65,25);
        Equals.setBounds(250, 380, 50, 20);

        Display.setBounds(150, 220, 150, 20);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button0);


        frame.add(Plus);
        frame.add(Minus);
        frame.add(Multi);
        frame.add(Divide);

        frame.add(Erase);
        frame.add(Equals);

        frame.add(Display);


        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        x=x+e.getActionCommand();
        Display.setText(x);
    }
    
    public void Operation(int a,int b,String compare){
        if(compare.equals("+")){
            z=a+b;
        }
        else if(compare.equals("-")){
            z=a-b;
        }
        else if(compare.equals("*")){
            z=a*b;
        }
        else{
            z=a/b;
        }
        equation=new ArrayList<String>();
        answer=""+z;
        Display.setText(answer);
        equation.add(answer);
        x="";
        z=0;
    }

    public static void main(String[] args){
        Calculator test= new Calculator();
    }
}