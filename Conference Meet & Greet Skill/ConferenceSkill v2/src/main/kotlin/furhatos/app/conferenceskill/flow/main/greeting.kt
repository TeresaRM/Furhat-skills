package furhatos.app.conferenceskill.flow.main

import furhatos.app.conferenceskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Greeting
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

val localDateTime: LocalDateTime = Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
val hourOfDay = localDateTime.hour
val timeOfDay = when (hourOfDay) {
    in 0..3 -> "night"
    in 4 .. 12 -> "morning"
    in 13 .. 18 -> "afternoon"
    in 19 .. 21 -> "evening"
    in 22 .. 23 -> "night"
    else -> ""
}

val Greeting : State = state(Parent) {
    onEntry {
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say {
            random {
                + "Good $timeOfDay"
                + "Hi there"
                + "Hello there"
                + "Hey human"
            }
        }
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
        furhat.say("Welcome to the CDT Conference in Sheffield")
        goto(HowAreYou)
    }
}
