package org.example;

import java.io.*;

public class App {
  public static void main(String[] args) {

    FileInputStream stream = null;
    InputStreamReader reader = null;
    try {
      stream = new FileInputStream(args[0]);
      reader = new InputStreamReader(stream, "UTF-8");

      var lexer = new Yylex(reader);
      var parser = new MyParser(lexer);

      // Symbol token;
      // do {
      //   token = lexer.next_token();
      //   System.out.println(token.sym);
      // } while (token.sym != sym.EOF);

      parser.parse();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
        if (stream != null) {
          stream.close();
        }

      } catch (IOException e) {
        System.err.println("IO Error closing file");
      }
    }
  }
}
