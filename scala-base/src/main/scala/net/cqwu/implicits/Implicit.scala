package net.cqwu.implicits

import java.util.{Calendar, Date}

object Implicit {
  //定义一个隐式转换方法
  implicit def converInt2DateHelper(num: Int) = new DateHelper(num)

    def main(args: Array[String]): Unit = {
      //中置表达式
      var  past = 2 days "ago"
      println(past)
    }




}

//隐式转换方法
class DateHelper(num: Int) {
  def days(when: String): Date = {
     var date = Calendar.getInstance
    when match {
      case "ago" => date.add(Calendar.DAY_OF_MONTH,-num)
      case "from_now" => date.add(Calendar.DAY_OF_MONTH,num)
      case _ => date
    }
    date.getTime
  }
}