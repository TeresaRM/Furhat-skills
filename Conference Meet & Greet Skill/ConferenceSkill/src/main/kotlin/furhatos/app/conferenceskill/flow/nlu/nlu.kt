package furhatos.app.conferenceskill.flow.nlu

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
            "Not to good",
            "I had a terrible day",
            "I'm sad",
            "No",
            "No I'm not")
    }
}

class ColdCountries : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("Sweden",
            "Finland",
            "Denmark",
            "Norway",
            "Germany",
            "Poland",
            "Switzerland",
            "Scotland",
            "Canada",
            "Russia")
    }
}

class WarmCountries : Intent() {
    override fun getExamples(lang:Language): List<String> {
        return listOf("Spain",
            "Portugal",
            "Brazil",
            "France",
            "Italy",
            "Wales",
            "US",
            "USA",
            "Unites States",
            "Mexico",
            "India",
            "China",
            "Greece",
            "Cyprus",
            "Egypt",
            "Kenya",
            "Morocco",
            "Australia",
            "Indonesia")
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