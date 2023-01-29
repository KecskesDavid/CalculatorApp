package com.example.calculatorapp.domain

class ExpressionWriter {

    var expression = ""

    fun processAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Calculate -> {
                val parser = ExpressionParser(prepareForCalculation())
                val evaluator = ExpressionEvaluator(parser.parse())

                expression = evaluator.evaluate().toString()
            }

            CalculatorAction.Clear -> {
                expression = ""
            }

            CalculatorAction.Decimal -> {
                if (canAddDecimal()) {
                    expression += '.'
                }
            }

            CalculatorAction.Delete -> {
                expression = expression.dropLast(1)
            }

            is CalculatorAction.Number -> {
                expression += action.number
            }

            is CalculatorAction.Op -> {
                if (canAddOperation(action.operation)) {
                    expression += action.operation.symbol
                }
            }

            CalculatorAction.Parentheses -> {
                processParentheses()
            }
        }
    }

    // 3+2+( | 3+2-
    private fun prepareForCalculation(): String {
        val toDelete = expression.takeLastWhile {
            it in "$operationValues(."
        }
        val newExpression = expression.removeSuffix(toDelete)

        if(newExpression.isEmpty()) {
            return "0"
        }
        return newExpression
    }

    private fun canAddDecimal(): Boolean {
        return expression.last() in "0123456789" && !expression.takeLastWhile {
            it in "0123456789."
        }.contains('.')
    }

    private fun canAddOperation(operation: Operation): Boolean {
        val lastChar = expression.last()

        if (operation == Operation.ADD || operation == Operation.SUBTRACT) {
            return expression.isEmpty() || expression.last() in "$operationValues()0123456789"
        }

        return when (lastChar) {
            ')' -> true
            in "1234567890" -> true
            else -> false
        }
    }

    private fun processParentheses() {
        val opening = expression.count { it == '(' }
        val closing = expression.count { it == ')' }

        expression += when {
            expression.isEmpty() || expression.last() in "$operationValues(" -> "("
            expression.last() in "0123456789)" && opening == closing -> return
            else -> ")"
        }
    }
}