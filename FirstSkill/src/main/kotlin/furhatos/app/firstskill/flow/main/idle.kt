package furhatos.app.firstskill.flow.main     //idle file is contained inside the flow > main folder

import furhatos.flow.kotlin.*

val Idle: State = state {     // this state is to handle the resting behaviour of the Furhat

    init {     // this init method is run the first time the state is entered
        when {
            users.count > 0 -> {
                furhat.attend(users.random)
                goto(Greeting)
            }
            users.count == 0 && furhat.isVirtual() -> furhat.say("I can't see anyone. Add a virtual user please. ")
            users.count == 0 && !furhat.isVirtual() -> furhat.say("I can't see anyone. Step closer please. ")
        }
    }

    onEntry {
        furhat.attendNobody()      //this is added as transition resting action, between user interactions
    }                              // onEntry handler (or trigger) run everytime the idle state is transitioned

    onUserEnter {   // as soon as a virtual/real user enters, goto first active state
        furhat.attend(it)
        goto(Greeting)
    }
}
