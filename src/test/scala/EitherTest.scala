import org.scalatest.FunSuite

class EitherTest extends FunSuite{

  test("Create Either Right"){
    val r = Right("hello")
    println(r)
    println(r.b)
    println(r.isRight)
  }

  test("Create Either Left"){
    val r = Left("hi")
    println(r)
    println(r.a)
    println(r.isLeft)
  }

  test("Map an  Either"){
    val r:Either[String, Int] = Left("hi")
    val s:Either[String, Int] = Right(5)

    r.left.map(x => println("Left projection on Either: " + x))
    r.right.map(x => println("Right projection on Either: " + x))

    println("Getting left " + r.left.get)
    println("Getting right" + r.right.get)

//    r.fold()

  }



}
