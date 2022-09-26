package furhatos.app.fruitsellerskill.nlu

import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.Intent
import furhatos.nlu.EnumEntity
import furhatos.nlu.ListEntity
import furhatos.util.Language

//Fruit slot (or entity) and the available values Fruit can take
class Fruit : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("banana", "apple", "pineapple", "orange", "avocado")    //enumeration of all strings that correspond to fruits
    }
}

//FruitList slot
class FruitList : ListEntity<QuantityFruit>()


//BuyFruit custom intent
class BuyFruit(val fruits: FruitList? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("An @fruits", "A @fruits", "@fruits", "I would like @fruits", "I want to buy @fruits", "Can I have @fruits", "@fruits thank you", "@fruits please")
    }
}

//FruitSelection custom intent
class FruitSelection : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("What fruits are available?", "What do you offer?", "What fruits do you have?", "What do you have?")
    }
}

//QuantityFruit custom intent
class QuantityFruit(
    val fruit : Fruit? = null,
    val count : furhatos.nlu.common.Number? = furhatos.nlu.common.Number(1)) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("@count @fruit", "@fruit")
    }

    override fun toText(): String {                               //Furhat confirms the order by repeating it out loud
        return generate("$count " + if (count?.value == 1) fruit?.value else "${fruit?.value}" + "s")
    }
}

/** IMPORTANT NOTES:
+ stemming function makes the NLU processor identify various forms of a word to be the same (i.e., banana and bananas).
+ speechRecPhrases function tips the recognizer that certain words are likely to appear.
+ The custom-intent takes a variable of the entity type Fruit.
+ The getExamples() method allows you to list all possible utterances using the entity Fruit.
+ Entities need to be nullable and with null as a default value (this is a requirement for the NLU intent classification to work).
+ Instead of nullifying numerical entities, these can be set to 1 (i.e., if a quantity isn't mentioned, we assume the user means one fruit).
 */