// Generated from play.g4 by ANTLR 4.7.2

    package antlrtest;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link playParser}.
 */
public interface playListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link playParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(playParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(playParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(playParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(playParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(playParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(playParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(playParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(playParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(playParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(playParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(playParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(playParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(playParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(playParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(playParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(playParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(playParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(playParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(playParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(playParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(playParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(playParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(playParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(playParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(playParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(playParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(playParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(playParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterBlockItemList(playParser.BlockItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitBlockItemList(playParser.BlockItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link playParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(playParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link playParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(playParser.BlockItemContext ctx);
}