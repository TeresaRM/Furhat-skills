package furhatos.app.firstskill.flow      //init is a transition state from start of the flow to Idle
                                          //init file is contained inside the flow folder
import furhatos.app.firstskill.flow.main.Idle
import furhatos.app.firstskill.setting.distanceToEngage
import furhatos.app.firstskill.setting.maxNumberOfUsers
import furhatos.event.responses.ResponseFace
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice


val Init : State = state() {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(distanceToEngage, maxNumberOfUsers)   // values defined at engagementParams.kt
        furhat.voice = Voice("Amy")                       //defining Furhat's voice
        /** start the interaction */
        goto(Idle)                                  // proceed to the first passive state: Idle
    }
}
