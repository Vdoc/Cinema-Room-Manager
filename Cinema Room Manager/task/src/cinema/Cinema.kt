package cinema

import java.util.*
/*
Stage 2/5: Sold!
*/
fun main() {
    println("Enter the number of rows:")
    val scanner = Scanner(System.`in`)
    val rows = scanner.nextInt()
    println("Enter the number of seats in each row:")
    val seatsInRow = scanner.nextInt()
    println("Total income:")
    val seats = rows * seatsInRow
    val income = when {
        seats < 60 -> seats * 10
        else -> (rows / 2) * seatsInRow * 10 + (rows - rows / 2) * seatsInRow * 8
    }
    println("$$income")
}



/*
Stage 1/5: Arrangement

fun main() {
    // write your code here
    print("Cinema:\n" +
            "  1 2 3 4 5 6 7 8\n" +
            "1 S S S S S S S S\n" +
            "2 S S S S S S S S\n" +
            "3 S S S S S S S S\n" +
            "4 S S S S S S S S\n" +
            "5 S S S S S S S S\n" +
            "6 S S S S S S S S\n" +
            "7 S S S S S S S S")
}
*/