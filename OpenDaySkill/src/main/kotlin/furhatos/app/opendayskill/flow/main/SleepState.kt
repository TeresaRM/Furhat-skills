package furhatos.app.opendayskill.flow.main

import furhatos.app.opendayskill.flow.Init
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.records.Location


val SleepState : State = state {
    onEntry {
        val sleepLocation = Location(0.0,-0.5,0.0)
        furhat.attendNobody()
        furhat.gesture(Gestures.CloseEyes)
        furhat.attend(sleepLocation)
        delay(10000)

        if (users.count > 0) {
            reentry()
        }else
            furhat.gesture(Gestures.OpenEyes)
        goto(Idle)
    }

    onUserLeave {
        if (users.count > 0) {
            furhat.gesture(Gestures.OpenEyes)
            goto(Init)
        }else
            furhat.gesture(Gestures.OpenEyes)
        goto(Idle)
    }
}