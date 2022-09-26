package furhatos.app.opendayskill.flow.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class UserPositiveFeeling : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I'm good thank you",
            "I'm fine",
            "I'm good",
            "I'm ok",
            "I'm okay",
            "I'm doing good",
            "All good",
            "I'm doing amazing",
            "I'm alright",
            "Not too bad",
            "Yes",
            "Yes I am",
            "So far so good")
    }
}

class UserNegativeFeeling : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I'm tired",
            "I had a bad day",
            "Not too good",
            "I had a terrible day",
            "I'm sad",
            "No",
            "No I'm not")
    }
}

class uni_subjects : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("Chemistry",
            "Physics",
            "Aerospace engineering",
            "Chemical engineering",
            "Mechanical engineering",
            "Mechatronic engineering",
            "Robotic engineering",
            "Computer Science",
            "Computer systems engineering",
            "Bioengineering",
            "Civil and structural engineering",
            "Electronic engineering",
            "Electrical engineering",
            "Materials Science",
            "General engineering",
            "Engineering",
            "AMRC apprenticeship")
    }
}

class PossibleSubjects(val subject : uni_subjects? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@subject", "@subject engineering", "I want to study @subject", "I would like to do @subject", "I think @subject is interesting", "I am considering @subject")
    }
}

class DontKnow: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I don't know",
            "I haven't thought about it yet",
            "I don't care",
            "I haven't thought about it",
            "I haven't decided yet",
            "I haven't decided",
            "I'm indecisive",
            "I'm uncertain"
        )
    }
}

class PositiveRemark : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes",
            "Absolutely",
            "Definitely",
            "Of course",
            "I do")
    }
}

class NegativeRemark : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("No",
            "Not really",
            "Not at all",
            "I don't")
    }
}