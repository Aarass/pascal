package org.example;

import java_cup.runtime.Symbol;

%%

%cup

%{
  KWTable table;
%}

%init{
  table = new KWTable();
%init}

%eofval{
  return new Symbol(sym.EOF);
%eofval}

%xstate COMMENT

letter=[a-zA-Z]
digit=[0-9]

%%

[\t\r\n ] { ; }

"(*" { yybegin(COMMENT); }
<COMMENT>~"*)" { yybegin(YYINITIAL); }

"+" { return new Symbol(sym.PLUS); }
"*" { return new Symbol(sym.STAR); }
":=" { return new Symbol(sym.ASSIGN); }


"(" { return new Symbol(sym.LEFTPAR); }
")" { return new Symbol(sym.RIGHTPAR); }
";" { return new Symbol(sym.SEMI); }
"," { return new Symbol(sym.COMMA); }
":" { return new Symbol(sym.COLON); }
"." { return new Symbol(sym.DOT); }

'{letter}' { return new Symbol(sym.CONST); }
{digit}+ { return new Symbol(sym.CONST); }

{letter}({letter}|{digit})* {
    var text = yytext();
    var symbol = table.getKW(text);

    if (symbol == -1) {
      return new Symbol(sym.ID);
    } else {
      return new Symbol(symbol);
    }
}

. { System.out.println("Error!"); }
