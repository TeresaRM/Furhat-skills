package furhatos.app.firstskill           //firstskill is the name of the Furhat skill

import furhatos.app.firstskill.flow.*     //package definition and essential imports
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class FirstskillSkill : Skill() {        //defining the skill
    override fun start() {               //using the start() method to start the skill
        Flow().run(Init)                 //initialises a Dialog Flow (flow) - set of states and transitions
    }
}

fun main(args: Array<String>) {          //using the main() method to start the skill from the IDE
    Skill.main(args)
}
