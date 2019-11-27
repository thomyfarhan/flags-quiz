package com.aesthomic.flagsquiz

object QuestionData {

    val listQuestion: MutableList<Question>
        get() {
            val list = mutableListOf<Question>()
            questionData.forEach {
                list.add(it)
            }
            return list
        }

    private val questionData = arrayOf (
        Question (
            "flag_turkmenistan",
            listOf("Turkmenistan", "Zimbabwe", "Grenada")
        ),
        Question (
            "flag_eritrea",
            listOf("Eritrea", "Dominica", "Comoros")
        ),
        Question (
            "flag_belize",
            listOf("Belize", "Antigua and Barbuda", "Benin")
        ),
        Question (
            "flag_burkina_faso",
            listOf("Burkina Faso", "Cape Verde", "Burundi")
        ),
        Question (
            "flag_bhutan",
            listOf("Bhutan", "Barbados", "Cyprus")
        ),
        Question (
            "flag_lesotho",
            listOf("Lesotho", "Kribati", "Libya")
        ),
        Question (
            "flag_nauru",
            listOf("Nauru", "Nicaragua", "Suriname")
        ),
        Question (
            "flag_tajikistan",
            listOf("Tajikistan", "Syria", "Mozambique")
        ),
        Question (
            "flag_namibia",
            listOf("Namibia", "Micronesia", "Gambia")
        ),
        Question (
            "flag_sri_lanka",
            listOf("Sri Lanka", "Palau", "Niue")
        ),
        Question (
            "flag_saint_lucia",
            listOf("Saint Lucia", "Swaziland", "Tonga")
        ),
        Question (
            "flag_lebanon",
            listOf("Lebanon", "Georgia", "Benin")
        ),
        Question (
            "flag_macedonia",
            listOf("Macedonia", "Maldives", "Mauritius")
        ),
        Question (
            "flag_kazakhstan",
            listOf("Kazakhstan", "Djibouti", "Angola")
        ),
        Question (
            "flag_afghanistan",
            listOf("Afghanistan", "Comoros", "Dominica")
        )
    )
}