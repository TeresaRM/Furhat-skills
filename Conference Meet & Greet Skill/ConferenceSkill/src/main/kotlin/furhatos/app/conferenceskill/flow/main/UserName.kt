package furhatos.app.conferenceskill.flow.main

import furhatos.app.conferenceskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.TellName

val UserName : State = state(Parent) {
    onEntry {
        furhat.say("So")
        delay(500)
        furhat.ask("What's your name?")
    }

    onResponse<TellName> {
        val name = it.intent.name
        furhat.say {
            random {
                + "Oh $name, nice to meet you"
                + "$name. That's a really nice name"
                + "$name. I hope I'm saying that correctly!"
            }
        }
        furhat.gesture(Gestures.Smile, async = true)
        goto(FurhatIntroductionPerson)
    }

    onResponse {
        furhat.say {
            + "I'm sorry but I didn't quite get that so"
            + delay(500)
            + "I'll call you human"
        }
        furhat.gesture(Gestures.Wink, async = false)
        goto(FurhatIntroductionHuman)
    }

    onNoResponse {
        furhat.say{
            + "Sorry, could you repeat that a bit more loudly?"
            + "It is quite noisy in here"
        }
        furhat.gesture(Gestures.BrowRaise)
        furhat.listen()
    }
}