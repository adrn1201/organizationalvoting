package com.example.organizationalvoting.util

class VotingHelper {
    companion object{
        fun getPresidentData(): Array<String>{
            return arrayOf("Choose a President","Rastaman", "Manny Pacquiao", "Bong Go")
        }
        fun getVicePresident(): Array<String>{
            return arrayOf("Choose a Vice President","Kobe Bryant", "Kyrie Irving", "Klay Thompson")
        }
        fun getSecretary(): Array<String>{
            return arrayOf("Choose a Secretary","Harry Roque", "Harry Potter", "Emma Watson")
        }
        fun getTreasurer(): Array<String>{
            return arrayOf("Choose a Treasurer","Dwayne Wade", "LeBron James", "Stephen Curry")
        }
        fun getPro(): Array<String>{
            return arrayOf("Choose a P.R.O.","Tim Duncan", "Michael Jordan", "Luka Doncic")
        }
    }
}