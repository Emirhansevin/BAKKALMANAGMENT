package MySQLp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ekran {

	public static void main(String[] args) {
		
		kullanıcılar k1 =new kullanıcılar("emirhan", "364742");
		kullanıcılar k2 =new kullanıcılar("veli", "1234");
		kullanıcılar k3 =new kullanıcılar("ceyhun", "5678");
		kullanıcılar k4 =new kullanıcılar("bedirhan", "91011");
		kullanıcılar k5 =new kullanıcılar("ayşenur", "1213");
		
		JFrame f= new JFrame();
		JLabel l1= new JLabel("kullanıcı adı");
		l1.setBounds(150,50, 200, 50);
		JTextField t1=new JTextField();
		t1.setBounds(150, 100, 200, 50);
		JLabel l2= new JLabel("şifre");
		l2.setBounds(150, 150, 200, 50);
		JPasswordField p1=new JPasswordField();
		
		p1.setBounds(150, 200, 200, 50);
		JButton b1= new JButton("giriş");
		b1.setBounds(150, 300, 75, 25);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass= new String(p1.getPassword());
				if((k3.name.equals(t1.getText())&& k3.pass.equals(pass))||(k1.name.equals(t1.getText())&& k1.pass.equals(pass))
						||(k2.name.equals(t1.getText())&& k2.pass.equals(pass))||(k4.name.equals(t1.getText())&& k4.pass.equals(pass))
						||(k5.name.equals(t1.getText())&& k5.pass.equals(pass))) {
					System.out.println("giriş yapıldı");
					t1.setText(null);
					p1.setText("");
					
					
				}
				else {
					System.out.println("yanlış kullanıcı adı veya sifresi girdiniz");
				}
			}
		});
		
		
		f.add(b1);
		f.add(p1);
		f.add(l2);
		f.add(t1);
		f.add(l1);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
	}   

}
