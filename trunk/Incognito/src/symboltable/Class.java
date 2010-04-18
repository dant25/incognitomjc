package symboltable;

import java.util.ArrayList;
import java.util.Hashtable;


public class Class{
	private String id;
	private Hashtable<String, String> fields;
	private ArrayList<Method> methods;
	private Method current_method;
	
	public Class(String id_){
		id = id_;
		fields = new Hashtable<String, String>();
		methods = new ArrayList<Method>();
	}
	
	public boolean addField(String id, String type){
		return fields.put(id, type) != null;
	}
	
	public boolean addMethods(Method method){
		for(int i = 0; i < methods.size(); i++){
			if(methods.get(i).getId().equals(method.getId()))
			{
				return false;
			}
		}
		
		methods.add(method);
		return true;
	}
	
	public String getId(){
		return id;
	}
	
	public Method getMethod(String method_name){
		for(int i = 0; i < methods.size(); i++){
			if(methods.get(i).getId().equals(method_name)){
				current_method = methods.get(i);
				return current_method;
			}
		}
		
		return null;
	}
	
	public String getFieldType(String id){
		return fields.get(id);
	}
}
