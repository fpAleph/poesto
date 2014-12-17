package fpaleph.poesto.gui.infrastructure;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import fpaleph.poesto.data.SkillTree;

public class SkillTreeLayout implements LayoutManager2 {

	private SkillTree st;
	private Map<Component, SkillTreeConstraints> metadata;
	
	public SkillTreeLayout(SkillTree st) {
		this.st = st;
		this.metadata = new HashMap<>();
	}

	@Override
	public void addLayoutComponent(Component comp, Object constraints) {
		if (null == constraints) {
			throw new IllegalArgumentException();
		}
		metadata.put(comp, (SkillTreeConstraints) constraints);
	}

	@Override
	public void addLayoutComponent(String name, Component comp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getLayoutAlignmentX(Container target) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getLayoutAlignmentY(Container target) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void invalidateLayout(Container target) {
	}

	@Override
	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();
		
		int maxWidth = parent.getWidth() - (insets.left + insets.right);
		int maxHeight = parent.getHeight() - (insets.top + insets.bottom);

		// FIXME
		double originX = insets.left + maxWidth / 2.0;
		double originY = insets.right + maxHeight / 2.0;
		
		// FIXME
		double zoom = 0.1726;
		
		for (Component c : parent.getComponents()) {
			Dimension size = c.getPreferredSize();
			SkillTreeConstraints constraints = metadata.get(c);
			
			double x = originX + zoom * constraints.getX();
			double y = originY + zoom * constraints.getY();
			
			Rectangle r = new Rectangle((int) x, (int) y, size.width, size.height);
			c.setBounds(r);			
		}
		
		/*Insets insets = getInsets();
		
		double xOffset = (st.coordMax.x - (double) st.coordMin.x) / 2 - st.coordMax.x;
		double yOffset = (st.coordMax.y - (double) st.coordMin.y) / 2 - st.coordMax.y;
		
		int width = getWidth();
		int height = getHeight();
		
		Dimension size = jLabel.getPreferredSize();
		
		double xCoeff = (group.x + xOffset) / (st.coordMax.x + xOffset);
		double yCoeff = (group.y + yOffset) / (st.coordMax.y + yOffset);
		
		double xCenter = insets.left + width * (1 + xCoeff) / 2;
		double yCenter = insets.top + height * (1 + yCoeff) / 2;
		
		System.out.println(xCenter + "x" + yCenter);
		
		jLabel.setBounds((int) (xCenter - size.width / 2),
						 (int) (yCenter - size.height / 2),
						 (int) (xCenter + size.width / 2),
						 (int) (yCenter + size.height / 2));
		jLabel.repaint();
		jLabel.setVisible(true);
		jLabel.setOpaque(false);*/
		
	}

	@Override
	public Dimension maximumLayoutSize(Container target) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		metadata.remove(comp);
	}

}
