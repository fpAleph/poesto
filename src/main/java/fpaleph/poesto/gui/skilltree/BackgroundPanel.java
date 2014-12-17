package fpaleph.poesto.gui.skilltree;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fpaleph.poesto.data.SkillTree;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	// FIXME
	private static double ZOOM = 0.1726;
	
	private Map<Double, Paint> backgrounds = new HashMap<>();
	private SkillTree st;
	
	public BackgroundPanel(SkillTree st) {
		setLayout(null);
		setOpaque(true);

		this.st = st;
		
		Paint p = null;
		File f = new File("/home/alex/Workspaces/poesto.alpha/data/Background1.0.3835.png");
		try {
			BufferedImage bi = ImageIO.read(f);
			Rectangle2D tile = new Rectangle2D.Double(0, 0, bi.getWidth(), bi.getHeight());
			p = new TexturePaint(bi, tile);
		} catch (IOException ex) {
			// do nothing, just have a gray background
		}
		
		backgrounds.put(ZOOM, p);
	}
	
	public static BackgroundPanel load(SkillTree st) {
		return new BackgroundPanel(st);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(backgrounds.get(ZOOM));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		System.out.println("Hello, world!");
	}
}
