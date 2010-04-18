package visitor;


import symboltable.Method;
import symboltable.SymbolTable;
import symboltable.Class;
import syntaxtree.And;
import syntaxtree.ArrayAssign;
import syntaxtree.ArrayLength;
import syntaxtree.ArrayLookup;
import syntaxtree.Assign;
import syntaxtree.Block;
import syntaxtree.BooleanType;
import syntaxtree.Call;
import syntaxtree.ClassDeclExtends;
import syntaxtree.ClassDeclSimple;
import syntaxtree.False;
import syntaxtree.Formal;
import syntaxtree.Identifier;
import syntaxtree.IdentifierExp;
import syntaxtree.IdentifierType;
import syntaxtree.If;
import syntaxtree.IntArrayType;
import syntaxtree.IntegerLiteral;
import syntaxtree.IntegerType;
import syntaxtree.LessThan;
import syntaxtree.MainClass;
import syntaxtree.MethodDecl;
import syntaxtree.Minus;
import syntaxtree.NewArray;
import syntaxtree.NewObject;
import syntaxtree.Not;
import syntaxtree.Plus;
import syntaxtree.Print;
import syntaxtree.Program;
import syntaxtree.This;
import syntaxtree.Times;
import syntaxtree.True;
import syntaxtree.Type;
import syntaxtree.VarDecl;
import syntaxtree.While;

public class TypeCheckingVisitor implements TypeVisitor {
	private SymbolTable symbolTable;

	public void setSymbolTable(SymbolTable table) {
		symbolTable = table;
	}

