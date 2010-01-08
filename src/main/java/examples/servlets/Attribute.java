package examples.servlets;

import java.io.Serializable;

/**
 * Class to be used as an attribute in the different scopes in a web application
 * @author marco.delgado
 */
public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 5438973341963213872L;
	
	private String name;
	private String value;
	
	public Attribute(){
		
	}
	
	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Attribute [name=" + name + ", value=" + value + "]";
	}
}
