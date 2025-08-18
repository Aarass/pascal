package AST;

import java.io.BufferedWriter;
import java.io.IOException;

public class WriteStatement extends Statement {
  Expression exp;

  public WriteStatement(Expression exp) {
    this.exp = exp;
  }

  @Override
  public void translate(BufferedWriter out) throws IOException {
    throw new UnsupportedOperationException("Unimplemented method 'translate'");
  }
}
