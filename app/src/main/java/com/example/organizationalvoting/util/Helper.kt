package com.example.organizationalvoting.util

class Helper {
    companion object{
        fun getPresidentData(): Array<String>{
            return arrayOf("Rastaman", "Manny Pacquiao", "Bong Go")
        }
        fun getVicePresident(): Array<String>{
            return arrayOf("Kobe Bryant", "Kyrie Irving", "Klay Thompson")
        }
        fun getSecretary(): Array<String>{
            return arrayOf("Harry Roque", "Harry Potter", "Emma Watson")
        }
        fun getTreasurer(): Array<String>{
            return arrayOf("Dwayne Wade", "LeBron James", "Stephen Curry")
        }
        fun getPro(): Array<String>{
            return arrayOf("Tim Duncan", "Michael Jordan", "Luka Doncic")
        }
    }
}