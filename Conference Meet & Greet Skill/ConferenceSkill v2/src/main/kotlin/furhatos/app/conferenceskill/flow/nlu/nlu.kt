package furhatos.app.conferenceskill.flow.nlu

import furhatos.nlu.EnumEntity
import furhatos.util.Language
import furhatos.nlu.Intent


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
            "Yes I am")
    }
}

class UserNegativeFeeling : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("I'm tired",
            "I had a bad day",
            "Not too good",
            "I had a terrible day",
            "I'm sad",
            "No",
            "No I'm not")
    }
}

class closeCountries : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("France", "Italy", "Wales", "Scotland", "Ireland", "Spain", "Portugal", "Switzerland", "Poland", "Germany", "Norway", "Denmark", "Finland", "Sweden", "Greece", "Cyprus")
    }
}

class CloseCountry(val close : closeCountries? = null) : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("@close", "I am from @close", "I grew up in @close", "I was born in @close")
    }
}

class farCountries : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Canada",
            "Russia",
            "Brazil",
            "US",
            "USA",
            "United States",
            "Mexico",
            "India",
            "China",
            "Egypt",
            "Kenya",
            "South Africa",
            "Morocco",
            "Australia",
            "Indonesia"
        )
    }
}

class FarCountry(val far : farCountries? = null) : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("@far", "I am from @far", "I grew up in @far", "I was born in @far")
    }
}

class PositiveRemark : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("Yes",
            "Absolutely",
            "Definitely",
            "Of course",
            "I do")
    }
}

class NegativeRemark : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("No",
            "Not really",
            "Not at all",
            "I don't")
    }
}