package furhatos.app.fruitsellerskill

import furhatos.app.fruitsellerskill.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class FruitsellerskillSkill : Skill() {
    override fun start() {                     //starts the FruitSeller skill
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)                          //connects to the Furhat SDK
}
