package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right: Int = 0
    var wrong: Int = 0

    for (i in 0..secret.length){
        if (guess[i] == secret[i]){
            right++
        }
        else {wrong++}
    }

    return Evaluation(right, wrong)
}
