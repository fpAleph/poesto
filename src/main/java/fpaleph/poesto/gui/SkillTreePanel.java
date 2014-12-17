package fpaleph.poesto.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import fpaleph.poesto.data.SkillTree;

@SuppressWarnings(value = "serial")
public class SkillTreePanel extends JPanel {

	public SkillTreePanel(SkillTree st, SkillTreeLayeredPane stlp) {
		// TODO do we need double buffering? // super(true);
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		this.add(stlp);
	}
	
	public static SkillTreePanel load(SkillTree st) {
		return load(st, SkillTreeLayeredPane.load(st));
	}
	
	public static SkillTreePanel load(SkillTree st, SkillTreeLayeredPane stlp) {
		return new SkillTreePanel(st, stlp);
	}
	
}
