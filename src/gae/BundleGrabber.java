package gae;
import java.util.ResourceBundle;

public final class BundleGrabber {
	
	private static BundleGrabber instance;
		
	public BundleGrabber(){
		
	}
	
	protected static BundleGrabber getInstance() {
		if (instance == null)
			instance = new BundleGrabber();
		return instance;
	}
	
	public static ResourceBundle grabBundle(String folder, String file){
		return ResourceBundle.getBundle("resources/"+folder+"/"+file);
	}

}
