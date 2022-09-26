package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.gestures.Gestures
import furhatos.nlu.common.PersonName
import furhatos.nlu.common.TellName
import furhatos.nlu.intent

val Farewell : State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say {
            random {
                + "Well FIX, it was nice meeting you"
                + "Well FIX, it was nice getting to know you"
                + "Well FIX, it was nice chatting to you"
            }
        }
        delay(500)
        furhat.say("I'm a bit tired now, so I'm going to zone off into the metaverse for a while")
        furhat.gesture(Gestures.Wink, async = false)
        delay(500)
        furhat.say{
            random {
                + "See you around"
                + "See you later"
                + "Enjoy the rest of the conference"
                + "Remember to talk to Teresa or Guanyu for more info about me"
            }
        }
        goto(SleepState)
    }
}