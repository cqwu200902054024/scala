package net.cqwu.implicits

import scala.io.Source

object Helpers {
    def main(args: Array[String]): Unit = {
       val input = Source.fromFile("D:\\spark\\examples\\src\\main\\resources\\people.json").getLines()
      for(x <- input) {
        println(x)
      }
    }
}
