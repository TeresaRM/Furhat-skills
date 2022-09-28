package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.flow.nlu.NegativeRemark
import furhatos.app.conferenceskill.flow.nlu.PositiveRemark
import furhatos.app.conferenceskill.setting.name
import furhatos.gestures.Gestures

val PosterSession: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            random {
                + "Well, one last question ${users.current.name}, I'm genuinely interested"
                + "Well, one last question ${users.current.name} and I'll let you go"
            }
        }
        furhat.ask {
            random {
                + "Are you liking the poster session so far?"
                + "Are you enjoying this poster session?"
            }
        }
    }

    onResponse<PositiveRemark> {
        furhat.say {
            random {
                + "That's great to hear! Students have worked really hard for it"
                + "I'm glad you are enjoying the session. My favourite poster is Tyler's social intelligence research"
            }
        }
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(Farewell)
    }

    onResponse<NegativeRemark> {
        furhat.say {
            random {
                + "Thanks for the feedback ${users.current.name}. Me and my team will remember that"
                + "Well, hopefully talking to me is the highlight of this session"
                + "I guess you must be really tired or bored. Grab some coffee, I heard it's human's preferred energy source"
            }
        }
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(Farewell)
    }

    onResponse {
        furhat.say("I didn't quite catch that, but I'll assume you are having fun speaking to me.")
        furhat.gesture(Gestures.BigSmile, async = false)
        delay(200)
        goto(Farewell)
    }

    onNoResponse {
        furhat.say("${users.current.name} are you okay? Don't you like this poster session?")
        furhat.listen()
    }
}