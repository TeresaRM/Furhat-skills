package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.flow.nlu.ColdCountries
import furhatos.app.conferenceskill.flow.nlu.WarmCountries
import furhatos.gestures.Gestures
import furhatos.nlu.common.PersonName

val UserCountry: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.ask("Which country are you from?")
    }

    onResponse<ColdCountries> {
        val Coldcountry = it.intent.getIntentCandidate()
        furhat.say {
            + "$Coldcountry is a bit colder compared to Sheffield this time of the year"
            + "I hope you are enjoying these sunny days in the UK"
        }
        furhat.gesture(Gestures.Smile, async = false)
        goto(PosterSession)
    }

    onResponse<WarmCountries> {
        val Warmcountry = it.intent.getIntentCandidate()
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say {
            + "Oh wow! $Warmcountry is so warm this time of the year!"
            + "I'm so jealous"
            + delay(500)
            + "I'm staying in Sheffield for the summer"
        }
        furhat.gesture(Gestures.BrowRaise, async = false)
        goto(PosterSession)
    }

    onResponse {
        furhat.say{
            + "Such a nice place!"
            + delay(500)
            + "I hope you are enjoying Sheffield in this warm, summer day"
        }
        furhat.gesture(Gestures.Smile)
        goto(PosterSession)
    }

    onNoResponse {
        furhat.say("Hello? Where are you from?")
        furhat.gesture(Gestures.BrowFrown)
        furhat.listen()
    }
}
