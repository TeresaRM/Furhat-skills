package furhatos.app.firstskill.flow

import furhatos.app.firstskill.flow.main.Idle
import furhatos.flow.kotlin.*

val Parent: State = state {     // this state is inherited by other states throughout the skill
                                             // STATE INHERITENCE
    onUserLeave(instant = true) {   // the instant = true flag means that the triggers
        when {                                              // will run simultaneously, with no blocking calls.
            users.count == 0 -> goto(Idle)
            it == users.current -> furhat.attend(users.other)
        }
    }

    onUserEnter(instant = true) {  //both onUserLeave and onUserEntry are handlers
        furhat.glance(it)
    }
}