package es.alvaro.serna.a10daysapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import coil.compose.AsyncImage
import es.alvaro.serna.a10daysapp.model.StrawHat


object StrawHatScreen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StrawHatCard(strawHat: StrawHat, modifier: Modifier = Modifier) {
        var expanded by remember { mutableStateOf(false) }
        val color by animateColorAsState(
            targetValue =
            if (expanded) MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f)
            else MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f),
            label = "Straw Hat Card background",
        )
        val onClick = { expanded = !expanded }

        Card(
            modifier = modifier,
            shape = MaterialTheme.shapes.medium,
            onClick = onClick,
            colors = CardDefaults.cardColors(containerColor = color)
        ) {
            CardContent(strawHat, expanded, onClick, modifier)
        }
    }

    @Composable
    private fun CardContent(
        strawHat: StrawHat,
        expanded: Boolean,
        onClick: () -> Unit,
        modifier: Modifier
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
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_medium),
                    vertical = dimensionResource(R.dimen.padding_small)
                )
                .fillMaxWidth()
        ) {
            CardColumnContent(strawHat, expanded, onClick, modifier)
        }
    }

    @Composable
    private fun CardColumnContent(
        strawHat: StrawHat,
        expanded: Boolean,
        onClick: () -> Unit,
        modifier: Modifier
    ) {
        CardTopContent(strawHat, expanded, onClick)

        LazyRow(
            modifier = modifier
                .padding(
                    vertical = dimensionResource(R.dimen.padding_small),
                    horizontal = dimensionResource(R.dimen.padding_extra_small)
                ),
        ) {

            items(strawHat.images) {
                StrawHatImage(it, strawHat.name)
            }
        }

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

    @Composable
    private fun CardTopContent(
        strawHat: StrawHat,
        expanded: Boolean,
        onClick: () -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            StrawHatTopText(strawHat.day, strawHat.name, strawHat.alias)
            Spacer(modifier = Modifier.weight(1f))
            ExpandCardButton(
                expanded = expanded,
                onClick = onClick
            )
        }
    }

    @Composable
    fun StrawHatTopText(
        strawHatDay: String,
        strawHatName: String,
        strawHatAlias: String
    ) {
        Column {
            Text(
                text = strawHatDay,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = strawHatName,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = strawHatAlias,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }

    @Composable
    fun StrawHatImage(
        strawHatIcon: String,
        strawHatName: String,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                alignment = Alignment.Center,
                modifier = modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small),
                model = strawHatIcon,
                contentScale = ContentScale.FillHeight,
                contentDescription = strawHatName
            )
        }
    }

    @Composable
    fun StrawHatDescription(strawHatDescription: String, modifier: Modifier = Modifier) {
        Text(
            text = strawHatDescription,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
        )
    }

    @Composable
    private fun ExpandCardButton(
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
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }

}