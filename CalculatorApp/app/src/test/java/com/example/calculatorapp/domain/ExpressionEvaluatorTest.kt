package com.example.calculatorapp.domain

import com.google.common.truth.Truth.*
import org.junit.Test

class ExpressionEvaluatorTest {

    private lateinit var expressionEvaluator: ExpressionEvaluator

    @Test
    fun `Expression with one operator and simple digits evaluates with correct value`() {
        // Arrange
        val expected = 5.0
        val expression = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(2.0),
        )
        expressionEvaluator = ExpressionEvaluator(expression)

        // Act
        val actual = expressionEvaluator.evaluate()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with multiple operators and multiple digit number evaluates with correct value`() {
        // Arrange
        val expected = 106.0
        val expression = listOf(
            ExpressionPart.Number(31.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(25.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(1.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(3.0),
        )
        expressionEvaluator = ExpressionEvaluator(expression)

        // Act
        val actual = expressionEvaluator.evaluate()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with multiple operators and parenthesis evaluates with correct value`() {
        // Arrange
        val expected = 4.98
        val expression = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(2.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(1.0),
            ExpressionPart.Op(Operation.MOD),
            ExpressionPart.Number(2.0),
        )
        expressionEvaluator = ExpressionEvaluator(expression)

        // Act
        val actual = expressionEvaluator.evaluate()

        // Assert
        assertThat(expected).isEqualTo(actual)
    }
}