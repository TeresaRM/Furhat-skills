package furhatos.app.conferenceskill.flow

import furhatos.app.conferenceskill.flow.main.Idle
import furhatos.app.conferenceskill.setting.maxNumberOfUsers
import furhatos.flow.kotlin.users
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice

val Init : State = state() {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(0.5,1.2,1.2,1.7, maxNumberOfUsers)
        furhat.voice = Voice("Amy")
        furhat.setMask("adult", "Isabel")

        /** start the interaction */
        goto(Idle)
    }
}
