import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Room implements GLEventListener {

	private GLU glu = new GLU();
	private float rotationAngle = 0.2f;
	private int furniRed;
	private int furniGreen;
	private int furniBlue;
	
	private int seatRed;
	private int seatGreen;
	private int seatBlue;
	
	private int roomRed;
	private int roomGreen;
	private int roomBlue;
	
	public Room(int furniRed, int furniGreen, int furniBlue, int seatRed, int seatGreen, int seatBlue) {
		super();
		this.furniRed = furniRed;
		this.furniGreen = furniGreen;
		this.furniBlue = furniBlue;
		this.seatRed = seatRed;
		this.seatGreen = seatGreen;
		this.seatBlue = seatBlue;
	}

	

	

	private void drawRoom(GL2 gl) {
		// Draw walls
		gl.glColor3f(0.1f, 0.7f, 0.1f); // Light gray color
		gl.glBegin(GL2.GL_QUADS);
		// Back wall
		gl.glVertex3f(-2.0f, -1.0f, -3.0f);
		gl.glVertex3f(2.0f, -1.0f, -3.0f);
		gl.glVertex3f(2.0f, 2.0f, -3.0f);
		gl.glVertex3f(-2.0f, 2.0f, -3.0f);
		gl.glEnd();

		// Draw floor
		gl.glColor3f(0.2f, 0.2f, 0.2f); // Gray color
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2.0f, -1.0f, 0.0f);
		gl.glVertex3f(2.0f, -1.0f, 0.0f);
		gl.glVertex3f(2.0f, -1.0f, -3.0f);
		gl.glVertex3f(-2.0f, -1.0f, -3.0f);
		gl.glEnd();

		// Draw ceiling
		gl.glColor3f(0.7f, 0.7f, 0.7f); // Light gray color
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2.0f, 2.0f, 0.0f);
		gl.glVertex3f(2.0f, 2.0f, 0.0f);
		gl.glVertex3f(2.0f, 2.0f, -3.0f);
		gl.glVertex3f(-2.0f, 2.0f, -3.0f);
		gl.glEnd();

		gl.glColor3f(0.2f, 0.7f, 0.2f); // Light gray color
		// Draw right wall
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-2.0f, -1.0f, 0.0f);
		gl.glVertex3f(-2.0f, -1.0f, -3.0f);
		gl.glVertex3f(-2.0f, 2.0f, -3.0f);
		gl.glVertex3f(-2.0f, 2.0f, 0.0f);
		gl.glEnd();

		gl.glColor3f(0.2f, 0.7f, 0.2f); // Light gray color
		// Draw left wall
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(2.0f, -1.0f, 0.0f);
		gl.glVertex3f(2.0f, -1.0f, -3.0f);
		gl.glVertex3f(2.0f, 2.0f, -3.0f);
		gl.glVertex3f(2.0f, 2.0f, 0.0f);
		gl.glEnd();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		drawRoom(gl);
		gl.glRotatef(rotationAngle, 0, 1, 0); // Rotate around the y-axis
		// Draw the chair components using the existing coordinates
		gl.glScalef(0.1f, 0.1f, 0.1f);
		if(FurnitureShowPage.furniture.getType() == "Table") {
			Table table = new Table(this.furniRed, this.furniGreen, this.furniBlue, this.seatRed, this.seatGreen, this.seatBlue);
			
			table.drawTableInRoom(gl);
		}else {
ChairWithBackRest chair = new ChairWithBackRest(this.furniRed, this.furniGreen, this.furniBlue, this.seatRed, this.seatGreen, this.seatBlue);
			
			chair.drawChairInRoom(gl);
		}
		
		
		rotationAngle += 0.5f;

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(90.0f, (float) width / (float) height, 0.1f, 100.0f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

}
