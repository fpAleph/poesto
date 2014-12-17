package fpaleph.poesto.gui.infrastructure;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/**
 * This LayoutManager forces all its Components to fill the parent Container
 * completely. It has been designed for use with a JLayeredPane.
 * 
 * @author fpAleph
 * @see javax.swing.JLayeredPane
 */
public class LayeredLayout implements LayoutManager {

	/*
	 * ignored
	 * 
	 * @see java.awt.LayoutManager#addLayoutComponent(java.lang.String,
	 * java.awt.Component)
	 */
	@Override
	public void addLayoutComponent(String name, Component comp) {
		// Required by LayoutManager
	}

	/*
	 * ignored
	 * 
	 * @see java.awt.LayoutManager#removeLayoutComponent(java.awt.Component)
	 */
	@Override
	public void removeLayoutComponent(Component comp) {
		// Required by LayoutManager
	}

	/*
	 * same as parent
	 * 
	 * @see java.awt.LayoutManager#preferredLayoutSize(java.awt.Container)
	 */
	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return parent.getPreferredSize();
	}

	/*
	 * same as parent
	 * 
	 * @see java.awt.LayoutManager#minimumLayoutSize(java.awt.Container)
	 */
	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return parent.getMinimumSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.LayoutManager#layoutContainer(java.awt.Container)
	 */
	@Override
	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();

		int maxWidth = parent.getWidth() - (insets.left + insets.right);
		int maxHeight = parent.getHeight() - (insets.top + insets.bottom);

		for (Component c : parent.getComponents()) {
			if (! c.isVisible()) {
				continue;
			}
			
			c.setBounds(0, 0, maxWidth, maxHeight);
		}
	}

}
