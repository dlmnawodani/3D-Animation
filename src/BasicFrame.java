
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.opengl.GLWindow;

public class BasicFrame implements GLEventListener{
	private GLWindow window;
	private Animator anim;
	private static final int WINDOW_WIDTH = 1500;
    private static final int WINDOW_HEIGHT = 700;
    public static JFrame frame = new JFrame("Furniture Store");
    public static Dashboard dash;
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
     
     // The GLJpanel class
     
   SwingUtilities.invokeLater(() -> {
      
       frame.setLayout(new BorderLayout(0, 0));
       
       dash = new Dashboard();
       JPanel panel = dash.designTopPanel();
       panel.setSize(WINDOW_WIDTH, 100);
       
       JPanel panel1 = dash.getBottomPanel();
       
	   frame.add(panel, BorderLayout.NORTH);
       frame.getContentPane().add(panel1, BorderLayout.CENTER);
       
       frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       final FPSAnimator animator = new FPSAnimator(300,true);		
       animator.start();
   });

	      
	}
	

public BasicFrame() {

	}
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	


}
