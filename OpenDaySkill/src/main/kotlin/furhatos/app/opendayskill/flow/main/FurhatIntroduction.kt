package furhatos.app.opendayskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.opendayskill.flow.Parent
import furhatos.app.opendayskill.setting.name
import furhatos.gestures.Gestures


val FurhatIntroduction : State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            + "My name is Lucy and I am Sheffield's Furhat social robot"
            + delay(500)
        }
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say("Nice to meet you ${users.current.name}!")
        delay(500)
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say("I work at the Department of Computer Science.")
        furhat.say("I help humans understand social robots and how to improve human-robot interactions")
        delay(200)
        furhat.say("Quite fascinating work!")
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(UserSubject)
    }
}