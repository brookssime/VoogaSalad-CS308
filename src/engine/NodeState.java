package engine;

public enum NodeState {
	ENEMIES_DEAD, BASE_DEAD, TIME_UP, RUNNING, COMPLETE;

	
	/**
	 * This method is used by the authoring environment to pull any NodeStates added to the engine class.
	 * Authoring Environment uses it to turn enums into a list of strings which can be used to populate 
	 * a ListView so that the game designer may specify what states have what actions. 
	 * 
	 * Credit for this code: 
	 * http://stackoverflow.com/questions/13783295/getting-all-names-in-an-enum-as-a-string
	 * @return array of the above enums as strings
	 */
	public static String[] names() {
	    NodeState[] states = values();
	    String[] names = new String[states.length];

	    for (int i = 0; i < states.length; i++) {
	        names[i] = states[i].name();
	    }
	    return names;
	}
	
}
