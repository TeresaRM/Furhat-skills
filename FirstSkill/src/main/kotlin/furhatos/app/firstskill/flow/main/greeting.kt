package furhatos.app.firstskill.flow.main

import furhatos.app.firstskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Greeting : State = state(Parent) {    //this state inherits the Parent state (so handlers in
    onEntry {                        //the Parent state will be active in this state)
        furhat.ask("Should I say Hello World?")   //ask = say + listen
    }

    onResponse<Yes> {  //onResponse is a handler and Yes is an intent
        furhat.say("Hello World! .")                 //Yes and No are system-defined intents
    }

    onResponse<No> {
        furhat.say("Ok.")
    }
}
