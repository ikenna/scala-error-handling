import org.scalatest.FunSuite
import scala.None

class OptionTest extends FunSuite {
  val o = Option("hi")

  test("Create an Option with a value"){
    println("Option with a value: "+ o)
    //Output: "Option with a value: Some(hi)"

    o.fold[Unit](println("Was empty"))( x => println("Was full"))
  }

  test("Create an Option with no value"){
    val o2 = Option(null)
    println("Option with no value: " + o2)
    //Output: "Option with no value: None"
  }

  test("Check an Option is empty"){
    val o2 = Option(null)
    println("Option o2 is empty? : "+ o2.isEmpty)
    //Output: "Option o2 is empty? : true"

    val o = Option("hi")
    println("Option o is empty? : "+ o.isEmpty)
    //Output: "Option o is empty? : false"
  }

  test("Option can check a value exists"){

    val result = o.exists(x => x.contains("hi"))
    println("Option o has value with matching predicate ? " + result)
    //Output: "Option o has value with matching predicate ? true"

    val o2 = Option[String](null)
    val result2 = o2.exists(x => x.contains("hi"))
    println("Option o2 has value with matching predicate ? " + result2)
    //Output : Option o2 has value with matching predicate ? false
  }

  test("Map an option that has a value"){

    o.map(x => println("Map an option with a value: " + x))
    //Output : "Map an option with a value: hi"
  }

  test("Map an option that is empty"){
    val o2 = Option(null)
    o2.map(x => println(x))
    //No output
  }

  test("Flat Map an option with a value"){

    val result = o.flatMap(x => Option(x))
    println("Flat Map on an option with a value yields: " + result)
    //Output: "Flat Map on an option with a value yields: Some(hi)"

    val o2 = Option(null)
    val result2 = o2.flatMap(x => Option(x))
    println("Flat Map on an option with a value yields: " + result2)
    //Output: "Flat Map on an option with a value yields: None"
  }


  test("Collect an option with a value"){
    val result = o.collect{case x:String => x}
    println("Collect on an option with a value yields:  " + result)
    //Output: "Collect on an option with a value yields:  Some(hi)"
  }

  test("Matching on an option"){
    o match {
      case Some(v) => println("Matching on o yields: " + v )
      case None => println("No value")
    }
    //Output: "Matching on o yields: hi"
  }

  test("Option in a for comprehension"){
    val result = for(i <- o) yield i
    println("Option o in a for comprehension yields: " + result)

    val o2 = Option(null)

    val result2 = for(i <- o2) yield i
    println("Option o2 in a for comprehension yields: " + result2)
  }
}
