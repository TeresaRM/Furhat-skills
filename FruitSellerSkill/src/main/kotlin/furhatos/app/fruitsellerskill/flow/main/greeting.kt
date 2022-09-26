package furhatos.app.fruitsellerskill.flow.main

import furhatos.app.fruitsellerskill.flow.Parent
import furhatos.flow.kotlin.*

val Greeting : State = state(Parent) {
    onEntry {
        furhat.say {
            random {
                +"Good morning."
                +"Hi there passerby."
                +"Oh, hello there."
            }
        }
        goto(TakingOrder)
    }
}