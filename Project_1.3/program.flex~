%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
	
%}

%yylexthrow{
	LexerException
%yylexthrow}

blank = [\n\r\t ]
int   = [1-9][0-9]*[.]*[0-9]* | 0
variable = [a-z][a-zA-Z]*

%%

<YYINITIAL> {
   
 "("			{return new Token(Sym.LPAR);}
 ")"			{return new Token(Sym.RPAR);}
 "VAR"			{return new Token(Sym.VAR);}
 "DEBUT"		{return new Token(Sym.DEBUT);}
 "FIN"			{return new Token(Sym.FIN);}
 "HAUTPINCEAU"	{return new Token(Sym.HAUT);}
 "BASPINCEAU"	{return new Token(Sym.BAS);}
 "TOURNE"		{return new Token(Sym.TOURNE);}
 "AVANCE"		{return new Token(Sym.AVANCE);}
 "COULEUR"		{return new Token(Sym.COULEUR);}
 "EPAISSEUR"	{return new Token(Sym.EPAISSEUR);}
 "SI"			{return new Token(Sym.SI);}
 "ALORS"		{return new Token(Sym.ALORS);}
 "SINON"		{return new Token(Sym.SINON);}
 "TANT QUE"		{return new Token(Sym.TANTQUE);}
 "FAIRE"		{return new Token(Sym.FAIRE);}
 "POUR"			{return new Token(Sym.POUR);}
 "TOUR"			{return new Token(Sym.TOURS);}
 "TOURS"		{return new Token(Sym.TOURS);}
 "="			{return new Token(Sym.EQ);}
 ";"			{return new Token(Sym.CONCAT);}
 "+"			{return new Token(Sym.PLUS);}
 "-"			{return new Token(Sym.MINUS);}
 "*"			{return new Token(Sym.TIMES);}
 "/"			{return new Token(Sym.DIV);}
 {variable}		{return new VarToken(Sym.VARIABLE, yytext());}
 {int}			{return new IntToken(Sym.INT, Double.parseDouble(yytext()));}
   
 {blank}	   	{}
 <<EOF>>	   	{return new Token(Sym.EOF);}
 [^]		   	{System.out.println(yytext()); throw new LexerException(yyline, yycolumn);}
}
