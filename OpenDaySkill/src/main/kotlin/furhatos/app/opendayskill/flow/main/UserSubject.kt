package furhatos.app.opendayskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.opendayskill.flow.Parent
import furhatos.app.opendayskill.flow.nlu.DontKnow
import furhatos.app.opendayskill.flow.nlu.PossibleSubjects
import furhatos.gestures.Gestures


val UserSubject: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.ask("What would you like to study at university?")
    }

    onResponse<PossibleSubjects> {
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say("${it.intent.subject}. Amazing!")
        delay(200)
        furhat.say("I'm sure there is an informative ${it.intent.subject} stand somewhere around the Diamond.")
        delay(200)
        furhat.say("So make sure to check it out later.")
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(OpenDay)
    }

    onResponse<DontKnow> {
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say("Well, I hope you feel inspired by the students today and become interested in a few subjects!")
        furhat.gesture(Gestures.BigSmile, async = false)
        delay(200)
        goto(OpenDay)
    }

    onResponse {
        furhat.say{
            + "That sounds very interesting!"
            + delay(200)
            + "I wish you the best in your academic journey!"
        }
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(OpenDay)
    }

    onNoResponse {
        furhat.gesture(Gestures.BrowFrown, async = true)
        furhat.say("Hello? Do you know what you would like to study at university?")
        furhat.listen()
    }
}