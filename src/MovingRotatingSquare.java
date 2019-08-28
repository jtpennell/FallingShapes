//John Pennell, jpen854

import java.awt.*;
public class MovingRotatingSquare extends MovingSquare {
	/** constuctor to create a rectangle with default values
	 * 
	 */
	private static int i = 5;
	public MovingRotatingSquare() {
		super();
	}

	/** constuctor to create a rectangle shape
	 */
	public MovingRotatingSquare(int x, int y, int width, int height,  int mw, int mh, Color bc, float penWidth, int pathType) {
		super(x ,y ,width, height ,mw ,mh ,bc, penWidth, pathType);
	}

	/** draw the rectangle with the fill color
	 *	If it is selected, draw the handles
	 *	@param g	the Graphics control
	 */
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke((float) penWidth));
		g2d.setPaint(borderColor);
     	g2d.rotate(Math.toRadians(i), p.x  , p.y );
 		if (width>height){
			g2d.drawRect(p.x, p.y, height, height);

		}else{
			g2d.drawRect(p.x, p.y, width, width);
		}	
		drawHandles(g);
		i = i + 5;
	}

	/** Returns whether the point is in the rectangle or not
	 * @return true if and only if the point is in the rectangle, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}