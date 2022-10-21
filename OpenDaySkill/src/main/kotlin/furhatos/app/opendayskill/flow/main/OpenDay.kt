package furhatos.app.opendayskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.opendayskill.flow.Parent
import furhatos.app.opendayskill.flow.nlu.NegativeRemark
import furhatos.app.opendayskill.flow.nlu.PositiveRemark
import furhatos.app.opendayskill.setting.name
import furhatos.gestures.Gestures


val OpenDay: State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.say {
            random {
                + "Well, one last question ${users.current.name}, I'm genuinely interested!"
                + "Well, one last question ${users.current.name} and I'll let you go."
            }
        }
        delay(200)
        furhat.ask {
            random {
                + "Are you liking the open day so far?"
                + "Are you enjoying the open day?"
            }
        }
    }

    onResponse<PositiveRemark> {
        furhat.say {
            random {
                + "That's great to hear! Students have worked really hard for it"
                + "I'm glad you are enjoying the open day. Make sure to check out as many stands and activities as possible!"
            }
        }
        furhat.gesture(Gestures.BigSmile, async = false)
        delay(200)
        goto(Farewell)
    }

    onResponse<NegativeRemark> {
        furhat.say {
            random {
                + "Thanks for the feedback ${users.current.name}. Me and my team will remember that"
                + "I guess you must be really tired. Grab some coffee, I heard it's human's preferred energy source"
            }
        }
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(Farewell)
    }

    onResponse {
        furhat.say("I didn't quite catch that, but I'll assume you are having fun speaking to me.")
        furhat.gesture(Gestures.Smile, async = false)
        delay(200)
        goto(Farewell)
    }

    onNoResponse {
        furhat.say("${users.current.name} are you okay? I didn't quite catch that")
        furhat.listen()
    }
}