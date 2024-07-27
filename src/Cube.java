


import com.jogamp.opengl.GL2;

public class Cube {

	public void drawCube(GL2 gl, float width, float height, float depth, float extraheight) {
		gl.glBegin(GL2.GL_QUADS);

		 
		 
	       // Front face
	       gl.glVertex3f(width / 2, height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, -height / 2, depth / 2);
	       gl.glVertex3f(width / 2, -height / 2, depth / 2);
	       
	      //Right Face
	       gl.glVertex3f(width / 2, height / 2, depth / 2);
	       gl.glVertex3f(width / 2, -height / 2, depth / 2);
	       gl.glVertex3f(width / 2, -height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(width / 2, height / 2+extraheight, -depth / 2);
	       
	       //Back Face
	       gl.glVertex3f(-width / 2, height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(width / 2, height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(width / 2, -height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(-width / 2, -height / 2+extraheight, -depth / 2);
	       
	       
	       // Left face
	       gl.glVertex3f(-width / 2, height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, -height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, -height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(-width / 2, height / 2+extraheight, -depth / 2);
	       
	       //Top Face
	       gl.glVertex3f(width / 2, height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(width / 2, height / 2+extraheight, -depth / 2);
	       
	       //Bottom Face
	       gl.glVertex3f(-width / 2, -height / 2, depth / 2);
	       gl.glVertex3f(width / 2, -height / 2, depth / 2);
	       gl.glVertex3f(-width / 2, -height / 2+extraheight, -depth / 2);
	       gl.glVertex3f(width / 2, -height / 2+extraheight, -depth / 2);
	       
	       gl.glEnd();
	      
	   }

	   

  
   
	
}