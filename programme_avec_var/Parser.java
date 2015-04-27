import java.io.*;
import java.util.*;

class Parser {
	/*
	 * Code -> Prog$
     * Prog -> e | Inst Prog
     * Inst -> VAR var; | var = Exp; | PRINT Exp; | FOR Exp TIMESDO {Prog}
	 * Exp -> int | var | (Exp ExpSuite)
     * ExpSuite -> + Exp | - Exp | * Exp | / Exp
	 */
    protected LookAhead1 reader;

    public Parser(LookAhead1 r) {
	   reader = r;
    }

    public Program nontermCode() throws Exception {
        Program prog = nontermProg();
        reader.eat(Sym.EOF);
        return prog;
    }

	public Program nontermProg() throws Exception {
		if(reader.check(Sym.VAR)||reader.check(Sym.VARIABLE)||
			reader.check(Sym.PRINT)||reader.check(Sym.FOR)){
			Instruction instr = nontermInstr();
			Program prog = nontermProg();
			return new Program(instr, prog);
		} else {
			if(reader.check(Sym.EOF)||reader.check(Sym.RACC)){
				return null;
			} else {
				throw new Exception();
			}
		}
	}
	
	//Inst -> VAR var; | var = Exp; | PRINT Exp; | FOR Exp TIMESDO {Prog}
	public Instruction nontermInstr() throws Exception {
		if(reader.check(Sym.VAR)){
			term(Sym.VAR);
			String nomVar = reader.getStringValue();
			term(Sym.VARIABLE);
			term(Sym.CONCAT);
			return new Declaration(nomVar);
			
		} else if(reader.check(Sym.VARIABLE)) {
			String nomVar = reader.getStringValue();
			term(Sym.VARIABLE);
			term(Sym.EQ);
			Expression exp = nontermExp();
			term(Sym.CONCAT);
			return new Assignment(nomVar, exp);
		} else if(reader.check(Sym.PRINT)) {
			term(Sym.PRINT);
			Expression exp = nontermExp();
			term(Sym.CONCAT);
			return new Print(exp);
		} else if(reader.check(Sym.FOR)) {
			term(Sym.FOR);
			Expression exp = nontermExp();
			term(Sym.TIMESDO);
			term(Sym.LACC);
			Program prog = nontermProg();
			term(Sym.RACC);
			return new Loop(exp, prog);
		} else {
			throw new Exception();
		}
	}
	
	public Expression nontermExp() throws Exception {
		if(reader.check(Sym.LPAR)){
			term(Sym.LPAR);
			Expression exp = nontermExp();
			Expression expSuite = nontermExpSuite(exp);
			term(Sym.RPAR);
			return expSuite;
		} else if(reader.check(Sym.INT)){
			int value = reader.getIntValue();
			term(Sym.INT);
			return new Int(value);
		} else if(reader.check(Sym.VARIABLE)){
			String var = reader.getStringValue();
			term(Sym.VARIABLE);
			return new Var(var);
		} else {
			throw new Exception();
		}
	}

    public Expression nontermExpSuite(Expression beginning) throws Exception {
        if(reader.check(Sym.PLUS)){
			term(Sym.PLUS);
			Expression exp = nontermExp();
			return new Sum(beginning, exp);
		} else if(reader.check(Sym.MINUS)){
			term(Sym.MINUS);
			Expression exp = nontermExp();
			return new Difference(beginning, exp);
		} else if(reader.check(Sym.TIMES)){
			term(Sym.TIMES);
			Expression exp = nontermExp();
			return new Product(beginning, exp);
		} else if(reader.check(Sym.DIV)){
			term(Sym.DIV);
			Expression exp = nontermExp();
			return new Division(beginning, exp);
		} else {
			throw new Exception();
		}
    }
    
    public void term(Sym symbol) throws Exception {
		try{
			reader.eat(symbol);
		} catch(Exception e) {
			throw new Exception(e);
		}
	}
}
