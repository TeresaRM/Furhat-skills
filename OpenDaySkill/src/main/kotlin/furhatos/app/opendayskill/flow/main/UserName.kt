package furhatos.app.opendayskill.flow.main

import furhatos.app.opendayskill.flow.Parent
import furhatos.app.opendayskill.setting.name
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.TellName


val UserName : State = state(Parent) {
    onEntry {
        delay(500)
        furhat.ask("What's your name?")
    }

    onResponse<TellName> {
        users.current.name = it.intent.name.toString()
        furhat.gesture(Gestures.BigSmile, async = true)
        furhat.say {
            random {
                + "Oh ${users.current.name}, what a lovely name!"
                + "${users.current.name}. That's a really nice name!"
            }
        }
        delay(200)
        goto(FurhatIntroduction)
    }

    onResponse {
        users.current.name = it.text.substringAfterLast(" ")
        furhat.gesture(Gestures.Oh, async = true)
        furhat.say("Oh ${users.current.name}, I hope I am saying that correctly!")
        delay(200)
        goto(FurhatIntroduction)
    }

    onNoResponse {
        furhat.say("Sorry, could you repeat your name again?")
        delay(200)
        furhat.gesture(Gestures.BrowRaise, async = false)
        furhat.listen()
    }
}