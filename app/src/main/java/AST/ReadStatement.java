package AST;

import java.io.BufferedWriter;
import java.io.IOException;
import symbolTable.Variable;

public class ReadStatement extends Statement {
  Variable var;

  public ReadStatement(Variable var) {
    this.var = var;
  }

  @Override
  public void translate(BufferedWriter out) throws IOException {
    throw new UnsupportedOperationException("Unimplemented method 'translate'");
  }
}
