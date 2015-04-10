package GamePlayer;

public class GameInfo {
	private String name;
	private String imagefile;
	private String description;
	private String loadfile;
	public GameInfo(){
		
	}
	public void setName(String s){
		name = s;
	}
	
	public void setImage(String s){
		imagefile = s;
	}
	
	public void setDes(String s){
		description = s;
	}
	
	public void setLoadfile(String s){
		loadfile = s;
	}
	
	public String getName(){
		return name;
	}
	
	public String getImage(){
		return imagefile;
	}
	public String getDes(){
		return description;
	}
	public String getLoadfile(){
		return loadfile;
	}
}
