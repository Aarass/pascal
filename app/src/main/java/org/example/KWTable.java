package org.example;

import java.util.HashMap;

public class KWTable {
  private HashMap<String, Integer> table;

  public KWTable() {
    table = new HashMap<String, Integer>();

    table.put("program", sym.PROGRAM);
    table.put("var", sym.VAR);
    table.put("integer", sym.INTEGER);
    table.put("char", sym.CHAR);
    table.put("begin", sym.BEGIN);
    table.put("end", sym.END);
    table.put("read", sym.READ);
    table.put("write", sym.WRITE);
    table.put("if", sym.IF);
    table.put("then", sym.THEN);
    table.put("else", sym.ELSE);
  }

  public int getKW(String text) {
    var symbol = table.get(text);

    if (symbol == null) {
      return -1;
    } else {
      return symbol;
    }
  }
}
