package fpaleph.poesto.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public MainFrame() {
		Container pane = getContentPane();
		BorderLayout bl = new BorderLayout();
		pane.setLayout(bl);

		SkillTreePanel skillTreePane = new SkillTreePanel();
		addMouseListener(skillTreePane);
		addMouseMotionListener(skillTreePane);
		skillTreePane.setOpaque(false);
		pane.add(skillTreePane);

		setTitle("PoE Skill Tree Optimizer");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
