package fpaleph.poesto.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fpaleph.poesto.data.SkillTree;

@SuppressWarnings("serial")
public class PoestoFrame extends JFrame {

	public PoestoFrame(SkillTree st, SkillTreePanel stp) {
		super("PoE Skill Tree Optimizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(Color.BLACK);
		this.add(sidePanel, BorderLayout.LINE_START);
		
		this.add(stp, BorderLayout.CENTER);
	}

	public static PoestoFrame load() {
		return load(SkillTree.load());
	}

	public static PoestoFrame load(SkillTree st) {
		return load(st, SkillTreePanel.load(st));
	}
	
	public static PoestoFrame load(SkillTree st, SkillTreePanel stp) {
		return new PoestoFrame(st, stp);
	}

}
