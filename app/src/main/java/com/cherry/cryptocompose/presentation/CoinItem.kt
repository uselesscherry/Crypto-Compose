package com.cherry.cryptocompose.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.cherry.cryptocompose.domain.model.CoinDetailed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinItem(
    modifier: Modifier = Modifier,
    coin: CoinDetailed
) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val rotation by animateFloatAsState(targetValue = if (isVisible) 180f else 0f)
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = coin.name,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize
                )
                Column {
                    Text(text = if (coin.isActive) "is active" else "is not active")
                    Text(text = "type: ${coin.type}")
                }
                IconButton(onClick = {
                    isVisible = !isVisible
                }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        modifier = Modifier.rotate(rotation),
                        contentDescription = null
                    )
                }
            }
            AnimatedVisibility(visible = isVisible) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = coin.rank.toString(),
                            fontSize = MaterialTheme.typography.headlineSmall.fontSize
                        )
                        Column {
                            coin.startedAt?.let {
                                Text(text = "Started at: ${coin.date}")
                            }
                            Text(text = "development status: ${coin.developmentStatus}")
                        }
                    }
                    Text(text = coin.description)
                }

            }

        }
    }
}