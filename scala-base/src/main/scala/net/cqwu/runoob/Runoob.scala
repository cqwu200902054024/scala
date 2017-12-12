package net.cqwu.runoob

import java.util.Date

object Runoob {
    def main(args: Array[String]): Unit = {
      //call-by-name
      delayed(time())
      //一般情况下函数调用参数，就按照函数定义时的参数顺序一个个传递。但是我们也可以通过指定函数参数名，并且不需要按照顺序向函数传递参数
      addInt(b = 5, a =7)
      printStrings("ass","sdsdc")
      println(factorial(4))
      println(tailFactorial(4,1))
      println(add(6,7))
      println(applyed(layout,10))
      println(facOut(3))
      println(anonymity(1,2))
      //偏应用函数
      val date = new Date
      var printLog = log(date,_: String)
      printLog("hello word!")
      println(strcat("hello")("word"))
    }

  def addInt( a:Int, b:Int ) : Int = {
    println("a=" + a)
    println("b=" + b)
    var sum:Int = 0
    sum = a + b
    return sum
  }

  def time(): Long = {
    println("获取时间，单位为纳秒")
    System.nanoTime()
  }

  /**
    * Scala 允许你指明函数的最后一个参数可以是重复的，即我们不需要指定函数参数的个数，可以向函数传入可变长度参数列表。
    * @param args
    */
  def printStrings(args: String*) = {
    for(arg <- args) {
        println(arg)
    }
  }

  /**
    * 递归调用
    * @param n
    * @return
    */
  def factorial(n: Long): Long = {
    if(n == 1L) {
      return 1L
    }
    n * factorial(n - 1)
  }

  /**
    * 尾递归计算阶乘
    * @param n
    * @param sum
    * @return
    */
  def tailFactorial(n: Long,sum: Long): Long = {
      if(n == 1L) {
       return  sum
      }
      return tailFactorial(n - 1,n * sum)
  }

  /**
    * Scala 函数传名调用(call-by-name)
    Scala的解释器在解析函数参数(function arguments)时有两种方式：
    传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部；
    传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部
在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕，而传名调用是在函数内部进行参数表达式的值计算的。
这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。
 该方法在变量名和变量类型使用 => 符号来设置传名调用
    */
  def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  /**
    * Scala 可以为函数参数指定默认参数值，
    * 使用了默认参数，你在调用函数的过程中可以不需要传递参数，
    * 这时函数就会调用它的默认参数值，如果传递了参数，则传递值会取代默认值
    * @param a
    * @param b
    * @return
    */
  def add(a: Int = 5,b: Int = 7): Int = {
        var sum: Int = 0
            sum = a + b
        return sum
  }

  /**
    * 高阶函数（Higher-Order Function）就是操作其他函数的函数。
    *Scala 中允许使用高阶函数, 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果。
    * @param f
    * @param v
    * @return
    */
  def applyed(f: Int => String,v: Int) = f(v)
  def layout[A](x: A) = x.toString() + "匿名函数"

  /**
    * 我们可以在 Scala 函数内定义函数，定义在函数内的函数称之为局部函数。
    * @param i
    * @return
    */
  def facOut(i: Int): Long = {
     def factorialInner(n: Int,sum: Int): Long = {
       if(n <= 1) {
         return sum
       }
       return factorialInner(n - 1,n * sum)
     }
    return factorialInner(i,1)
  }

  /**
    * Scala 中定义匿名函数的语法很简单，箭头左边是参数列表，右边是函数体。
    */
  val anonymity = (x: Int,y: Int) => x + y
  def log(date: Date,message: String): Unit = {
    println(date + "-----" + message)
  }

  /**
    * 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有第二个参数为参数的函数。
    * @param s1
    * @param s2
    * @return
    */
  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }

  /**
    * 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。
    * 闭包通常来讲可以简单的认为是可以访问一个函数里面局部变量的另外一个函数。
    * 这里我们引入一个自由变量 factor，这个变量定义在函数外面。
    * 这样定义的函数变量 multiplier 成为一个"闭包"，因为它引用到函数外面定义的变量，定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数。
    */
  val factor = 3
  val multiplier = (i: Int) => i + factor
}

/**
  * 函数是一组一起执行一个任务的语句.
  * 在逻辑上，划分通常是根据每个函数执行一个特定的任务来进行的。
  * Scala 有函数和方法，二者在语义上的区别很小。Scala 方法是类的一部分，而函数是一个对象可以赋值给一个变量。换句话来说在类中定义的函数即是方法。
  * 我们可以在任何地方定义函数，甚至可以在函数内定义函数（内嵌函数）。更重要的一点是 Scala 函数名可以有以下特殊字符：+, ++, ~, &,-, -- , \, /, : 等。
  *def functionName ([参数列表]) : [return type]
  * 如果你不写等于号和方法主体，那么方法会被隐式声明为"抽象(abstract)"，包含它的类型于是也是一个抽象类型。
  * 函数定义:
  *方法定义由一个def 关键字开始，紧接着是可选的参数列表，一个冒号"：" 和方法的返回类型，一个等于号"="，最后是方法的主体。
  *
  */


/*
package functions {
  def addInt(a:Int,b:Int): Int = {
      var sum: Int = 0
      sum = a + b
      sum
  }
}*/
