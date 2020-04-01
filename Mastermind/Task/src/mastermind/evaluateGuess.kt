package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretMutable = secret
    var guessMutable = guess
    var replacementCharS: Int = 0
    var replacementCharG: Int = 1
    var replacementCharH: Int = 2
    var replacementCharI: Int = 3
    var right: Int = 0
    var wrong: Int = 0



    for(i in 0 until guess.length) {//for each index, iterate over, increment the counter, replace the letter of both secret and guess "cross both off"
        if (guess[i] == secretMutable[i]) {
            right++
            secretMutable = secretMutable.replaceFirst(secretMutable[i], replacementCharS.toChar())//replace the letter in the secret
            guessMutable = guessMutable.replaceFirst(guessMutable[i], replacementCharG.toChar())//replace the letter in the guess
        }
    }


    for (y in 0 until guess.length){//for each item in the array
        var echo = guessMutable[y]
        if(secretMutable.contains(guessMutable[y])){//if the current item exists
            wrong++//increment wrong counter
            guessMutable = guessMutable.replace(guessMutable[y], replacementCharH.toChar())//replace the letter in the guess
        }
    }



    return Evaluation(right, wrong)
}
