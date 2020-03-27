package mastermind

import kotlin.random.Random

//letters can only be in the range of A through F
val ALPHABET = 'A'..'F'
//The length the code player one has to put in.
//marked as compile time constant.
const val CODE_LENGTH = 4

fun main() {
    //set a boolean with false.
    val differentLetters = false
    //Start the game.
    playMastermind(differentLetters)
}
//declare the function to play the game.
fun playMastermind(
        //parameters, one boolean and one string.
        differentLetters: Boolean,
        secret: String = generateSecret(differentLetters) //The answer
) {
    var evaluation: Evaluation //new instance of Evaluation class.

    do {
        print("Your guess: ") //prompt user for input
        var guess = readLine()!!//take user input, asserts non null.
        while (hasErrorsInInput(guess)) { //passes guess into the hasErrorsInInput function.
            println("Incorrect input: $guess. " +//shows user's guess.
                    "It should consist of $CODE_LENGTH characters from $ALPHABET. " +//shows user constraints
                    "Please try again.")//being nice to users
            guess = readLine()!!//writes over guess with new input.
        }
        evaluation = evaluateGuess(secret, guess)//sets evaluation variable to the return value of evaluateGuess, whe we do.
        if (evaluation.isComplete()) { //if isComplete evaluates to true
            println("The guess is correct!") //print that
        } else { //otherwise
            println("Right positions: ${evaluation.rightPosition}; " + //print the correct number of guesses
                    "wrong positions: ${evaluation.wrongPosition}.") //print the number of incorrect guesses.
        }

    } while (!evaluation.isComplete()) //do all of the above while isComplete evaluates to false.
}

fun Evaluation.isComplete(): Boolean = rightPosition == CODE_LENGTH //extends the Evaluation class. Returns true or false depending on whether the number of correct positions match the code length.


fun hasErrorsInInput(guess: String): Boolean {
    val possibleLetters = ALPHABET.toSet() //takes the range of usable letters and makes it a set.
    return guess.length != CODE_LENGTH || guess.any { it !in possibleLetters } //return true if guess.length is not the asserted code length or if any of the guess are not in the possible letter set.
}

fun generateSecret(differentLetters: Boolean): String {//takes a boolean and puts
    val chars = ALPHABET.toMutableList()
    return buildString {
        for (i in 1..CODE_LENGTH) {
            val letter = chars[Random.nextInt(chars.size)]
            append(letter)
            if (differentLetters) {
                chars.remove(letter)
            }
        }
    }
}
