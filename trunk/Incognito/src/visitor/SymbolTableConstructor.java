package visitor;

import syntaxtree.*;
import symboltable.Class;
import symboltable.Method;
import symboltable.SymbolTable;

public class SymbolTableConstructor implements Visitor {
	private SymbolTable symbol_table;
	private Class current_class;
	private Method current_method;

	public SymbolTable getSymbolTable() {
		return symbol_table;
	}

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		symbol_table = new SymbolTable();
		
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
			/*
			Class class_;
			
			if(n.cl.elementAt(i) instanceof ClassDeclSimple){
				ClassDeclSimple class_simple = (ClassDeclSimple)n.cl.elementAt(i);
				
				class_ = new Class(class_simple.i.s);
				
				for(int j = 0; j < class_simple.vl.size(); j++){
					class_.addField(class_simple.vl.elementAt(j).i.s, class_simple.vl.elementAt(j).t.toString());
				}
				
				for(int j = 0; j < class_simple.ml.size(); j++){
					Method method = new Method
				}
				
				Method method = new Method("main", "void");
				method.addParam(id, "")
				symbol_table.addClass(class_);
			}
			else{
				class_ = new Class(((ClassDeclExtends)n.cl.elementAt(i)).i.s);
			}
			
			Method method = new Method("main", "void");
			method.addParam(id, "")
			symbol_table.addClass(class_);
			
			n.cl.elementAt(i).accept(this);
			*/
		}
		/*
	    n.m.accept(this);
	    for ( int i = 0; i < n.cl.size(); i++ ) {
	        n.cl.elementAt(i).accept(this);
	    }
	    return null;
	    */
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		current_class = new Class(n.i1.s);
		current_method = new Method("main", "void");
		current_method.addParam(n.i2.s, "String[]");
		
		//n.s.accept(this); // Não tem declaração de variávem em Statment
		current_class.addMethods(current_method);
		symbol_table.addClass(current_class);
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		current_class = new Class(n.i.s);
		
		for (int i = 0; i < n.vl.size(); i++) {
			//n.vl.elementAt(i).accept(this);
			current_class.addField(n.vl.elementAt(i).i.s, n.vl.elementAt(i).t.toString());
		}
		
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
			current_class.addMethods(current_method);
		}
		
		symbol_table.addClass(current_class);
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		current_class = new Class(n.i.s);
		
		for (int i = 0; i < n.vl.size(); i++) {
			//n.vl.elementAt(i).accept(this);
			current_class.addField(n.vl.elementAt(i).i.s, n.vl.elementAt(i).t.toString());
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
			current_class.addMethods(current_method);
		}
		
		symbol_table.addClass(current_class);
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		current_method = new Method(n.i.s, n.t.toString());
		
		for (int i = 0; i < n.fl.size(); i++) {
			//n.fl.elementAt(i).accept(this);
			current_method.addParam(n.fl.elementAt(i).i.s, n.fl.elementAt(i).t.toString());
		}
		for (int i = 0; i < n.vl.size(); i++) {
			//n.vl.elementAt(i).accept(this);
			current_method.addLocal(n.vl.elementAt(i).i.s, n.vl.elementAt(i).t.toString());
		}
		/*
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		*/
		//n.e.accept(this);
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		//n.t.accept(this);
		//n.i.accept(this);
	}

	public void visit(IntArrayType n) {
	}

	public void visit(BooleanType n) {
	}

	public void visit(IntegerType n) {
	}

	// String s;
	public void visit(IdentifierType n) {
	}

	// StatementList sl;
	public void visit(Block n) {
		/*
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		*/
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		/*
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
		*/
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		/*
		n.e.accept(this);
		n.s.accept(this);
		*/
	}

	// Exp e;
	public void visit(Print n) {
		/*
		n.e.accept(this);
		*/
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		/*
		n.i.accept(this);
		n.e.accept(this);
		*/
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		/*
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(And n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(Times n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		/*
		n.e1.accept(this);
		n.e2.accept(this);
		*/
	}

	// Exp e;
	public void visit(ArrayLength n) {
		/*
		n.e.accept(this);
		*/
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		/*
		n.e.accept(this);
		n.i.accept(this);
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).accept(this);
		}
		*/
	}

	// int i;
	public void visit(IntegerLiteral n) {
	}

	public void visit(True n) {
	}

	public void visit(False n) {
	}

	// String s;
	public void visit(IdentifierExp n) {
	}

	public void visit(This n) {
	}

	// Exp e;
	public void visit(NewArray n) {
		n.e.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
	}

	// Exp e;
	public void visit(Not n) {
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
	}
}
