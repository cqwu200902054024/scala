package net.cqwu.curry

import java.io.{FileInputStream, InputStream}

object Curry {
  //柯里化函数
  def sum(x: Int)(y: Int) = x + y
  def sum02(x: Int) = (y: Int) => x + y
  //利用scala 柯里化实现java7中的try-with-resource
  def withIOStream(stream: InputStream)(func: InputStream => Unit) = {
      try {
          func(stream)
      } finally {
        stream.close
      }
  }

  def read(stream: InputStream) = {
    println(stream.available())
  }
  def main(args: Array[String]): Unit = {
    println(sum(3)(4))
    println(sum02(2)(3))

    withIOStream(new FileInputStream("D:\\data\\in\\test.txt"))(read)
    withIOStream(new FileInputStream("D:\\data\\in\\test.txt")) {
      println("hello word")
      read
    }
    println("+++++++++++++++++=======++++++++++++")
    var list = List(1,2,3,4,5)
    //折叠操作是一个递归的过程，将上一次的计算结果代入到函数中

    val c = list.foldLeft[String]("start") {
      (x,y) => x + y
    }
    println(c)

    val cc = list.foldLeft[Int](10)((x,y) => x +y)
    println(cc)
  }

 //
}
