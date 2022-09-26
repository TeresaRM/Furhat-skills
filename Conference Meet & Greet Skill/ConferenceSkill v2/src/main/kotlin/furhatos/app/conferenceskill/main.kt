package furhatos.app.conferenceskill

import furhatos.app.conferenceskill.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class ConferenceskillSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}

//For physical furhat interaction use: -Dfurhatos.skills.brokeraddress=192.168.1.103 (Furhat 1)