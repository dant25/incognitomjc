package symboltable;

import java.util.ArrayList;
import java.util.Map;



public class SymbolTable {
	private ArrayList<Class> classes;
	private Class current_class;
	private Method current_method;
	
	public SymbolTable(){
		classes = new ArrayList<Class>();
	}
	
	public boolean addClass(Class class_){
		for(int i = 0; i < classes.size(); i++){
			if(classes.get(i).getId().equals(class_.getId()))
			{
				return false;
			}
		}
		
		classes.add(class_);
		return true;
	}
	
	public Class getClass(String class_name){
		for(int i=0; i<classes.size(); i++){
			if(classes.get(i).getId().equals(class_name)){
				current_class = classes.get(i);
				return current_class;
			}
		}
		
		return null;
	}
	
	public Method getMethod(String method_name){
		return current_class.getMethod(method_name);
	}
	
	public void setCurrentClass(String class_name){
		for(int i=0; i<classes.size(); i++){
			if(classes.get(i).getId().equals(class_name)){
				current_class = classes.get(i);
				return;
			}
		}
	}
	
	public void setCurrentMethod(String method_name){
		current_method = current_class.getMethod(method_name);
	}
	
	public String getType(String id){
		if(current_method.getLocalVariableType(id) != null){
			return current_method.getLocalVariableType(id);
		}
		else if(current_method.getParameterType(id) != null){
			return current_method.getParameterType(id);
		}
		else if(current_class.getFieldType(id) != null){
			return current_class.getFieldType(id);
		}
		else{
			Class class_ = getClass(id);
			if(class_ != null){
				return class_.getId();
			}
		}
		return null;
	}
	
	public String getCurrentClassName(){
		return current_class.getId();
	}
}
