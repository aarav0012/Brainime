package com.example.brainime



object SetData {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1=QuestionData(
          "Which anime series features a group of high school students who possess the power to transform into weapons",
            1,
            "Soul Eater",
            "Hunter x Hunter",
            " Demon Slayer",
            " Bleach",
            1,
        )

        var q2=QuestionData(
            "Which anime series features a group of students with supernatural powers called \"Quirks\"?",
            2,
            " Attack on Titan",
            " One Piece",
            "Naruto",
            "My Hero Academia",
            4,
        )

        var q3=QuestionData(
            "In the anime \"My Hero Academia,\" what is the name of the protagonist, Izuku Midoriya?",
            3,
            "Deku",
            "Katsuki Bakugo",
            "Shoto Todoroki",
            "Tenya Iida",
            1,
        )

        var q4=QuestionData(
            "In the anime \"One Piece,\" what is the name of the rubber-powered protagonist's crew?",
            4,
            "Blackbeard Pirates",
            "Straw Hat Pirates",
            "Whitebeard Pirates",
            "Red Hair Pirates",
            2,
        )

        var q5=QuestionData(
            "Which anime series follows the adventures of a young alchemist named Edward Elric and his brother Alphonse?",
            5,
            "Death Note",
            "Attack on Titan",
            "Fullmetal Alchemist",
            "My Hero Academia",
            3,
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}