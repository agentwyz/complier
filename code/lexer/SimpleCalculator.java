import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SimpleCalculator {
    public void main(String[] args) {

    }

    public SimpleASTNode intDeclare(TokenReader tokens) throws Exception {
        SimpleASTNode node = null;
        Token token = tokens.peek();

        if (token != null && token.getType() == TokenType.Int) {

            token = tokens.read(); //如果是Int就消耗掉

            if (tokens.peek().getType() == TokenType.Identifier) {
                token = tokens.read(); //如果是Identifier就消耗掉

                node = new SimpleASTNode(ASTNodeType.IntDeclearation, token.getText());

                token = tokens.peek();

                if (token != null && token.getType() == TokenType.Assignment) {
                    tokens.read();

                    SimpleASTNode child = additive(tokens);

                    if (child == null) {
                        throw new Exception("invalide varible initialization, expecting an expression");
                    }
                    else {
                        node.addChild(child);
                    }
                }
            }
        } else {
            throw new Exception("vaible name expected");
        }

        return node;
    }

    private SimpleASTNode additive(TokenReader tokens) throws Exception {
        SimpleASTNode child1 = multiplicative(tokens);
        SimpleASTNode node = child1;
 
        Token token = tokens.peek();
 
        if (child1 != null && token != null) {
            if (token.getType() == TokenType.Plus) {
                token = tokens.read();
 
                SimpleASTNode child2 = additive(tokens);
 
                if (child2 != null) {
                    node = new SimpleASTNode(ASTNodeType.AdditiveExp, token.getText());
                    node.addChild(child1);
                    node.addChild(child2);
                }
                else {
                    throw new Exception("invalid additive expression, expecting the right part.");
                }
 
            }
        }
 
         return node;
     }

     private SimpleASTNode multiplicative(TokenReader tokens) throws Exception {
        SimpleASTNode child3 = primary(tokens);
        SimpleASTNode node = child3;

        Token token = tokens.peek();

        if (token != null && node != null) {
            if (token.getType() == TokenType.Star || token.getType() == TokenType.Slash) {
                token = tokens.read();   //消耗掉star

                SimpleASTNode child4 = multiplicative(tokens);

                if (child4 != null) {
                    node = new SimpleASTNode(ASTNodeType.Mutiplicative, token.getText());
                    node.addChild(child3);
                    node.addChild(child4);
                } else {
                    throw new Exception("invalid multiplicative expression, expecting the right part.");
                }
            }
        }

        return node;
    }

    //基础表达式
    private SimpleASTNode primary(TokenReader tokens) throws Exception {
        SimpleASTNode node = null;
        Token token = tokens.peek();

        if (token != null) {
            if (token.getType() == TokenType.IntLiteral) {
                token = tokens.read();
                node = new SimpleASTNode(ASTNodeType.IntLiteral, token.getText());

            } else if (token.getType() == TokenType.Identifier) {
                token = tokens.read();
                node = new SimpleASTNode(ASTNodeType.Idenifier, token.getText());
            } else if (token.getType() == TokenType.LeftParen) {
                tokens.read();
                node = additive(tokens);

                if (node != null) {
                    token = tokens.peek();
                    if (token != null && token.getType() == TokenType.RightParen) {
                        tokens.read();
                    } else {
                        throw new Exception("expecting right parenthesis");
                    }
                } else {
                    throw new Exception("expecting an additive expression inside parenthesis");
                }
            }
        }
        return node;
    }

    private void dumpAST(ASTNode node, String indent) {
        System.out.println(indent + node.getType() + " " + node.getText());
        for (ASTNode child : node.getChildren()) {
            dumpAST(child, indent + "\t");
        }
    }

    //进行深度优先遍历
    private int evaluate(ASTNode node, String indent) {
        int result = 0;
        System.out.println(indent + "Calculating" + node.getType());

        switch (node.getType()) {
            case Program:
                for (ASTNode child : node.getChildren()) {
                    result = evaluate(child, indent + "\t");
                }
                break;
            case AdditiveExp:
                ASTNode child1 = node.getChildren().get(0);
                int value1 = evaluate(child1, indent + "\t");
                ASTNode child2 = node.getChildren().get(1);
                int value2 = evaluate(child2, indent + "\t");

                if (node.getText().equals("+")) {
                    result = value1 + value2;
                } else {
                    result = value1 - value2;
                }
                break;
            case Mutiplicative:
                child1 = node.getChildren().get(0);
                value1 = evaluate(child1, indent + "\t");
                child2 = node.getChildren().get(1);
                value2 = evaluate(child2, indent + "\t");
                if (node.getText().equals("*")) {
                    result = value1 * value2;
                } else {
                    result = value1 / value2;
                }
                break;
            case IntLiteral:
                result = Integer.valueOf(node.getText()).intValue();
                break;
            default:
        }
        System.out.println(indent + "Result: " + result);
        return result;
    }
}


class SimpleASTNode implements ASTNode {
    ASTNodeType type;
    String text;

    SimpleASTNode parent = null;
    List<ASTNode> children = new ArrayList<ASTNode>();
    List<ASTNode> readonlyChildren = Collections.unmodifiableList(children);

    public SimpleASTNode(ASTNodeType type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public ASTNode getParent() {
        return parent;
    }

    @Override
    public List<ASTNode> getChildren() {
        return readonlyChildren;
    }

    @Override
    public ASTNodeType getType() {
        return type;
    }

    @Override
    public String getText() {
        return text;
    }

    public void addChild(SimpleASTNode child) {
        children.add(child);
        child.parent = this;
    }
}