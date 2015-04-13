package gae;

import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class BundleGrabber.
 */
public final class BundleGrabber {

	/** The instance. */
	private static BundleGrabber instance;

	/**
	 * Instantiates a new bundle grabber.
	 */
	public BundleGrabber() {

	}

	/**
	 * Gets the single instance of BundleGrabber.
	 *
	 * @return single instance of BundleGrabber
	 */
	protected static BundleGrabber getInstance() {
		if (instance == null)
			instance = new BundleGrabber();
		return instance;
	}

	/**
	 * Grab bundle.
	 *
	 * @param folder the folder
	 * @param file the file
	 * @return the resource bundle
	 */
	public static ResourceBundle grabBundle(String folder, String file) {
		return ResourceBundle.getBundle("resources/" + folder + "/" + file);
	}

}
