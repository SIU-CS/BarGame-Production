import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameSave extends CharacterClasses implements java.io.Serializable { //try moving implementation of Serializable, including methods, to CharacterClasses super class, and/or try implementing interface in character superclass if issues are met
	
	private static final long serialVersionUID = 1L;
	
	public static void save(Serializable data, String fileName) throws Exception {
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
			oos.writeObject(data);
		}
	}
	
	public static Object load(String fileName) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}
/*	FileOutputStream fop = null;
	File file;
	
	try {
		file = new File("c:/newfile.txt");
		fop = new FileOutputStream(file);
	}
	
	if (!file.exists()) {
		file.createNewFile();
	}
	byte[] contentInBytes = level.getBytes();
	}
	public void saveToXML(String xml) {
		Document dom;
		Element e = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = (Document) db.newDocument();
			Element rootElement = (Element) ((org.w3c.dom.Document) dom).createElement("myparameters");
			e = (Element) ((org.w3c.dom.Document) dom).createElement("brightness");
			((Node) e).appendChild(((org.w3c.dom.Document) dom).createTextNode("brightness"));
			((Node) rootElement).appendChild((Node) e);
		}
	}*/
	
	
}
