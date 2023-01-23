package com.example.calculatorapp.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var expressionParser: ExpressionParser

    @Test
    fun `Expression with one digit numbers is properly parsed`() {
        // Arrange
        expressionParser = ExpressionParser("3+2")
        val expected = listOf<ExpressionPart>(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(2.0),
        )

        // Act
        val actual = expressionParser.parse()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with multiple digit numbers is properly parsed`() {
        // Arrange
        expressionParser = ExpressionParser("31+25/1*3")
        val expected = listOf<ExpressionPart>(
            ExpressionPart.Number(31.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(25.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(1.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(3.0),
        )

        // Act
        val actual = expressionParser.parse()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with parentheses is properly parsed`() {
        // Arrange
        expressionParser = ExpressionParser("3+(2-1)%2")
        val expected = listOf<ExpressionPart>(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Parentheses(isOpen = true),
            ExpressionPart.Number(2.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(1.0),
            ExpressionPart.Parentheses(isOpen = false),
            ExpressionPart.Op(Operation.MOD),
            ExpressionPart.Number(2.0),
        )

        // Act
        val actual = expressionParser.parse()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with double values is properly parsed`() {
        // Arrange
        expressionParser = ExpressionParser("3+(2.-1.0)%2.")
        val expected = listOf<ExpressionPart>(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Parentheses(isOpen = true),
            ExpressionPart.Number(2.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(1.0),
            ExpressionPart.Parentheses(isOpen = false),
            ExpressionPart.Op(Operation.MOD),
            ExpressionPart.Number(2.0),
        )

        // Act
        val actual = expressionParser.parse()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }
}