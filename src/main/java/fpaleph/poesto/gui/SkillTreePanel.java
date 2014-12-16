package fpaleph.poesto.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SkillTreePanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static final int MAX_OFFSET_X = 200;
	private static final int MAX_OFFSET_Y = 200;

	private Point aa, bb, cc;
	private Paint paint;

	public SkillTreePanel() {
		aa = new Point(0, 0);
		bb = new Point(0, 0);

		// /home/alex/Workspaces/poesto.alpha/data/Background1.0.3835.png
		File f = new File("/home/alex/Workspaces/poesto.alpha/data/Background1.0.3835.png");
		try {
			BufferedImage bi = ImageIO.read(f);
			Rectangle2D tile = new Rectangle2D.Double(0, 0, bi.getWidth(), bi.getHeight());
			paint = new TexturePaint(bi, tile);
		} catch (IOException ex) {
			// do nothing, just have a gray background
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(aa.x + bb.x, aa.y + bb.y); // to shift the background
		g2d.setPaint(paint);
		g2d.fillRect(-MAX_OFFSET_X, -MAX_OFFSET_Y, getWidth() + 2 * MAX_OFFSET_X, getHeight() + 2 * MAX_OFFSET_Y);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		int x = Math.max(-MAX_OFFSET_X - aa.x, Math.min(MAX_OFFSET_X - aa.x, me.getPoint().x - cc.x));
		int y = Math.max(-MAX_OFFSET_Y - aa.y, Math.min(MAX_OFFSET_Y - aa.y, me.getPoint().y - cc.y));
		bb = new Point(x, y);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent me) {
		cc = me.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		aa = new Point(aa.x + bb.x, aa.y + bb.y);
		bb = new Point(0, 0);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent me) {
		// do nothing
	}

}
