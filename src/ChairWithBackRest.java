
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class ChairWithBackRest implements GLEventListener {

	private GLU glu = new GLU();
	private int furniRed;
	private int furniBlue;
	private int furniGreen;
	private int seatRed;
	private int seatBlue;
	private int seatGreen;
	

	public int getFurniRed() {
		return furniRed;
	}

	public void setFurniRed(int furniRed) {
		this.furniRed = furniRed;
	}

	public int getFurniBlue() {
		return furniBlue;
	}

	public void setFurniBlue(int furniBlue) {
		this.furniBlue = furniBlue;
	}

	public int getFurniGreen() {
		return furniGreen;
	}

	public void setFurniGreen(int furniGreen) {
		this.furniGreen = furniGreen;
	}

	public int getSeatRed() {
		return seatRed;
	}

	public void setSeatRed(int seatRed) {
		this.seatRed = seatRed;
	}

	public int getSeatBlue() {
		return seatBlue;
	}

	public void setSeatBlue(int seatBlue) {
		this.seatBlue = seatBlue;
	}

	public int getSeatGreen() {
		return seatGreen;
	}

	public void setSeatGreen(int seatGreen) {
		this.seatGreen = seatGreen;
	}
	
	

	public ChairWithBackRest(int furniRed, int furniGreen, int furniBlue, int seatRed, int seatGreen,
			int seatBlue) {
		this.setFurniRed(furniRed);
		this.setFurniBlue(furniBlue);
		this.setFurniGreen(furniGreen);
		this.setSeatRed(seatRed);
		this.setSeatBlue(seatBlue);
		this.setSeatGreen(seatGreen);
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
		drawChair(gl);

		

	}
	
	public void drawChair(GL2 gl) {
		Cube cube = new Cube();
		// Draw chair components
		gl.glColor3f(covertRGBtoGLFloat(furniRed), covertRGBtoGLFloat(furniGreen), covertRGBtoGLFloat(furniBlue));
		gl.glTranslatef(-2.0f, -0.1f, -7.0f);
		cube.drawCube(gl, 0.1f, 1.62f, 0.2f, 0.0f); // Leg 1

	
		gl.glTranslatef(1.2f, 0.0f, 0.0f);
		cube.drawCube(gl, 0.1f, 1.62f, 0.2f, 0.0f); // Leg 2

	
		gl.glTranslatef(-0.2f, 0.3f, -5.0f);
		cube.drawCube(gl, 0.2f, 2.2f, 0.2f, 0.0f); // Leg 3

		
		gl.glTranslatef(-2.0f, 0.0f, 0.0f);
		cube.drawCube(gl, 0.2f, 2.2f, 0.2f, 0.0f); // Leg 4

		gl.glColor3f(covertRGBtoGLFloat(seatRed), covertRGBtoGLFloat(seatGreen), covertRGBtoGLFloat(seatBlue));
		gl.glTranslatef(1.3f, 0.8f, 2.1f);
		cube.drawCube(gl, 2.0f, 0.2f, 2.0f, 0.4f); // seat

		gl.glColor3f(covertRGBtoGLFloat(furniRed), covertRGBtoGLFloat(furniGreen), covertRGBtoGLFloat(furniBlue));
		gl.glTranslatef(-5.0f, 5.6f, -20.0f);
		cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest

		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
		gl.glTranslatef(1.5f, 0.0f, 0.0f);
		cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
		gl.glTranslatef(-2.2f, 2.5f, 0.0f);
		cube.drawCube(gl, 4.9f, 0.3f, 0.2f, 0.0f); // Backrest
	}

	public void drawChairInRoom(GL2 gl) {
	    Cube cube = new Cube();

	    // Set chair position relative to room
	    gl.glPushMatrix(); // Save current matrix state
	    gl.glTranslatef(0.0f, -0.5f, -1.5f); // Translate to room center
	   
		

	    // Draw chair components
	    gl.glColor3f(covertRGBtoGLFloat(furniRed), covertRGBtoGLFloat(furniGreen), covertRGBtoGLFloat(furniBlue));
	    gl.glTranslatef(-1.0f, -0.1f, -0.5f); // Position chair
	    cube.drawCube(gl, 0.1f, 1.0f, 0.2f, 0.0f); // Leg 1

	    gl.glTranslatef(0.7f, 0.0f, 0.0f);
	    cube.drawCube(gl, 0.1f, 1.0f, 0.2f, 0.0f); // Leg 2

	    gl.glTranslatef(-0.0f, 0.1f, -2.0f);
	    cube.drawCube(gl, 0.2f, 1.8f, 0.2f, 0.0f); // Leg 3

	    gl.glTranslatef(-1.2f, 0.0f, 0.0f);
	    cube.drawCube(gl, 0.2f, 1.8f, 0.2f, 0.0f); // Leg 4

	    gl.glColor3f(covertRGBtoGLFloat(seatRed), covertRGBtoGLFloat(seatGreen), covertRGBtoGLFloat(seatBlue));
	    gl.glTranslatef(0.8f, 0.47f, 1.2f);
	    cube.drawCube(gl, 1.5f, 0.2f, 1.0f, 0.4f); // seat

	    gl.glColor3f(covertRGBtoGLFloat(furniRed), covertRGBtoGLFloat(furniGreen), covertRGBtoGLFloat(furniBlue));
	    gl.glTranslatef(-4.5f, 4.2f, -10.0f);
	    cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest

	    gl.glTranslatef(1.5f, 0.0f, 0.0f);
	    cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
	    gl.glTranslatef(1.5f, 0.0f, 0.0f);
	    cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
	    gl.glTranslatef(1.5f, 0.0f, 0.0f);
	    cube.drawCube(gl, 0.5f, 5.0f, 0.1f, 0.0f); // Backrest
	    gl.glTranslatef(-2.2f, 2.5f, 0.0f);
	    cube.drawCube(gl, 4.9f, 0.3f, 0.2f, 0.0f); // Backrest

	    gl.glPopMatrix(); // Restore previous matrix state
	}

	
	public float covertRGBtoGLFloat(int color) {
		float fCol = color/255f;
		return fCol;
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, (float) width / (float) height, 0.1f, 100.0f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}

}
