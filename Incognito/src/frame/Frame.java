package frame;

import java.util.LinkedList;
import java.util.List;
import temp.Label;


public abstract class Frame {
	public Label name;
	public LinkedList<Access> formals;
	
	abstract public Frame newFrame(Label name, List<Boolean> formals);
	abstract public Access allocLocal(boolean escape);
	
	/* ... other stuff, eventually ... */
}
