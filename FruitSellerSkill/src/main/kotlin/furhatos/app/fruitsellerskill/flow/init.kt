package furhatos.app.fruitsellerskill.flow

import furhatos.app.fruitsellerskill.flow.main.Idle
import furhatos.app.fruitsellerskill.setting.distanceToEngage
import furhatos.app.fruitsellerskill.setting.maxNumberOfUsers
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice

val Init : State = state() {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(distanceToEngage, maxNumberOfUsers)
        furhat.voice = Voice("Matthew")

        furhat.setMask("adult", "Kione")
        /* can also do furhat.mark = "some_mask"
           and also furhat.character = "some_character"
         */

        /** start the interaction */
        goto(Idle)
    }
}