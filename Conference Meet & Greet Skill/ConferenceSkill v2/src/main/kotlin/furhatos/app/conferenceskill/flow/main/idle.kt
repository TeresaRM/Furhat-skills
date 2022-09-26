package furhatos.app.conferenceskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.records.Location

val Idle: State = state {

    init {
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(Greeting)
        }
    }

    onEntry {
        val location1 = Location(1.0, 0.0, 1.0)    //Attend 1m to the right and 1m in front of the robot
        val location2 = Location(-1.0, 0.0, 1.0)   //Attend 1m to the left and 1m in front of the robot
        val location3 = Location(-0.5, 0.0, 0.0)
        val location4 = Location(0.5, 0.0,1.0)
        furhat.attend(location1)
        furhat.gesture(Gestures.Blink, async = true)
        furhat.gesture(Gestures.GazeAway, async = false)
        delay(5000)
        furhat.attend(location3)
        furhat.gesture(Gestures.Blink, async = true)
        furhat.gesture(Gestures.GazeAway, async = false)
        delay(5000)
        furhat.attend(location4)
        furhat.gesture(Gestures.Blink, async = true)
        furhat.gesture(Gestures.GazeAway, async = false)
        delay(5000)
        furhat.attend(location2)
        furhat.gesture(Gestures.Blink, async = true)
        delay(5000)
        reentry()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Greeting)
    }
}
