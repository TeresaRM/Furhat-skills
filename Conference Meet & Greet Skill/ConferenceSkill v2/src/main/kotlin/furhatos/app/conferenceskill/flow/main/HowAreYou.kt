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
                + "How are you doing this fine ${if (current.dayOfWeek.value == 2) "Tuesday" else "summer day"}?"
                + "How are you doing?"
                + "How are you doing today?"
                + "How are you feeling today?"
            }
        }
    }

    onResponse<UserPositiveFeeling> {
        furhat.gesture(Gestures.Smile, async = true)
        furhat.say {
            random {
                + "That's good to hear"
                + "I'm glad to hear that"
                + "Fantastic!"
            }
        }
        delay(200)
        goto(UserName)
    }

    onResponse<UserNegativeFeeling> {
        furhat.gesture(Gestures.ExpressSad, async = true)
        furhat.say {
            random {
                + "I'm sorry to hear that"
                + "That's a shame"
            }
        }
        delay(200)
        furhat.say("Well, I hope speaking to me is the highlight of your day")
        furhat.gesture(Gestures.Wink, async = false)
        delay(200)
        goto(UserName)
    }

    onResponse {   //Catches everything else
        furhat.say("Well, I hope you aren't as busy as me")
        delay(200)
        furhat.say("Talking to all these humans makes me tired")
        furhat.gesture(Gestures.Wink, async = false)
        delay(200)
        goto(UserName)
    }

    onNoResponse { //Catches silence
        furhat.gesture(Gestures.BrowFrown, async = false)
        furhat.say("Are you okay?")
        furhat.listen()
    }
}