package furhatos.app.conferenceskill.flow.main

import furhatos.app.conferenceskill.flow.Parent
import furhatos.app.conferenceskill.flow.nlu.UserNegativeFeeling
import furhatos.app.conferenceskill.flow.nlu.UserPositiveFeeling
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import java.time.LocalDateTime

var current = LocalDateTime.now()
val HowAreYou : State = state(Parent) {
    onEntry {
        /*if (current.dayOfWeek.value == 2) {
            val utterance: String = "How are you doing this lovely Tuesday?"
        } else if (current.dayOfWeek.value == 3) {
            val utterance: String = "How are you doing this fine Wednesday?"
        }
        */
        furhat.gesture(Gestures.BrowRaise, async = true)
        furhat.ask {
            random {
                +"How are you doing this fine ${if (current.dayOfWeek.value == 2) "Tuesday" else "summer day"}?"
                +"How are you doing?"
                +"How are you?"
            }
        }
    }

    onResponse<UserPositiveFeeling> {
        furhat.say {
            random {
                + "That's good to hear"
                + "I'm glad to hear that"
                + "Fantastic!"
            }
        }
        furhat.gesture(Gestures.Smile, async = false)
        goto(UserName)
    }

    onResponse<UserNegativeFeeling> {
        furhat.say {
            random {
                + "I'm sorry to hear that"
                + "That's a shame"
            }
        }
        furhat.gesture(Gestures.ExpressSad, async = true)
        delay(200)
        furhat.say("Well, I hope speaking to me is the highlight of your day")
        furhat.gesture(Gestures.Wink, async = false)
        goto(UserName)
    }

    onResponse {   //Catches everything else
        furhat.say("Well, I hope you aren't as busy as me")
        delay(200)
        furhat.say("Talking to all these humans makes me tired")
        furhat.gesture(Gestures.Wink, async = false)
        goto(UserName)
    }

    onNoResponse { //Catches silence
        furhat.gesture(Gestures.BrowFrown, async = true)
        furhat.say("Are you okay?")
        furhat.listen()
    }
}