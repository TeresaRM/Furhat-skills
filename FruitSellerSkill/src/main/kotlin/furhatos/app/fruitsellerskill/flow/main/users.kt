package furhatos.app.fruitsellerskill.flow.main

import furhatos.app.fruitsellerskill.nlu.FruitList
import furhatos.records.User

class FruitData {
    var fruits : FruitList = FruitList()
}

val User.order : FruitData
    get() = data.getOrPut(FruitData::class.qualifiedName, FruitData())


/** KEEP TRACK OF WHAT USER ORDERED WHICH FRUIT
 * FruitData is a Kotlin class with a variable of type FruitList, which is instantiated as an empty list.
 * Then, an extension variable to the User model of type FruitData. This allows to save the ordered fruit(s) by each user.
 */