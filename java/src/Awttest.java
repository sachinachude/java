import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

class Awttest
{
	static int x1=0;
	static int x2=0;
	static int y1=0;
	static int y2=0;
	static Frame f;
	public static void main (String args[])
	{
	    Label axis=new Label("-------------");
	    TextField key=new TextField();
		f=new Frame("Mouse Co-ordinate");
		axis.setBounds(100, 100, 100, 100);
		key.setBounds(300,100, 200, 25);
		f.setLayout(null);
	    f.setBackground(Color.cyan);
		f.setSize(400, 400);
		f.add(axis);
		f.add(key);
		
		
		key.addKeyListener(new KeyListener()
				{

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
					key.setText(Character.toString( (char)((int)e.getKeyChar()-32)));
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						//axis.setText("Key=" +e.getKeyChar());
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						//axis.setText("Key=" +e.getKeyChar());
					}
			
				}
				);
		f.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
			
				});
		f.addMouseMotionListener(new MouseMotionListener()
				{

					@Override
					public void mouseDragged(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseMoved(MouseEvent e) {
						// TODO Auto-generated method stub
						axis.setText("x=" +e.getX() +" y=" +e.getY());
					}
				});
		f.addMouseListener(new MouseListener()
				{

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					axis.setText("Mouse Clicked");
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					axis.setText("Mouse Pressed");
					if(e.getButton()==3)
					{
						axis.setText("Right click not allowed");
					}
					x1=e.getX();
					y1=e.getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					axis.setText("Mouse Released");
					x2=e.getX();
					y2=e.getY();					
				Graphics g=f.getGraphics();
				Graphics2D gd=(Graphics2D) g;
				Line2D line=new Line2D.Float(x1, y1, x2, y2);
				gd.setColor(Color.PINK);
				gd.draw(line);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					axis.setText("Mouse Entered");
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					axis.setText("Mouse Exit");
				}
				});
	
		f.setVisible(true);
	}
	
}