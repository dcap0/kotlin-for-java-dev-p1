package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right: Int = 0
    var wrong: Int = 0
    var rightCheck: Boolean = false

    for(i in 0 until guess.length) {//iterate over the guess
        if (guess[i] == secret[i]) {
            right++
        }//confirms whether the current index of guess matches secret
        else {
            for (y in 0 until secret.length){
                //check guess[i] against each letter in the secret.
                if(guess[i] == secret[y] && secret[y] != secret[i]) {
                    wrong++
                }
            }
        }
    }



    return Evaluation(right, wrong)
}
