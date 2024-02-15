package es.alvaro.serna.a10daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.alvaro.serna.a10daysapp.StrawHatScreen.StrawHatCard
import es.alvaro.serna.a10daysapp.model.StrawHat
import es.alvaro.serna.a10daysapp.model.StrawHatRepository.strawHats
import es.alvaro.serna.a10daysapp.ui.theme.The10DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            The10DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    The10DaysOfApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun The10DaysOfApp(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        topBar = {
            The10DaysTopAppBar(
                Modifier
                    .fillMaxWidth()
            )
        }
    ) { it ->
        Box(modifier = Modifier.fillMaxSize()) {
            BackgroundImage(darkTheme, Modifier.matchParentSize())
            LazyColumn(contentPadding = it) {
                items(strawHats) {
                    StrawHatCard(
                        strawHat = it,
                        modifier = Modifier.padding(
                            horizontal = dimensionResource(R.dimen.padding_small),
                            vertical = dimensionResource(R.dimen.padding_medium)
                        )
                    )

                }
            }
        }
    }
}

@Composable
fun BackgroundImage(darkTheme: Boolean, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter =
        if (darkTheme) painterResource(R.drawable.dark_background)
        else painterResource(R.drawable.light_background),
        contentScale = ContentScale.FillHeight,
        contentDescription = null,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun The10DaysTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            TitleRow()
        },
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                alpha = 0.8f
            )
        )
    )
}

@Composable
private fun TitleRow() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(Modifier.width(dimensionResource(R.dimen.padding_small)))
        Image(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.logo_size)),
            painter = painterResource(R.drawable.one_piece_logo),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    The10DaysAppTheme {
        The10DaysOfApp()
    }
}

@Preview
@Composable
fun DarkAppPreview() {
    The10DaysAppTheme(darkTheme = true) {
        The10DaysOfApp(true)
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    The10DaysAppTheme {
        StrawHatCard(
            StrawHat(
                R.string.day1,
                R.string.mugiwara1,
                R.string.alias1,
                R.string.description1,
                R.drawable.luffy
            )
        )
    }
}