import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class Components extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    JTextArea txtar;
    JComboBox<String> cb1;
    JComboBox<Character> cb2;
    final String department[]={"Pharmacy","IT","Tech"};
    final Character gr[]={'A','B','C'};
    Components(){}
    Components(String s){
        super(s);
    }
    public void setComponents(){
        l1= new JLabel("Employee id : ");
        l2= new JLabel("Enter Name : ");
        l3= new JLabel("Basic salary : ");
        l4=new JLabel("");
        l5=new JLabel("Department");
        l6=new JLabel("Grade");
        l7=new JLabel("Employee id : ");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        b1= new JButton("Save"); 
        b2=new JButton("New"); 
        b3=new JButton("View"); 
        cb1=new JComboBox<>(department);
        cb2=new JComboBox<> (gr);
        l8=new JLabel("");
        setLayout(null);
        
        l1.setBounds(50,50,150,20);
        t1.setBounds(150,50,100,20);
        l2.setBounds(50,80,100,20);
        t2.setBounds(150,80,100,20);
        l3.setBounds(50,110,100,20);
        t3.setBounds(150,110,100,20);
        l5.setBounds(50,150,100,20);
        l6.setBounds(180,150,100,20);
        cb1.setBounds(50, 180,100,20);
        cb2.setBounds(180,180,100,20);
        b1.setBounds(50, 220, 100, 20);
        b2.setBounds(180, 220, 100, 20);
        l7.setBounds(50,300,100,20);
        t4.setBounds(180,300,100,20);
        b3.setBounds(100,350,150,20);
        l4.setBounds(100,260,400,20);
        l8.setBounds(50,400,100,400);
        b1.addActionListener(new CollectionClass());
        b2.addActionListener(new CollectionClass());
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l5);
        add(l6);
        add(cb1);
        add(cb2);
        add(b1);
        add(b2);
        add(l4);
        add(l8);
        
    }
    class CollectionClass implements ActionListener{
        ArrayList<EmployeeD> emp;
        Components c;
        CollectionClass(){
            emp=new ArrayList<>();
            c=new Components();
        }
        public int unique(String s){
            for(int i=0;i<EmployeeD.count;i++)
                if(s.equals(emp.get(i).retEmpId()))
                    return i;
            return -1;
        }
        public void actionPerformed(ActionEvent e){
            String str=e.getActionCommand();
            if(str.equals("Save")){
            String s1=t1.getText();
            int a=unique(s1);
            if(a==-1){
                EmployeeD ep=new EmployeeD();
                String n=t2.getText();
                Double d=Double.parseDouble(t3.getText());
                Character g=cb2.getItemAt(cb2.getSelectedIndex());
                String dept=cb1.getItemAt(cb1.getSelectedIndex());
                ep.setValue(s1, n, d, g, dept);
                emp.add(ep);
                l4.setText("Employee added successfully!!");
               
                
            }
            else
                JOptionPane.showMessageDialog(GuiSet.cp, "Employee id already exists!","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(str.equals("New")){
                t1.setText("");
                t2.setText("");
                t3.setText("");
                cb1.setSelectedIndex(0);;
                cb2.setSelectedIndex(0);;
                l4.setText("");
                 }
            }
        }
}

class GuiSet{
    static Components cp;
    GuiSet(){
        cp=new Components("Employee Interface");
        cp.setComponents();
        //cp.pack();
        cp.setSize(500,500);
        cp.setVisible(true);
        cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}



public class EmployeeGui {
    public static void main(String[] args) {
        GuiSet gs=new GuiSet();

    }
    
}
