package es.alvaro.serna.a10daysapp.datasource

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
