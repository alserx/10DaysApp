package es.alvaro.serna.a10daysapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import es.alvaro.serna.a10daysapp.model.StrawHat

object StrawHatScreen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StrawHatCard(strawHat: StrawHat, modifier: Modifier = Modifier) {
        var expanded by remember { mutableStateOf(false) }
        val color by animateColorAsState(
            targetValue =
            if (expanded) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.secondaryContainer,
            label = "Straw Hat Card background",
        )
        Card(
            modifier = modifier,
            shape = MaterialTheme.shapes.medium,
            onClick = {
                expanded = !expanded
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        )
                    )
                    .background(color = color)
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_small)
                    )
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    StrawHatTopText(strawHat.day, strawHat.name, strawHat.alias)
                    Spacer(modifier = Modifier.weight(1f))
                    ExpandButton(
                        expanded = expanded
                    ) {
                        expanded = !expanded
                    }
                }
                StrawHatImage(strawHat.image, strawHat.name)

                if (expanded) {
                    StrawHatDescription(
                        strawHat.description,
                        modifier = modifier
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                end = dimensionResource(R.dimen.padding_medium),
                            )
                    )
                }
            }
        }
    }

    @Composable
    fun StrawHatTopText(
        @StringRes strawHatDay: Int,
        @StringRes strawHatName: Int,
        @StringRes strawHatAlias: Int
    ) {
        Column {
            Text(
                text = stringResource(strawHatDay),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(strawHatName),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(strawHatAlias),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }

    @Composable
    fun StrawHatImage(
        @DrawableRes strawHatIcon: Int,
        @StringRes strawHatName: Int,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                alignment = Alignment.Center,
                modifier = modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(MaterialTheme.shapes.small),
                painter = painterResource(strawHatIcon),
                contentScale = ContentScale.FillHeight,
                contentDescription = stringResource(strawHatName),
            )
        }
    }

    @Composable
    fun StrawHatDescription(strawHatDescription: Int, modifier: Modifier = Modifier) {
        Text(
            text = stringResource(strawHatDescription),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
        )
    }

    @Composable
    private fun ExpandButton(
        expanded: Boolean,
        modifier: Modifier = Modifier,
        onClick: () -> Unit
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null,//stringResource(R.string.expand_button_content_description),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }

}