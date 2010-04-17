package symboltable;

import java.util.Hashtable;


public class Method {
	private String id;
	private String return_type;
			   // id     type
	private Hashtable<String, String> params;
	private Hashtable<String, String> locals;
	
	public Method(String id_, String return_type_){
		id = id_;
		return_type = return_type_;
		params = new Hashtable<String, String>();
		locals = new Hashtable<String, String>();
	}
	
	public boolean addParam(String id, String type){
		return params.put(id, type) != null;
	}
	
	public boolean addLocal(String id, String type){
		return locals.put(id, type) != null;
	}
	
	public String getId(){
		return id;
	}
	
	public String getType(){
		return return_type;
	}
}
