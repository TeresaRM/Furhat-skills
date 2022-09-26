package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.gestures.Gestures
import furhatos.nlu.common.PersonName

val FurhatIntroductionPerson : State = state(Parent) {
    onEntry {
        furhat.say {
            + "Hi fix"
            + delay(500)}
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            + "My name is Amy and I am Sheffield's most intelligent social robot"
            + delay(1000)
            + "I am originally from Sweden and now I live here"
            + delay(500)
        }
        furhat.gesture(Gestures.Blink, async = true)
        furhat.say {
            random {
                + "And Teresa, my human guide is from Spain"
                + "And Guanyu, my human guide is from China"
            }
        }
        delay(500)
        goto(UserCountry)
    }
}

val FurhatIntroductionHuman: State = state(Parent) {
    onEntry {
        furhat.say {
            + "Hi human"
            + delay(500)}
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            + "My name is Amy and I am Sheffield's most intelligent social robot"
            + delay(1000)
            + "I am originally from Sweden and now I live here"
            + delay(500)
        }
        furhat.gesture(Gestures.Blink, async = true)
        furhat.say {
            random {
                + "And Teresa, my human guide is from Spain"
                + "And Guanyu, my human guide is from China"
            }
        }
        delay(500)
        goto(UserCountry)
    }
}