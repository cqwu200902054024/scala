package net.cqwu.runoob

import net.cqwu.runoob.Collections.sets

object Collections {
    def main(args: Array[String]): Unit = {
      //字符串，数组，集合类测试
      //String是不可变得，可以使用StringBuilder创建一个可以字符串
      val sb = new StringBuilder
      sb += 'a'
      sb ++= "ssvsv"
      println(sb.toString)
      //创建格式化字符串
      var fs = printf("浮点型变量为 " +
        "%f, 整型变量为 %d, 字符串为 " +
        " %s",1.2,2,"hello")
      println(fs)
      //创建一个数组
      var srs = new Array[String](2)
      val strs = Array[String]("ada","cdsds")
      for(str <- strs) {
        println(str)
      }
      for(i <- 0 to strs.length - 1) {
        println(strs(i))
      }
      for(i <- 0 until args.length) {
        println(args(i))
      }
    }
  //多维数组
  var matrix = Array.ofDim[Int](3,3)
  for(i <- 0 to 2) {
    for(j <- 0 to 2) {
      matrix(i)(j) = j
    }
  }
  /**
    * Scala 集合分为可变的和不可变的集合。
    *可变集合可以在适当的地方被更新或扩展。这意味着你可以修改，添加，移除一个集合的元素。
    *而不可变集合类，相比之下，永远不会改变。不过，你仍然可以模拟添加，移除或更新操作。但是这些操作将在每一种情况下都返回一个新的集合，同时使原来的集合不发生改变。
    * scala 默认导入不可变集合
    */
  //List
  val nums: List[Int] = List(1,2,3,4,5,6)
  //空列表
  val empty: List[String] = List()
  val nilList: List[Int] = Nil//构建一个空列表
  //往集合中添加一个元素
    0 :: nilList
  //你可以使用 ::: 运算符或 List.:::() 方法或 List.concat() 方法来连接两个或多个列表
  //往集合中添加一个集合
  nilList ++ List(1)
  nilList ::: List(1,2,4,5,6)
  println("list size" + nilList.length)
  //引入可变集合
  import scala.collection.mutable.Set
  val sets = Set(1,2,3)
  sets.add(4)
  sets.add(5)
  sets += 6
  sets ++= Set(7,8)
  println(sets)
  import scala.collection.mutable.Map
  val maps = Map[Int,Int](1 -> 2,2 -> 3,3 -> 4)
  maps + (4 -> 5)
  println(maps)
  //元组可以包含不同类型的元素,元组的实际类型取决于它的元素的类型，目前 Scala 支持的元组最大长度为 22.
  val t = (1,2,"ss",2,.34)
  println(t._1)
  t.productIterator.foreach{x =>
     println(x)
  }
  val t2 = Tuple3(1,2,3)
  println(t2.toString())
  /**
    * Scala Option(选项)类型用来表示一个值是可选的（有值或无值)。
    *Option[T] 是一个类型为 T 的可选值的容器： 如果值存在， Option[T] 就是一个 Some[T] ，
    * 如果不存在， Option[T] 就是对象 None 。
    */
  val myMap: Map[String,String] = Map("key1" -> "value")
  val value1: Option[String] = myMap.get("key1")
  val value2: Option[String] = myMap.get("key2")
  println(show(value1))

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => ""
  }

  /**
    * Scala Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法。
    * 迭代器 it 的两个基本操作是 next 和 hasNext。
    */
}
