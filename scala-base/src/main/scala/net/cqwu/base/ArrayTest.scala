package net.cqwu.base

import scala.collection.mutable.ArrayBuffer

object ArrayTest {
      def main(args: Array[String]): Unit = {
        //长度不变的数组声明
        //创建长度为10的数组，初始化元素为0
        val arr = new Array[Int](10)
        arr.foreach(println(_))
        //长度为2的数组，数据类型自动推断出来，已经提供初始值就不需要new关键字
        val s = Array("cai","yong")
        for(i <- 0 until s.length) {
          println(i)
        }
          //初始化变长数组
        val arrBuffer = ArrayBuffer[Int]()
        val arrBuffer1 = new ArrayBuffer[Int]()
        //数组末尾添加一个元素
        arrBuffer += 1
        //数组末尾添加多个元素
        arrBuffer += (2,3,4)
        arrBuffer.foreach(println)
        //数组末尾添加另外一个数组
        arrBuffer ++= Array(5,6,7)
        arrBuffer.foreach(println)
        //删除最后一个元素
        arrBuffer.trimEnd(1)
        arrBuffer.foreach(println)
        //删除最后2个元素
        arrBuffer.trimEnd(2)
        arrBuffer.foreach(println)
        //删除第一个元素
        arrBuffer.trimStart(1)
        arrBuffer.foreach(println)
        //删除前2个元素
        arrBuffer.trimStart(2)
        arrBuffer.foreach(println)
        //在指定位置插入多个元素
        arrBuffer.insert(0,1,2,3)
        println("++++++")
        arrBuffer.foreach(println)
        //删除指定位置元素
        arrBuffer.remove(0)
        println("++++++")
        arrBuffer.foreach(println)
        //删除指定位置以后的若干个元素
        arrBuffer.remove(0,3)
        println("++++++")
        arrBuffer.foreach(println)
        //Array与BufferArray相互转换
        val ab = ArrayBuffer(1,2,3)
        val res = ab.toArray
        val a = Array(4,5,6)
        val b = a.toBuffer
        //数组遍历
        val strs = Array("a","b","c","d")
        for(i <- 0 until strs.length) {
          println(i + ":" + strs(i))
        }
        //指定步长遍历
        for(i <- 0 until (strs.length,2)) {
          println(i + ":" + strs(i))
        }
         //逆序遍历
        for(i <- (0 until strs.length).reverse) {
          println(i + ":" + strs(i))
        }
        //增强for循环
        for(item <- strs) {
          println(item)
        }
        //一些实用的操作
        val test = Array(1,2,3,4,5,6)
        println(test.sum)
        println(test.max)
        println(test.min)
        println(test.mkString(","))
        println(test.mkString("(","-",")"))
        //生成器
        val testRes = for(item <- test if item % 2 == 0) yield item * 2
        testRes.foreach(println)
        println("++++++++++")
        val tr = test.filter(_ % 2 == 0).map(_ * 2)
        for (elem <- tr) {
          println(elem)
        }

      }
}
