package com.example.calculatorapp.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.R
import com.example.calculatorapp.domain.CalculatorAction
import com.example.calculatorapp.domain.Operation
import com.example.calculatorapp.presentation.model.CalculatorButtonLevel
import com.example.calculatorapp.presentation.model.CalculatorUiAction

@Composable
fun CalculatorButton(
    uiAction: CalculatorUiAction,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .background(
                when (uiAction.level) {
                    CalculatorButtonLevel.Neutral -> {
                        MaterialTheme.colorScheme.surfaceVariant
                    }

                    CalculatorButtonLevel.Primary -> {
                        MaterialTheme.colorScheme.inverseSurface
                    }

                    is CalculatorButtonLevel.Highlighted -> {
                        if(uiAction.level.stronglyHighlighted)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.secondary
                    }
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        val contentColor = when(uiAction.level) {
            is CalculatorButtonLevel.Neutral -> MaterialTheme.colorScheme.onSurfaceVariant
            is CalculatorButtonLevel.Primary -> MaterialTheme.colorScheme.inverseOnSurface
            is CalculatorButtonLevel.Highlighted -> if(uiAction.level.stronglyHighlighted) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onTertiary
        }

        when {
            uiAction.content != null -> {
                Icon(
                    painter = painterResource(id = uiAction.content),
                    contentDescription = "content",
                    tint = contentColor
                )
            }

            uiAction.text != null -> {
                Text(
                    text = uiAction.text,
                    fontSize = 36.sp,
                    color = contentColor
                )
            }
        }
    }
}

@Preview
@Composable
fun NeutralLevelButtonPreview() {
    CalculatorButton(
        uiAction = CalculatorUiAction(
            text = "7",
            level = CalculatorButtonLevel.Neutral,
            action = CalculatorAction.Number(7)
        ),
        onClick = {}
    )
}

@Preview
@Composable
fun NeutralLevelWithContentButtonPreview() {
    CalculatorButton(
        uiAction = CalculatorUiAction(
            content = R.drawable.ic_delete,
            level = CalculatorButtonLevel.Neutral,
            action = CalculatorAction.Delete
        ),
        onClick = {}
    )
}

@Preview
@Composable
fun PrimaryLevelButtonPreview() {
    CalculatorButton(
        uiAction = CalculatorUiAction(
            text = "/",
            level = CalculatorButtonLevel.Primary,
            action = CalculatorAction.Op(Operation.DIVIDE)
        ),
        onClick = {}
    )
}

@Preview
@Composable
fun HighlightedStronglyLevelButtonPreview() {
    CalculatorButton(
        uiAction = CalculatorUiAction(
            text = "AC",
            level = CalculatorButtonLevel.Highlighted(stronglyHighlighted = true),
            action = CalculatorAction.Clear
        ),
        onClick = {}
    )
}

@Preview
@Composable
fun HighlightedLevelButtonPreview() {
    CalculatorButton(
        uiAction = CalculatorUiAction(
            text = "=",
            level = CalculatorButtonLevel.Highlighted(),
            action = CalculatorAction.Calculate
        ),
        onClick = {}
    )
}