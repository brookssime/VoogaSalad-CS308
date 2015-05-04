// This entire file is part of my masterpiece.
// Fangyi Chen
package player.manager;

/**
 * manage the transmission between node
 * @author fangyichen
 *
 */
public interface NodeManager {
	/**
	 * @param NodeID
	 * tell controller which node the user want to go
	 */

	public void moveToNode(String NodeID);
}
