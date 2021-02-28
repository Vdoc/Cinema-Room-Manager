package cinema

import java.util.*
/*
Stage 3/5: Tickets
*/
fun main() {
    val cinema = initCinema()
    cinema.printScreenRoom()
    cinema.sellTicket()
    cinema.calculatePrice()
    cinema.printScreenRoom()
}

fun initCinema(): Cinema {
    println("Enter the number of rows:")
    val scanner = Scanner(System.`in`)
    val rows = scanner.nextInt()
    println("Enter the number of seats in each row:")
    val seatsInRow = scanner.nextInt()

    return Cinema(rows, seatsInRow)
}

class Cinema {

    var rows = 0
    var seatsInRow = 0
    var seats = 0
    var r = 0
    val m: Array<IntArray>

    var lostX = 0
    var lostY = 0

    val magicNomber = 1

    fun sellTicket() {
        print("Enter a row number:\n")
        val scanner = Scanner(System.`in`)
        val row = scanner.nextInt()

        print("Enter a seat number in that row:\n")
        val seat = scanner.nextInt()

        markPlace(row - 1, seat - 1)
    }

    private fun markPlace(row: Int, seat: Int) {
        if (getSeat(row, seat) == 0) m[row][seat] = magicNomber
        lostX = seat
        lostY = row
    }

    fun getSeat(row: Int, column: Int) = m[row][column]

    fun printScreenRoom() {
        var output = "\nCinema:\n"
        for (i in 0..rows) {
            for (j in 0..seatsInRow) {
                if (i == 0) {
                    if (j == 0) output += "  "
                    else output += "$j "
                    continue
                }
                if (j == 0) {
                    output += "$i "
                    continue
                }
                output += when (getSeat(i-1, j-1)) {
                    1 -> "B "
                    else -> "S "
                }
            }
            output += "\n"
        }
        output += "\n"
        print(output)
    }

    fun calculatePrice() {
        print("\nTicket price: ")
        val price = when {
            lostY < r -> 10
            else -> 8
        }
        print("$$price\n")
    }

    constructor (y: Int, x: Int) {
        this.seatsInRow = x
        this.rows = y
        this.seats = x * y
        if (seats < 60) r = y
        else r = rows / 2
        m = Array(y) { IntArray(x) }
    }
}




/*
Stage 2/5: Sold!

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
*/



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