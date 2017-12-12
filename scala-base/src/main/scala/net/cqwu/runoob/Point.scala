package net.cqwu.runoob

/**
  * Scala中的类不声明为public，一个Scala源文件中可以有多个类。
  * Scala 的类定义可以有参数，称为类参数，如上面的 xc, yc，类参数在整个类中都可以访问。
  *Scala继承一个基类跟Java很相似, 但我们需要注意以下几点：
    1、重写一个非抽象方法必须使用override修饰符。
    2、只有主构造函数才可以往基类的构造函数里写参数。
    3、在子类中重写超类的抽象方法时，你不需要使用override关键字。
  Scala 单例对象
在 Scala 中，是没有 static 这个东西的，但是它也为我们提供了单例模式的实现方法，那就是使用关键字 object。
Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数。
当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象：companion object。你必须在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类：companion class。类和它的伴生对象可以互相访问其私有成员。
  */
class Point(val xc: Int,val yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int,dy: Int): Unit = {
    x = x + dy
    y + y + dy
    println("x 的坐标点: " + x)
    println("y 的坐标点: " + y)
  }
}

class Location(override val xc :Int,override val yc: Int,val zc: Int) extends Point(xc,yc) {
  var z: Int = zc

  def move(dx: Int,dy: Int,dz: Int): Unit = {
    x = x + dx
    y = y + dy
    z = z + dz
  }

}

class Person {
  var name = ""

  override def toString: String =  getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0

  override def toString: String = super.toString + "[salary=" + salary + "]"
}


object Test {
  def main(args: Array[String]): Unit = {
    val pt = new Point(10,20)
    pt.move(1,2)
  }
}
//伴生对象实例

/**
  * 私有构造法
  * @param color
  */
class Marker private(val color: String) {
    println("创建" + this)

  override def toString: String =  "颜色标记："+ color
}

// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object Marker {
  private val markers: Map[String, Marker] = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

}
/**
  * Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。
与接口不同的是，它还可以定义属性和方法的实现。
  */

trait Equal {
  def isEqual(x: Any):Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class TestEqual(xc: Int,yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(x: Any): Boolean = {
    x.isInstanceOf[TestEqual] && x.asInstanceOf[TestEqual].x == x
  }
}