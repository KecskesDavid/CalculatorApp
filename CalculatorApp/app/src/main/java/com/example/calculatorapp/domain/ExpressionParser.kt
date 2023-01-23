package com.example.calculatorapp.domain

import com.example.calculatorapp.util.isOperation
import com.example.calculatorapp.util.isParenthesis

class ExpressionParser(
    private val calculation: String
) {

    fun parse(): List<ExpressionPart> {
        val parsedList = mutableListOf<ExpressionPart>()

        var i = 0
        while (i < calculation.length) {
            val char = calculation[i]

            when {
                char.isDigit() -> {
                    var number = ""

                    while (calculation[i].isDigit() || calculation[i] == '.') {
                        number += calculation[i]
                        ++i

                        if(i == calculation.length) break
                    }

                    if(number.last() == '.') number += '0'

                    parsedList.add(ExpressionPart.Number(number.toDouble()))
                    --i // So we move to next part only on the end of the function
                }

                char.isOperation() -> {
                    val operation = operationFromSymbol(char)

                    parsedList.add(ExpressionPart.Op(operation))
                }

                char.isParenthesis() -> {
                    val isOpen = char == '('

                    parsedList.add(ExpressionPart.Parentheses(isOpen))
                }
            }

            ++i
        }
        return parsedList
    }
}