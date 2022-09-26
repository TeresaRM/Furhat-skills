package furhatos.app.conferenceskill.flow.main

import furhatos.app.conferenceskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Greeting

val Greeting : State = state(Parent) {
    onEntry {
        furhat.say{
            random {
                + "Good Afternoon"
                + "Hi there"
                + "Hello"
                + "Hey human"
            }
        }
        furhat.gesture(Gestures.Smile, async = false)
        furhat.listen()
    }

    onResponse<Greeting> {
        delay(200)
        furhat.gesture(Gestures.Blink, async = false)
        furhat.say("Welcome to the CDT Conference in Sheffield")
        goto(HowAreYou)
    }

    onNoResponse {
        reentry()
    }

    onResponse {
        furhat.say("Welcome to the CDT Conference")
        goto(HowAreYou)
    }
}
