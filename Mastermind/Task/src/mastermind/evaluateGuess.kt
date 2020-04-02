package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretMutable = secret
    var guessMutable = guess
    var replacementCharS: Int = 0
    var replacementCharG: Int = 1
    var right: Int = 0
    var wrong: Int = 0

    //println(guessMutable+" guess")
    //println(secretMutable+" secret")


    for(i in 0 until guess.length) {//for each index, iterate over, increment the counter, replace the letter of both secret and guess "cross both off"
        if (guess[i] == secretMutable[i]) {
            right++
            secretMutable = secretMutable.replaceFirst(secretMutable[i], replacementCharS.toChar())//replace the letter in the secret
            guessMutable = guessMutable.replaceFirst(guessMutable[i], replacementCharG.toChar())//replace the letter in the guess
        }
    }

    //println(guessMutable+" guess")
    //println(secretMutable+" secret")


    for(y in 0 until guess.length){//match the current item in the guess to each item in the secret
        if (secretMutable.contains(guessMutable[y]) && guessMutable[y]!= replacementCharG.toChar()) { //if secret contains the current iteration in guess and is not the replacement value
            var echo = guessMutable[y]//set the current guess to a variable.
            var repeats: Int = guessMutable.count{ it == echo }//get the number of repeats in the guess.
            wrong += repeats//increment the counter by the number of repeats.
            for(x in 0 until guess.length){//change every value equal to echo to the replacement character.
                if(guessMutable[x] == echo){
                    guessMutable = guessMutable.replace(guessMutable[x], replacementCharG.toChar())
                }
            }
        }
    }


    //println(guessMutable+" guess")
   // println(secretMutable+" secret")



    return Evaluation(right, wrong)
}
