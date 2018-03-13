package alarm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

 
 

public class MainFrame extends JFrame{
	public static int abc;
	public Object a;    
	
	     
	public MainFrame(){
		JButton btnDispose = new JButton("닫기");
		JPanel panel=new JPanel();
        this.setTitle("안내");
        this.setSize(150,100);
        this.setLocationRelativeTo(null);
        
        btnDispose.setVisible(true);
        btnDispose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        
    
     
        int sm = abc;
		switch(sm) {
		
    	case 1: 
    		panel.add(new JLabel("   쉬는 시간입니다!   "));
    	break;
    	
    	case 2:
    		panel.add(new JLabel("   점심 시간입니다!   "));
    	break;
    	
    	case 3:
    		panel.add(new JLabel("   자습 시간입니다!   "));
    	break;
    	
    	case 4:
    		panel.add(new JLabel("   집에갈 시간입니다!   "));
    	
    	}		
		 
		
		 panel.add(btnDispose);
        this.getContentPane().add(panel);
        this.setVisible(true);
       

    }
		
    void a() {
    
	new MainFrame();
    }
   

 }