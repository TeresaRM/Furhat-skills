package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.setting.name
import furhatos.gestures.Gestures

val Farewell : State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say {
            random {
                + "It was nice meeting you ${users.current.name}"
                + "It was nice getting to know you ${users.current.name}"
                + "It was nice chatting to you ${users.current.name}"
            }
        }
        delay(200)
        furhat.say("But some of my friends are waiting for me in the metaverse")
        furhat.gesture(Gestures.Wink, async = false)
        delay(200)
        furhat.say{
            random {
                + "See you around"
                + "See you later"
                + "Enjoy the rest of the conference"
                + "Remember to talk to Teresa or Guanyu for more information about me"
            }
        }
        goto(SleepState)
    }
}