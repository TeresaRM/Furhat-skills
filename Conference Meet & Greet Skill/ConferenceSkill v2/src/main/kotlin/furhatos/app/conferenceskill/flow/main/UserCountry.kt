package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.flow.nlu.FarCountry
import furhatos.app.conferenceskill.flow.nlu.CloseCountry
import furhatos.gestures.Gestures

val UserCountry: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.ask("Which country are you from?")
    }

    onResponse<CloseCountry> {
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say("${it.intent.close} is not far away from Sheffield")
        delay(200)
        furhat.say("So I might consider going there for the holidays!")
        furhat.gesture(Gestures.Wink, async = false)
        delay(200)
        goto(PosterSession)
    }

    onResponse<FarCountry> {
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say("Oh wow! ${it.intent.far} is far away from Sheffield, sounds like a cool place to visit!")
        delay(200)
        goto(PosterSession)
    }

    onResponse {
        furhat.say{
            + "Such a nice place!"
            + delay(200)
            + "Hopefully you are also enjoying Sheffield in this warm, summer day"
        }
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(PosterSession)
    }

    onNoResponse {
        furhat.gesture(Gestures.BrowFrown, async = true)
        furhat.say("Hello? Where are you from?")
        furhat.listen()
    }
}
