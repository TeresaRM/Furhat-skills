package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.setting.name
import furhatos.gestures.Gestures

val FurhatIntroduction : State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            + "My name is Amy and I am Sheffield's Furhat social robot"
            + delay(500)
        }
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say("Nice to meet you ${users.current.name}!")
        delay(500)
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say("You know. I am originally from Stockholm in Sweden, which is 1200 miles away from here.")
        delay(200)
        furhat.say("So it would take you 350 hours to get there by feet!")
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(UserCountry)
    }
}