	// MainClass m;
	// ClassDeclList cl;
	public Type visit(Program n) {
		n.m.accept(this);
		
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Type visit(MainClass n) {
		//n.i1.accept(this);
		//n.i2.accept(this);
		symbolTable.setCurrentClass(n.i1.s);
		symbolTable.setCurrentMethod("main");
		n.s.accept(this);
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclSimple n) {
		symbolTable.setCurrentClass(n.i.s);
		n.i.accept(this);
		
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclExtends n) {
		symbolTable.setCurrentClass(n.i.s);
		n.i.accept(this);
		n.j.accept(this);
		
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(VarDecl n) {
		n.t.accept(this);
		n.i.accept(this);
		return null;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public Type visit(MethodDecl n) {
		symbolTable.setCurrentMethod(n.i.s);
		//n.t.accept(this);
		//n.i.accept(this);
		
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		
		if(!(n.e.accept(this).toString().equals(n.t.toString()))){
			System.out.println("Erro! - Retorno não é do tipo " + n.t.toString());
		}
		
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(Formal n) {
		n.t.accept(this);
		n.i.accept(this);
		return null;
	}

	public Type visit(IntArrayType n) {
		return n;
	}

	public Type visit(BooleanType n) {
		return n;
	}

	public Type visit(IntegerType n) {
		return n;
	}

	// String s;
	public Type visit(IdentifierType n) {
		return n;
	}

	// StatementList sl;
	public Type visit(Block n) {
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		return null;
	}

	// Exp e;
	// Statement s1,s2;
	public Type visit(If n) {
		if(!(n.e.accept(this) instanceof BooleanType)){
			System.out.println("Erro! - Expressão não é do tipo boolean.");
		}
		n.s1.accept(this);
		n.s2.accept(this);
		return null;
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		if(!(n.e.accept(this) instanceof BooleanType)){
			System.out.println("Erro! - Expressão não é do tipo boolean.");
		}
		n.s.accept(this);
		return null;
	}

	// Exp e;
	public Type visit(Print n) {
		if(!(n.e.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão não é do tipo int.");
		}
		return null;
	}

	// Identifier i;
	// Exp e;
	public Type visit(Assign n) {
		if(n.i.accept(this) instanceof IntegerType){
			if(!(n.e.accept(this) instanceof IntegerType))
				System.out.println("Erro! - Expressão não é do tipo int.");
		}
		else if(n.i.accept(this) instanceof BooleanType){
			if(!(n.e.accept(this) instanceof BooleanType))
				System.out.println("Erro! - Expressão não é do tipo boolean.");
		}
		else if(n.i.accept(this) instanceof IdentifierType){
			if(!(n.e.accept(this) instanceof IdentifierType))
				System.out.println("Erro! - Os tipos não são compatíveis.");
			else{
			if(!(((IdentifierType)n.e.accept(this)).s.equals(((IdentifierType)n.i.accept(this)).s)))
				System.out.println("Erro! - Os tipos não são compatíveis.");
			}
		}

		return null;
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		if(!(n.i.accept(this) instanceof IntArrayType)){
			System.out.println("Erro! - " + n.i.s + " não é do tipo int[].");
		}
		else if(!(n.e1.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Índice não é do tipo int.");
		}
		else if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão não é do tipo int.");
		}
		
		return null;
	}

	// Exp e1,e2;
	public Type visit(And n) {
		if(!(n.e1.accept(this) instanceof BooleanType)){
			System.out.println("Erro! - Expressão deve ser do tipo boolenan.");
		}
		
		if(!(n.e2.accept(this) instanceof BooleanType)){
			System.out.println("Erro! - Expressão deve ser do tipo boolenan.");
		}

		return new BooleanType();
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		if(!(n.e1.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}
		
		if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}

		return new BooleanType();
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		if(!(n.e1.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}
		
		if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}

		return new IntegerType();
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		if(!(n.e1.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}
		
		if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}

		return new IntegerType();
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		if(!(n.e1.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}
		
		if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}

		return new IntegerType();
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		if(!(n.e1.accept(this) instanceof IntArrayType)){
			System.out.println("Erro! - Não é do tipo int[].");
		}

		if(!(n.e2.accept(this) instanceof IntegerType)){
			System.out.println("Erro! - Expressão deve ser do tipo int.");
		}
		
		return new IntegerType();
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		if(!(n.e.accept(this) instanceof IntArrayType)){
			System.out.println("Erro! - Não é do tipo int[]");
		}
		
		return new IntegerType();
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Type visit(Call n) {
		String class_name = null;
		Method method = null;
		Type type = n.e.accept(this);
		
		if(!(type instanceof IdentifierType)){
			System.out.println("Erro! - Expressão não é um objeto.");
		}
		else
		{
			class_name = ((IdentifierType)type).s;
			Class class_ = symbolTable.getClass(class_name);
			if(class_ == null){
				System.out.println("Erro! - " + class_name + " não existe.");
			}
			else
			{
				method = class_.getMethod(n.i.s);
				if(method == null){
					System.out.println("Erro! - Metodo " + n.i.s + " não existe na classe " + class_name + ".");
				}
				else{
					
					//n.i.accept(this);
					for (int i = 0; i < n.el.size(); i++) {
						if(! method.getParameterType(i).equals(n.el.elementAt(i).accept(this).toString())){
							System.out.println("Erro! - Lista de parâmetros não condiz com a assinatura do método.");
						}
					}
				}
			}
		}
	
		if(method.getReturnType().equals("int"))
			return new IntegerType();
		if(method.getReturnType().equals("int[]"))
			return new IntArrayType();
		if(method.getReturnType().equals("boolean"))
			return new BooleanType();
		else
			return new IdentifierType(method.getReturnType());
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return new IntegerType();
	}

	public Type visit(True n) {
		return new BooleanType();
	}

	public Type visit(False n) {
		return new BooleanType();
	}

	// String s;
	public Type visit(IdentifierExp n) {
		String type = symbolTable.getType(n.s);
		
		if(type.equals("int")){
			return new IntegerType();
		}
		if(type.equals("int[]")){
			return new IntArrayType();
		}
		if(type.equals("boolean")){
			return new BooleanType();
		}
		
		return new IdentifierType(type);
	}

	public Type visit(This n) {
		return new IdentifierType(symbolTable.getCurrentClassName());
	}

	// Exp e;
	public Type visit(NewArray n) {
		if(!(n.e.accept(this) instanceof IntegerType))
			System.out.println("Erro! - Expressão deve ser do tipo int.");
			
		return new IntArrayType();
	}

	// Identifier i;
	public Type visit(NewObject n) {
		return n.i.accept(this);
	}

	// Exp e;
	public Type visit(Not n) {
		if(!(n.e.accept(this) instanceof BooleanType)){
			System.out.println("Erro! - Expressão deve ser do tipo boolean.");		
		}
		
		return new BooleanType();
	}

	// String s;
	public Type visit(Identifier n) {
		String type = symbolTable.getType(n.s);
		
		if(type.equals("int")){
			return new IntegerType();
		}
		if(type.equals("int[]")){
			return new IntArrayType();
		}
		if(type.equals("boolean")){
			return new BooleanType();
		}
		
		return new IdentifierType(type);
	}
}
