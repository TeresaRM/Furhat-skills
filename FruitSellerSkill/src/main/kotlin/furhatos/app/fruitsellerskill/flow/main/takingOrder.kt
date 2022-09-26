package furhatos.app.fruitsellerskill.flow.main

import furhatos.app.fruitsellerskill.flow.Parent
import furhatos.app.fruitsellerskill.nlu.BuyFruit
import furhatos.app.fruitsellerskill.nlu.FruitSelection
import furhatos.app.fruitsellerskill.nlu.Fruit
import furhatos.app.fruitsellerskill.nlu.FruitList
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.util.Language

val TakingOrder : State = state(Parent) {       //DEFINE THE STATE AS A VARIABLE
    onEntry {
        furhat.ask{
            random {
                + "Would you like some fruit?"
                + "How about some freshly-picked fruit?"
            }
        }
    }

    onResponse<Yes> {
        furhat.ask {
            random {
                + "What kind of fruit would you like?"
                + "What do you fancy eating?"
                + "What type of fruit?"
            }
        }
    }

    onResponse<No> {
        furhat.say("That's a shame, you are missing out. Have a good day!")
        goto(Idle)
    }

    onResponse<BuyFruit> { //BuyFruit custom intent (not system defined)
        val fruits = it.intent.fruits
        if (fruits != null) {
            goto(orderReceived(fruits))
        }
        else {
            propagate()
        }
    }

    onResponse<FruitSelection> {
        furhat.say("Right now I have apples, bananas, oranges, pineapple and avocado!")
        //could also do furhat.say("I have ${Fruit().optionsToText()}")
        furhat.ask("What would you like?")
    }
}

fun orderReceived (fruits: FruitList) : State = state {     //DEFINE THE STATE AS A FUNCTION
    onEntry {
        furhat.say{
            random {
                + "${fruits.text}. Okay, let me prep that for you."
                + "${fruits.text}. That's a great choice!."
                + "${fruits.text}, I love it too!"
            }
        }
        fruits.list.forEach {
            users.current.order.fruits.list.add(it)
        }
        furhat.ask("Would you like anything else?")
    }

    onReentry {                       //Reentry handler to avoid repeating the order confirmation if a reentry is done
        furhat.ask("Did you want anything else?")
    }

    onResponse<BuyFruit> {
        val fruits = it.intent.fruits
        if (fruits != null) {
            goto(orderReceived(fruits))
        }
        else {
            propagate()
        }
    }

    onResponse<FruitSelection> {
        furhat.say("We have ${Fruit().getEnum(Language.ENGLISH_US).joinToString(", ")}")
        furhat.ask("Do you want some?")
    }

    onResponse<Yes> {
        random(
            { furhat.ask("What kind of fruit do you want?") },
            { furhat.ask("What type of fruit?") }
        )
    }

    onResponse<No> {
        furhat.say("Okay, here is your order of ${users.current.order.fruits}. Have a great day!")
        goto(Idle)
    }
}