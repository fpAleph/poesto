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
		return 0.5f;
	}

	@Override
	public float getLayoutAlignmentY(Container target) {
		return 0.5f;
	}

	@Override
	public void invalidateLayout(Container target) {
		System.out.println("invalidateLayout:" + target);
		target.validate();
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
	}

	@Override
	public Dimension maximumLayoutSize(Container target) {
		Rectangle r = target.getBounds();
		System.out.println(r);
		return new Dimension(r.width, r.height);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		Rectangle r = parent.getBounds();
		System.out.println(r);
		return new Dimension(r.width, r.height);
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		Rectangle r = parent.getBounds();
		System.out.println(r);
		return new Dimension(r.width, r.height);
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		metadata.remove(comp);
	}

}
