package symboltable;

import java.util.ArrayList;
import java.util.Hashtable;


public class Method {
	private String id;
	private String return_type;
			         // id     type
	private Hashtable<String, String> params;
	private ArrayList<String> param_types;
	private Hashtable<String, String> locals;
	
	public Method(String id_, String return_type_){
		id = id_;
		return_type = return_type_;
		params = new Hashtable<String, String>();
		param_types = new ArrayList<String>();
		locals = new Hashtable<String, String>();
	}
	
	public boolean addParam(String id, String type){
		if(params.put(id, type) == null){
			param_types.add(type);
			return true;
		}
		
		return false;
	}
	
	public boolean addLocal(String id, String type){
		return locals.put(id, type) != null;
	}
	
	public String getId(){
		return id;
	}
	
	public String getReturnType(){
		return return_type;
	}
	
	public String getLocalVariableType(String id){
		return locals.get(id);
	}
	
	public String getParameterType(String id){
		return params.get(id);
	}
	
	public String getParameterType(int order){
		return param_types.get(order);
	}

}
