package recfun

object Main {
  def main(args: Array[String]) {
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
      var a = 1
      var b = 1
      if (c > 0 && r > 0)
        a = pascal(c-1,r-1)

      if (c < r && r > 0)
        b = pascal(c,r-1)

      if (r<=1 || c==0 || c==r)
        1
      else
        a + b
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      var acc = 0
      def loop(acc: Int, chars: List[Char]): Boolean = {
        if(chars.isEmpty){
          acc == 0
        }else if(acc <0){
          false
        }
        else if(chars.head == '(')
          loop(acc + 1, chars.tail)
        else if (chars.head == ')')
          loop(acc - 1, chars.tail)
        else
          loop(acc, chars.tail)
      }
      loop(acc,chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
          if (money==0)
            1
          else if(coins.isEmpty || money < 0)
            0
          else if(coins.tail.isEmpty){
            if (money % coins.head == 0)
              1
            else
              0
          }else{
            countChange(money,coins.tail) + countChange(money - coins.head, coins)
          }
    }
  }
