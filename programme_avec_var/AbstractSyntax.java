import java.util.*;

abstract class Expression {
/*    abstract int eval(ValueEnvironment env)
    throws Exception; */
}
class Int extends Expression {
	private int value;
	public Int(int i) {
		value = i;
	}
}
class Var extends Expression {
	private String name;
	public Var(String s) {
		name = s;
	}
}
class Sum extends Expression {
	private Expression left, right;
	public Sum(Expression l, Expression r) {
		left = l;
		right = r;
	}
}
class Difference extends Expression {
	private Expression left, right;
	public Difference(Expression l, Expression r) {
		left = l;
		right = r;
	}
}
class Product extends Expression {
	private Expression left, right;
	public Product(Expression l, Expression r) {
		left = l;
		right = r;
	}
}
class Division extends Expression {
	private Expression left, right;
	public Division(Expression l, Expression r) {
		left = l;
		right = r;
	}
}

class Program {
	private Instruction first;
	private Program rest;
	public Program(Instruction i, Program p) {
		first = i;
		rest = p;
	}
	public void run(ValueEnvironment env)
	throws Exception {
		if (first != null) {
			first.exec(env);
			rest.run(env);
		}
	} 
}

abstract class Instruction {
	abstract void exec(ValueEnvironment env)
	throws Exception;
}
class Declaration extends Instruction {
	private String varName;
	public Declaration(String s) {
		varName = s;
	}
	public void exec(ValueEnvironment env) 
	throws Exception {
		// Complétez ici...
	} 
}
class Assignment extends Instruction {
	private String varName;
	private Expression exp;
	public Assignment(String s, Expression e) {
		varName = s;
		exp = e;
	}
	public void exec(ValueEnvironment env)
	throws Exception {
		// Complétez ici...
	}
}
class Print extends Instruction {
	private Expression exp;
	public Print(Expression e) {
		exp = e;
	}
	public void exec(ValueEnvironment env) 
	throws Exception {
		// Complétez ici...
	}
}
class Loop extends Instruction {
	private Expression exp;
	private Program prog;
	public Loop(Expression e, Program p) {
		exp = e;
		prog = p;
	}
	public void exec(ValueEnvironment env)
	throws Exception {
		// Complétez ici...
	}
}

class ValueEnvironment extends HashMap<String, Integer> {
	public ValueEnvironment() {
		// Completez ici...
	}
	public void addVariable(String name) 
	throws Exception {
		// Completez ici...
	}
	public void setVariable(String name, int value) 
	throws Exception {
		// Completez ici...
	}
	public int getValue(String name) 
	throws Exception {
		// Completez ici...
		return 0;
	}
}
