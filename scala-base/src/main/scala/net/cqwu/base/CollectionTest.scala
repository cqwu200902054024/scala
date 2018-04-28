package net.cqwu.base

object CollectionTest {
    def main(args: Array[String]):  Unit= {
        val list = List(1,2,3,4,5,6,6)
        val res = list.groupBy(w => w)
      println(res)
    }
}