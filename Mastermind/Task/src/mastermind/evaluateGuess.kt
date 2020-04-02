package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretMutable = secret
    var guessMutable = guess

    var right: Int = 0
    var wrong: Int = 0

    //println(guessMutable+" guess")
    //println(secretMutable+" secret")


    for(i in 0 until guess.length) {//for each index, iterate over, increment the counter, replace the letter of both secret and guess "cross both off"
        if (guess[i] == secretMutable[i]) {
            right++
            secretMutable = secretMutable.replaceFirst(secretMutable[i], 'S')//replace the letter in the secret
            guessMutable = guessMutable.replaceFirst(guessMutable[i], 'G')//replace the letter in the guess
        }
    }

    for(y in 0 until guess.length){
        if(secretMutable.contains(guessMutable[y])){
            wrong++
            secretMutable = secretMutable.replaceFirst(guessMutable[y], 'S')
        }
    }

    return Evaluation(right, wrong)
}
