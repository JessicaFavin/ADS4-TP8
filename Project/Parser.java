import java.io.*;
import java.util.*;

class Parser {
	/*
	 * Code -> Prog$
     * Prog -> Decl Inst
     * Decl -> VAR var; Decl | e
     * Inst -> var = Exp; | DEBUT BlocInst FIN | AVANCE Exp; | TOURNE Exp | HAUTPINCEAU | BASPINCEAU
     * BlocInst -> Inst; BlocInst | e
	 * Exp -> int ExpSuite | var ExpSuite | (Exp) ExpSuite
	 * ExpSuite -> Op ExpSuite | e
     * Op -> + Exp | - Exp | * Exp | / Exp
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
    
    public void nontermProg() throws Exception {
    
    }
    
    public void nontermDecl() throws Exception {
    
    }
    
    public void nontermInst() throws Exception {
    
    }
    
    public void nontermBlocInst() throws Exception {
    
    }
    
    public void nontermExp() throws Exception {
    
    }
    
    public void nontermExpS() throws Exception {
    
    }
    
    public void nontermOp() throws Exception {
    
    }
    
    public void term(Sym symbol) throws Exception {
		try{
			reader.eat(symbol);
		} catch(Exception e) {
			throw new Exception(e);
		}
	}
}
