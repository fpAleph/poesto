package fpaleph.poesto;

import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SkillTree implements Serializable {

	/**
	 * Automatically generated serial version UID.
	 */
	private static final long serialVersionUID = -5577555860735908865L;
	
	/*-
	 * The following elements of the json format are still being ignored:
	 * 	constants->PSSCenterInnerRadius
	 * 	constants->characterAttributes
	 *  groups->*->oo
	 *      5 is not set for any node group...
	 *      6-9 are mysterious...
	 *  nodes->*->da
	 *  nodes->*->ia
	 *  nodes->*->sa
	 *  	these are redundant with better effect tracking
	 * 	root
	 */

	// assets, imageRoot, imageZoomLevels, skillSprites

	// characterData, constants*, nodes*
	public Map<Integer, ClassAttributes> classAttributes = new HashMap<>();

	// min_x, min_y
	public Point displayMinimum = null;

	// max_x, max_y
	public Point displayMaximum = null;

	// groups
	public Map<Integer, NodeGroup> nodeGroups = new HashMap<>();

	// nodes // oidx -> the hour of the clock the node points to
	public Map<Integer, Node> nodes = new HashMap<>();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("classes=").append(classAttributes).append("\n");
		sb.append("display=").append(displayMinimum).append("-").append(displayMaximum).append("\n");
		sb.append("groups=").append(nodeGroups.size()).append("\n");
		sb.append("nodes=").append(nodes.size()).append("\n");
		return sb.toString();
	}

}
