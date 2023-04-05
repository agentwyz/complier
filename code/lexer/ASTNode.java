import java.util.List;

public interface ASTNode {
     //父亲节点
     public ASTNode getParent();

     //儿子节点
     public ASTNodeType getType();
 
     //文本值
     public String getText();
 
     //获得子节点
     public List<ASTNode> getChildren();
}