import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;


import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class test {
   static String SOURCE_PATH="C:\\Users\\0817\\Desktop\\";
  static String FILE_NAME="demo.java";

    public static void main(String[] args) {
        try {
            ASTParser astParser = ASTParser.newParser(AST.JLS3);
            String pathname = String.format("%s%s", SOURCE_PATH, FILE_NAME);
            BufferedInputStream bufferedInputStream = new
                    BufferedInputStream(new FileInputStream(pathname));
            byte input[] = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(input);
            bufferedInputStream.close();
            astParser.setSource(new String(input).toCharArray());
            ASTNode root = (ASTNode) astParser.createAST(null);

            boolean makedot = true;
            DotASTVistor visitor = new DotASTVistor(input, makedot);
            root.accept(visitor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
