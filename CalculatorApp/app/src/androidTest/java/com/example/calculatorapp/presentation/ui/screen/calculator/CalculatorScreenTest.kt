package com.example.calculatorapp.presentation.ui.screen.calculator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.calculatorapp.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_correctResultIsDisplayed() {
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("X").performClick()
        composeRule.onNodeWithText("4").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("0.0").assertIsDisplayed()
    }
}