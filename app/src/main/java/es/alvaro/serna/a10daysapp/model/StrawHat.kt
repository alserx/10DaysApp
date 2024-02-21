package es.alvaro.serna.a10daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StrawHat(
    @StringRes val day: Int,
    @StringRes val name: Int,
    @StringRes val alias: Int,
    @StringRes val description: Int,
    @DrawableRes val images: List<Int>
)
