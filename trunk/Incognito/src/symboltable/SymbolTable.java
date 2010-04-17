package symboltable;

import java.util.ArrayList;
import java.util.Map;



public class SymbolTable {
	ArrayList<Class> classes;
	
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
}
