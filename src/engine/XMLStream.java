package engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLStream {
	private Tower tow = new Tower();
	private XStream xs = new XStream(new DomDriver());
	private List<Integer> li = new ArrayList<Integer>();
	private Point2D p = new Point2D();
	static final String IMAGE_ID = "tower.jpg";
	
	
	private Object toXML(){
		li.add(1);
		p.setLocation(0, 0);
		
		tow.init("basic", IMAGE_ID, li, 5, 5, 5, 1, p);
		if (tow != null){
			System.out.println(xs.toXML(tow));
		}
		String s = xs.toXML(tow);
		return xs.fromXML(s);
		
	}
	
	public static void main(String[] args){
		XMLStream x = new XMLStream();
		System.out.println(x.toXML())
		;
	}
	
}
