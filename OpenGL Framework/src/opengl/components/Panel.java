/**
 * 
 */
package opengl.components;

import java.io.IOException;

import opengl.Window;
import opengl.math.Vector2d;
import opengl.rendering.RenderUtil;
import opengl.textures.Texture;
import opengl.textures.TextureAtlas;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Linus Vogel <linvogel@student.ethz.ch>
 *
 */
public class Panel extends Container {
	
	private Vector2d position;
	private Vector2d dimension;
	Texture t, t1, t2, t3, t4;
	TextureAtlas atlas;
	
	public Panel() {
		this(0, 0, 0, 0);
	}
	
	public Panel(double x, double y) {
		this(x, y, 0, 0);
	}
	
	public Panel(double x, double y, double w, double h) {
		position = new Vector2d(x, y);
		dimension = new Vector2d(w, h);
		try {
			atlas = Window.textures;
			t = new Texture("smile.png", atlas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void renderSelf(Window window) {
		
		if (!atlas.isBound()) atlas.bind();

		double x1 = t.getX1d();
		double x2 = t.getX2d();
		double y1 = t.getY1d();
		double y2 = t.getY2d();
		
		glBegin(GL_QUADS);
			glTexCoord2d(x1, y1);
			//glColor4d(1, 0, 0, 1);
			glVertex2f(-0.5f, 0.5f);
			glTexCoord2d(x2, y1);
			//glColor4d(0, 1, 0, 1);
			glVertex2f(0.5f, 0.5f);
			glTexCoord2d(x2, y2);
			//glColor4d(0, 0, 1, 1);
			glVertex2f(0.5f, -0.5f);
			glTexCoord2d(x1, y2);
			//glColor4d(1, 1, 1, 1);
			glVertex2d(-0.5f, -0.5f);
		glEnd();
		
		RenderUtil.renderText(-0.5f, 0f, window.getFontLibrary().activeFonts.get(0), "Hello World!");
		
	}

	@Override
	public void update() {
		
	}
	
	
	
}
