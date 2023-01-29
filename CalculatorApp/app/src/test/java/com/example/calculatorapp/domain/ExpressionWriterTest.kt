package com.example.calculatorapp.domain

import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.Test

class ExpressionWriterTest {

    private lateinit var expressionWriter: ExpressionWriter

    @Test
    fun `When formatted correctly, expressionWriter should process all actions`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Op(Operation.ADD))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("(3+44)")
    }

    @Test
    fun `When enough delete actions, expressionWriter should delete all previous actions`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Op(Operation.SUBTRACT))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Delete)
        expressionWriter.processAction(CalculatorAction.Delete)
        expressionWriter.processAction(CalculatorAction.Delete)

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("(")
    }

    @Test
    fun `When operation actions can't be added, expressionWriter should skip them`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Op(Operation.SUBTRACT))
        expressionWriter.processAction(CalculatorAction.Op(Operation.MULTIPLY))
        expressionWriter.processAction(CalculatorAction.Op(Operation.ADD))
        expressionWriter.processAction(CalculatorAction.Number(4))

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("(3-+4")
    }

    @Test
    fun `When multiple decimal actions added after a number, expressionWriter should skip all except the first one`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Decimal)

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("4.")
    }

    @Test
    fun `When multiple decimal action added after a parentheses, expressionWriter should skip it`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Op(Operation.SUBTRACT))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Decimal)

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("(3-4)")
    }

    @Test
    fun `When calculate action added, expressionWriter should calculate expression`() {
        // Arrange
        expressionWriter = ExpressionWriter()

        // Act
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Op(Operation.SUBTRACT))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Op(Operation.ADD))
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Calculate)

        // Assert
        Truth.assertThat(expressionWriter.expression).isEqualTo("2.0")
    }
}