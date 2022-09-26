package furhatos.app.opendayskill.flow

import furhatos.app.opendayskill.flow.main.Idle
import furhatos.app.opendayskill.setting.maxNumberOfUsers
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.users
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
