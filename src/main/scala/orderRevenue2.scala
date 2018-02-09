/**
  * Created by Omkar.Prabhudesai on 29-12-2017.
  */

import scala.io.Source

object orderRevenue2{

  def main(args:Array[String])={

    val orderId = args(0).toInt
    // format of part-00000 file - 2,2,1073,1,199.99,199.99 -
    val orderItems = Source.fromFile("C:\\Learn\\scala\\data-master\\retail_db\\order_items\\part-00000").getLines();

    val orderRevenue = orderItems.
      filter(o => o.split(",")(1).toInt == orderId).
      map(o => o.split(",")(4).toFloat).
      reduce((x,y) => x + y)
    println(orderRevenue)

  }
}

