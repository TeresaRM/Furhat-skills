package furhatos.app.opendayskill.flow

import furhatos.app.opendayskill.flow.main.Idle
import furhatos.flow.kotlin.*

val Parent: State = state {
    onUserLeave(instant = true) {
        when {
            users.count == 0 -> goto(Idle)
            it == users.current -> furhat.attend(users.other)
        }
    }

    onUserEnter(instant = true) {
        furhat.glance(it)
    }
}