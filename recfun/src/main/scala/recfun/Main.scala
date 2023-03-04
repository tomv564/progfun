package recfun
import common._

object Main {
  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    // numbers at the edge are 1:
    if (c == r || c == 0)
      return 1
    else
      return pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def isBalanced(chars: List[Char], depth: Int): Boolean = {

      if (chars.isEmpty)
        return (depth == 0)

      if (depth < 0)
        return false

      return isBalanced(chars.tail, adjustDepth(chars.head, depth))

    }

    def adjustDepth(char: Char, depth: Int): Int = {

      if (char == '(')
        return depth + 1
      else if (char == ')')
        return depth - 1
      else
        return depth
    }

    return isBalanced(chars, 0)

  }


  // /**
  //  * Exercise 3
  //  */
  def countChange(money: Int, coins: List[Int]): Int = {

      // 'try a coin' and 'try remaining coins ' were split but now combined. Sorting not needed.
      if (money < 0 || coins.isEmpty) // coin didn't fit or no coins left
        return 0
      else if (money == 0) // payment completed
        return 1
      else // always uses 'the same or the rest' of the coins to prevent duplicate combinations
        return countChange(money - coins.head, coins) + countChange(money, coins.tail)

  }
}
