package net.cqwu.runoob

/**
  * scala 访问修饰符：
  * private，protected，public。
  * 默认情况下，Scala对象的访问级别都是 public
  * Scala 中的 private 限定符，比 Java 更严格，在嵌套类情况下，外层类甚至不能访问被嵌套类的私有成员。
  */
class Outer {
   class Inner {
     private def f(): Unit = {
       println("f")
     }
     class InnerMost {
       f()//正确
     }
   }
  //(new Inner).f() //
  // (new Inner).f( ) 访问不合法是因为 f 在 Inner 中被声明为 private，而访问不在类Inner之内。
  //但在 InnerMost 里访问f就没有问题的，因为这个访问包含在 Inner 类之内。
  //Java中允许这两种访问，因为它允许外部类访问内部类的私有成员。
}

package p {
  class Supper {
    protected def f(): Unit = {
      println("f")
    }
  }
  class Sub extends Supper {
    f()
  }
  class Other {
    //(new Supper).f()//错误
  }

  /**
    * 在 scala 中，对保护（Protected）成员的访问比 java 更严格一些。
    * 因为它只允许保护成员在定义了该成员的的类的子类中被访问。而在java中，用protected关键字修饰的成员，
    * 除了定义了该成员的类的子类可以访问，同一个包里的其他类也可以进行访问。
    */
}

package bobsrocckets {
  /**
    * 作用域保护：
    * Scala中，访问修饰符可以通过使用限定词强调。格式为:
    * private[x]或protected[x]
    * 这里的x指代某个所属的包、类或单例对象。如果写成private[x],读作"这个成员除了对[…]中的类或[…]中的包中的类及它们的伴生对像可见外，
    * 对其它所有类都是private。
    */
  package navigation {
    private[bobsrocckets] class Navigator {
      protected[navigation] def useStartChart(): Unit = {}
        class LegOfJourner {
          private[Navigator] val distance = 100
        }
        private[this] var speed = 200
    }
  }
  package launch {
    import navigation._
    object Vehicle {
      private[launch] val guide = new Navigator
    }
  }

  /**
    * 类Navigator被标记为private[bobsrockets]就是说这个类对包含在bobsrockets包里的所有的类和对象可见。
    * 从Vehicle对象里对Navigator的访问是被允许的，因为对象Vehicle包含在包launch中，而launch包在bobsrockets中，相反，
    * 所有在包bobsrockets之外的代码都不能访问类Navigator。
    */
}
