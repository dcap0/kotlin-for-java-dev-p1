package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretMutable = secret
    var replacementChar: Int = 0
    var right: Int = 0
    var wrong: Int = 0
    println(secret)



    for(i in 0 until guess.length) {//iterate over the guess, increments the right counter and replaces the value of secretMutable[i] to "0"
        if (guess[i] == secretMutable[i]) {
            right++
            secretMutable = secretMutable.replaceFirst(secretMutable[i], replacementChar.toChar())
            println(secretMutable)
        }//confirms whether the current index of guess matches secret
        else {
            for (y in 0 until guess.length){
                if(guess[i] == secretMutable[y]) {
                    wrong++
                    secretMutable = secretMutable.replaceFirst(secretMutable[y],replacementChar.toChar())
            }
            }
        }
    }



    return Evaluation(right, wrong)
}
