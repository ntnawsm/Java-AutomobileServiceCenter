import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Start implements ActionListener
{
    private JFrame f;
    private JPanel p,p1;
    private JTabbedPane tp;
    private JLabel ltitle,luser,lpass,latitle,lauser,lapass,background,bak1;
    private JTextField tuser,tatitle,tauser;
    private JButton bsubmit,basubmit;
    private JPasswordField tpass,tapass;
    
    Start() throws SQLException
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("Automobile service center");
        p = new JPanel();
        p1 = new JPanel();
        tp = new JTabbedPane();
        tp.add("Employee Login",p);tp.add("Admin Login",p1);
        f.add(tp);
        f.setVisible(true);
        background = new JLabel();
        p.add(background);
        background.setBounds(0,0,800,600);
        f.setSize(1366,768);
        f.setLocation(0,0);
        p.setLayout(null);
        //f.getRootPane().setDefaultButton(bsubmit);
        
        
        //Labels
        background = new JLabel(new ImageIcon("C:\\Users\\NtN\\Downloads\\Pictures\\2016_racing_one_ferrari_458_loma_wheels_2-wallpaper-1366x768.jpg"));
        p.add(background);
        background.setBounds(0,0,1366,768);
        
        ltitle =new JLabel("EMPLOYEE LOGIN PAGE");
        background.add(ltitle);
        ltitle.setBounds(160,150,350,30);
        ltitle.setForeground(Color.WHITE);
        ltitle.setFont(new Font("Arohni",Font.BOLD,25));
        
        //luser = new JLabel("Employee ID:");
        //background.add(luser);
        //luser.setBounds(150,130,150,20);
        //luser.setFont(new Font("Kristen ITC",Font.BOLD,15));
        
        //lpass = new JLabel("Password:");
         //background.add(lpass);
        //lpass.setBounds(150,180,150,20);
        //lpass.setFont(new Font("Kristen ITC",Font.BOLD,15));
        
        
        
       //Text Field
        
        tuser = new JTextField("Employee ID");
        background.add(tuser);
        tuser.setBounds(220,280,200,30);
        tuser.setFont(new Font("",Font.BOLD,18));
        tuser.setToolTipText("Enter your Emplouee ID");
        tuser.setForeground(Color.GRAY);
        tuser.addActionListener(this);
       
      /* 
        tuser.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent ke)
                    {
                      tuser.setText("");
                      tuser.setForeground(Color.BLACK);
                    }
                });  
        */
         tuser.addFocusListener(new FocusListener()
                {
                    @Override
                    public void focusGained(FocusEvent fe)
                    {
                            
                            if(tuser.getText().equals("Employee ID"))
                            {
                                tuser.setText("");
                                tuser.setForeground(Color.BLACK);
                            }
                            
                    }
                    
                    @Override
                    public void focusLost(FocusEvent fe)
                    {
                            
                            if("".equalsIgnoreCase(tuser.getText().trim()))
                            {
                                tuser.setText("Employee ID");
                                tuser.setForeground(Color.GRAY);
                            } 
                    }
                });
        
        //Password Field
        tpass = new JPasswordField("Password");
        
        background.add(tpass);
        tpass.setBounds(220,340,200,30);
        tpass.setToolTipText("Enter your Password");
        tpass.setFont(new Font("",Font.BOLD,18));
        tpass.setForeground(Color.GRAY);
        tuser.addActionListener(this);
        tpass.setEchoChar((char)0);   //internet
        tpass.addFocusListener(new FocusListener()
                {
                    @Override
                    public void focusGained(FocusEvent fe)
                    {
                            tpass.setEchoChar('*');
                            if(tpass.getText().equals("Password"))
                            {
                                tpass.setText("");
                                tpass.setForeground(Color.BLACK);
                            }
                            
                    }
                    
                    @Override
                    public void focusLost(FocusEvent fe)
                    {
                            
                            if("".equalsIgnoreCase(tpass.getText().trim()))
                            {
                                tpass.setEchoChar((char)0);
                                tpass.setText("Password");
                                tpass.setForeground(Color.GRAY);
                            } 
                    }
                });
        
        //Button
        
        bsubmit = new JButton("Login");
        bsubmit.setFont(new Font("",Font.BOLD,18));
        background.add(bsubmit);
        bsubmit.setBounds(270,400,150,25);
        bsubmit.addActionListener(this);
        
        
        
        //Panel 2
        p1.setLayout(null);
        //Labels
        
         bak1 = new JLabel(new ImageIcon("C:\\Users\\Ntn\\Downloads\\Pictures\\backgroundlogin1366x768.jpg"));
        p1.add(bak1);
        bak1.setBounds(0,0,1366,768); 
        
        latitle =new JLabel("ADMIN LOGIN PAGE");
        bak1.add(latitle);
        latitle.setBounds(800,170,250,30);
        latitle.setForeground(Color.WHITE);
        latitle.setFont(new Font("Arohni",Font.BOLD,25));
        
        /*lauser = new JLabel("Username:");
        bak1.add(lauser);
        lauser.setBounds(150,130,150,20);
        lauser.setFont(new Font("Kristen ITC",Font.BOLD,15));
        
        lapass = new JLabel("Password:");
        bak1.add(lapass);
        lapass.setBounds(150,180,150,20);
        lapass.setFont(new Font("Kristen ITC",Font.BOLD,15));*/
        
       
        
        //TextFields
        
        tauser = new JTextField("Admin User ID");
        bak1.add(tauser);
        tauser.setBounds(820,280,200,30);
        tauser.setFont(new Font("",Font.BOLD,18));
        tauser.setToolTipText("Enter USER ID");
        tauser.setForeground(Color.GRAY);
        
        tauser.addFocusListener(new FocusListener()
                {
                    @Override
                    public void focusGained(FocusEvent fe)
                    {
                            
                            if(tauser.getText().equals("Admin User ID"))
                            {
                                tauser.setText("");
                                tauser.setForeground(Color.BLACK);
                            }
                      }
                    
                    @Override
                    public void focusLost(FocusEvent fe)
                    {
                            
                            if("".equalsIgnoreCase(tauser.getText().trim()))
                            {
                                tauser.setText("Admin User ID");
                                tauser.setForeground(Color.GRAY);
                            } 
                    }
                });
        
        //PasswordField
        
        tapass = new JPasswordField("Password");
        bak1.add(tapass);
        tapass.setBounds(820,350,200,30);
        tapass.setToolTipText("Enter your Password");
        tapass.setFont(new Font("",Font.BOLD,18));
        tapass.setForeground(Color.GRAY);
        tapass.setEchoChar((char)0);   //internet
        tapass.addFocusListener(new FocusListener()
                {
                    @Override
                    public void focusGained(FocusEvent fe)
                    {
                            tapass.setEchoChar('*');
                            if(tapass.getText().equals("Password"))
                            {
                                tapass.setText("");
                                tapass.setForeground(Color.BLACK);
                            }
                            
                    }
                    @Override
                    public void focusLost(FocusEvent fe)
                    {
                            
                            if("".equalsIgnoreCase(tapass.getText().trim()))
                            {
                                tapass.setEchoChar((char)0);
                                tapass.setText("Password");
                                tapass.setForeground(Color.GRAY);
                            } 
                    }
                });
        
        //Buttons
        
        basubmit = new JButton("Login");
        bak1.add(basubmit);
        basubmit.setFont(new Font("",Font.BOLD,18));
        basubmit.setBounds(870,415,150,25);
        basubmit.addActionListener(this);
        
        
        
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
     public static boolean validate(String eid,String password)
     {
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from emp where e_id=? and e_pass=?");
			ps.setString(1,eid);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
     }
     
    public static void main(String args[]) throws SQLException 
    {
        new Start();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        
     if(e.getSource()==bsubmit)
     {
        String user = tuser.getText();
        String pass = String.valueOf(tpass.getPassword());
        if(user.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the Employee ID");
        }
        else if(pass.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the password");
        }
        else
        {
         if(validate(user,pass))
         {      
            JOptionPane.showMessageDialog(null,"Welcome ");
            new Emplywel();
            f.dispose();
         }
        else
         {
	   JOptionPane.showMessageDialog(f, "Sorry, Username or Password Error!! CONTACT ADMIN","Login Error!", JOptionPane.ERROR_MESSAGE);
	   tuser.setText("");
	   tpass.setText("");
	 }
        }
     }
     else if(e.getSource()==basubmit)
     {
         String auser = tauser.getText();
         String apass = tapass.getText();
        if(auser.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the username");
        }
        else if(apass.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the password");
        }
        else if(auser.equals("admin") && apass.equals("admin123"))
        {
             try 
             {
                 new Employee_Details();
             } 
             catch (SQLException ex)
             {}
             catch (ParseException ex)
             {}
            f.dispose();
        } 
        else
        {
            JOptionPane.showMessageDialog(f,"Username or password are wrong");
            tauser.setText("");
            tapass.setText("");
        }
     }
    }
}
