package furhatos.app.opendayskill

import furhatos.app.opendayskill.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class OpendayskillSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}

//For physical furhat interaction use: -Dfurhatos.skills.brokeraddress=192.168.1.103