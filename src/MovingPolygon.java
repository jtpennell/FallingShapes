//John Pennell, jpen854


import java.awt.*;
public class MovingPolygon extends MovingRectangle {
	/** constuctor to create a shape with default values
	 * 
	 */
	public MovingPolygon() {
		super();
	}

	/** constuctor to create a  shape
	 */
	public MovingPolygon(int x, int y, int width, int height,  int mw, int mh, Color bc, float penWidth, int pathType) {
		super(x ,y ,width, height ,mw ,mh ,bc, penWidth, pathType);
	}
	public void drawHandles(Graphics g){
		if (isSelected() && (width > height)) {
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + (height/2) -2, p.y + (height/3) -2, 4, 4);
			g.fillRect(p.x + height -2, p.y -2, 4, 4);
			g.fillRect(p.x + (height/2) -2, p.y + (height) -2, 4, 4);
		}else if (isSelected() && (height > width)){
			g.setColor(Color.black);
			g.fillRect(p.x -2, p.y-2, 4, 4);
			g.fillRect(p.x + (width/2) -2, p.y + (width/3) -2, 4, 4);
			g.fillRect(p.x + width -2, p.y -2, 4, 4);
			g.fillRect(p.x + (width/2) -2, p.y + (width) -2, 4, 4);
		}
	}

	/** draw the shape with the fill color
	 *	If it is selected, draw the handles
	 *	@param g the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke((float) penWidth));
		g2d.setPaint(borderColor);
		if (width<height){
			g2d.drawPolygon(new int[]{p.x,p.x + (width / 2),p.x + width, p.x + (width/2)}, new int[] {p.y,p.y + (width/3),p.y,p.y + width},4);
		}else{
			g2d.drawPolygon(new int[]{p.x,p.x + (height/2),p.x + height, p.x + (height/2)}, new int[] {p.y,p.y+(height/3),p.y,p.y + height},4);

		}
		drawHandles(g);
	}

	/** Returns whether the point is in the shape or not
	 * @return true if and only if the point is in the shape, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}