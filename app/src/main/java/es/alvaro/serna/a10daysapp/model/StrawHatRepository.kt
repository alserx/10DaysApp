package es.alvaro.serna.a10daysapp.model

import es.alvaro.serna.a10daysapp.R

class StrawHatRepository {
    fun getStrawHats(): List<StrawHat> {
        return listOf(
            StrawHat(
                R.string.day1,
                R.string.mugiwara1,
                R.string.alias1,
                R.string.description1,
                listOf(
                    R.drawable.luffy_1,
                    R.drawable.luffy_2,
                    R.drawable.luffy_3,
                    R.drawable.luffy_4
                )
            ),
            StrawHat(
                R.string.day2,
                R.string.mugiwara2,
                R.string.alias2,
                R.string.description2,
                listOf(R.drawable.zoro_1, R.drawable.zoro_2)
            ),
            StrawHat(
                R.string.day3,
                R.string.mugiwara3,
                R.string.alias3,
                R.string.description3,
                listOf(R.drawable.nami_1, R.drawable.nami_2)
            ),
            StrawHat(
                R.string.day4,
                R.string.mugiwara4,
                R.string.alias4,
                R.string.description4,
                listOf(R.drawable.usopp_1, R.drawable.usopp_2)
            ),
            StrawHat(
                R.string.day5,
                R.string.mugiwara5,
                R.string.alias5,
                R.string.description5,
                listOf(R.drawable.sanji_1, R.drawable.sanji_2, R.drawable.sanji_3)
            ),
            StrawHat(
                R.string.day6,
                R.string.mugiwara6,
                R.string.alias6,
                R.string.description6,
                listOf(R.drawable.chopper_1, R.drawable.chopper_2)
            ),
            StrawHat(
                R.string.day7,
                R.string.mugiwara7,
                R.string.alias7,
                R.string.description7,
                listOf(R.drawable.nico_robin_1, R.drawable.nico_robin_2)
            ),
            StrawHat(
                R.string.day8,
                R.string.mugiwara8,
                R.string.alias8,
                R.string.description8,
                listOf(R.drawable.franky_1, R.drawable.franky_2, R.drawable.franky_3)
            ),
            StrawHat(
                R.string.day9,
                R.string.mugiwara9,
                R.string.alias9,
                R.string.description9,
                listOf(R.drawable.brook_1, R.drawable.brook_2)
            ),
            StrawHat(
                R.string.day10,
                R.string.mugiwara10,
                R.string.alias10,
                R.string.description10,
                listOf(R.drawable.jinbe_1, R.drawable.jinbe_2, R.drawable.jinbe_3)
            )
        )
    }
}