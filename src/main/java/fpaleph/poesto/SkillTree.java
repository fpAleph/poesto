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
	 * The following elements of the json schema are still not understood:
	 * 	constants->PSSCenterInnerRadius
	 *  groups->*->oo
	 *      5 is not set for any node group...
	 *      6-9 are mysterious...
	 */

	// assets, imageRoot, imageZoomLevels, skillSprites

	// characterData, constants*, nodes*
	public Map<Integer, Character> characters = new HashMap<>();

	// min_x, min_y
	public Point coordMin = null;

	// max_x, max_y
	public Point coordMax = null;

	// groups
	public Map<Integer, NodeGroup> nodeGroups = new HashMap<>();

	// nodes // oidx -> the hour of the clock the node points to
	public Map<Integer, Node> nodes = new HashMap<>();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("characters=").append(characters).append("\n");
		sb.append("coords=").append(coordMin).append("-").append(coordMax).append("\n");
		sb.append("groups=").append(nodeGroups.size()).append("\n");
		sb.append("nodes=").append(nodes.size()).append("\n");
		return sb.toString();
	}

}
