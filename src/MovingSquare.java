//John Pennell, jpen854

/*
 *	===============================================================================
 *	MovingSquare.java : A shape that is a Square.
 *	A Square has 4 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */

import java.awt.*;
public class MovingSquare extends MovingRectangle {

	/** constuctor to create a square with default values
	 * 
	 */
	public MovingSquare() {
		super();
	}

	/** constuctor to create a square shape
	 */
	public MovingSquare(int x, int y, int width, int height,  int mw, int mh, Color bc, float penWidth, int pathType) {
		super(x ,y ,width, height ,mw ,mh ,bc, penWidth, pathType);
	}

	public void drawHandles(Graphics g){
		if (isSelected() && (width > height)) {
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + height -2, p.y -2, 4, 4);
			g.fillRect(p.x -2, p.y + height -2, 4, 4);
			g.fillRect(p.x + height -2, p.y + height -2, 4, 4);
		}else if (isSelected() && (height > width)){
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + width -2, p.y  -2, 4, 4);
			g.fillRect(p.x -2, p.y + width -2, 4, 4);
			g.fillRect(p.x + width -2, p.y+ width -2, 4, 4);
		}
	}
	/** draw the square with the fill color
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke((float) penWidth));
		g2d.setPaint(borderColor);
		if (width>height){
			g2d.drawRect(p.x, p.y, height, height);
		}else{
			g2d.drawRect(p.x, p.y, width, width);
		}
		
		drawHandles(g);
	}

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}