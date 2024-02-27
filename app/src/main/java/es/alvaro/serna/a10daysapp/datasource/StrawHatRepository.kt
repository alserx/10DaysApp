package es.alvaro.serna.a10daysapp.datasource

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import es.alvaro.serna.a10daysapp.model.StrawHat

class StrawHatRepository {
    private val COLLECTION_NAME = "strawhats"
    private val NAME_FIELD = "name"
    private val ALIAS_FIELD = "alias"
    private val DESCRIPTION_FIELD = "description"
    private val IMAGES_FIELD = "images"

    private val DB = FirebaseFirestore.getInstance()

    private val strawHats = DB.collection(COLLECTION_NAME)


    fun getStrawHats(setList: (List<StrawHat>) -> Unit) {

        val strawHatList = mutableListOf<StrawHat>()

        strawHats.get().addOnSuccessListener { documents ->

            for (document in documents) {
                val name = document.getString(NAME_FIELD)
                val alias = document.getString(ALIAS_FIELD)
                val description = document.getString(DESCRIPTION_FIELD)
                val images = document.get(IMAGES_FIELD) as? List<String>

                val dataModel = StrawHat(
                    name ?: "",
                    alias ?: "",
                    description ?: "",
                    images ?: listOf()
                )

                strawHatList.add(dataModel)
            }

            setList(strawHatList)
        }
    }
}
//            StrawHat(
//                R.string.day6,
//                R.string.mugiwara6,
//                R.string.alias6,
//                R.string.description6,
//                listOf(R.drawable.chopper_1, R.drawable.chopper_2)
//            ),
//            StrawHat(
//                R.string.day7,
//                R.string.mugiwara7,
//                R.string.alias7,
//                R.string.description7,
//                listOf(R.drawable.nico_robin_1, R.drawable.nico_robin_2)
//            ),
//            StrawHat(
//                R.string.day8,
//                R.string.mugiwara8,
//                R.string.alias8,
//                R.string.description8,
//                listOf(R.drawable.franky_1, R.drawable.franky_2, R.drawable.franky_3)
//            ),
//            StrawHat(
//                R.string.day9,
//                R.string.mugiwara9,
//                R.string.alias9,
//                R.string.description9,
//                listOf(R.drawable.brook_1, R.drawable.brook_2)
//            ),
//            StrawHat(
//                R.string.day10,
//                R.string.mugiwara10,
//                R.string.alias10,
//                R.string.description10,
//                listOf(R.drawable.jinbe_1, R.drawable.jinbe_2, R.drawable.jinbe_3)
//            )
//        )
