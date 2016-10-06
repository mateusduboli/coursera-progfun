package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val positivesBelow10 = { x: Int => x >= 0 && x < 10}
    val evenNumbers      = { x: Int => x % 2 == 0}
    val oddNumbers       = { x: Int => x % 2 == 1}
   }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contain only the values in both sets") {
    new TestSets {
      val i = intersect(positivesBelow10, evenNumbers)
      assert(contains(i, 0), "Positive even")
      assert(contains(i, 2), "Positive even")
      assert(contains(i, 4), "Positive even")
      assert(contains(i, 6), "Positive even")
      assert(contains(i, 8), "Positive even")
      assert(!contains(i, 5), "Positive odd")
    }
  }

  test("diff contains all elements in s but not in f") {
    new TestSets {
      val d = diff(positivesBelow10, evenNumbers)
      assert(contains(d, 1), "Positive odd")
      assert(contains(d, 3), "Positive odd")
      assert(contains(d, 5), "Positive odd")
      assert(contains(d, 7), "Positive odd")
      assert(contains(d, 9), "Positive odd")
      assert(!contains(d, 2), "Positive even")
    }
  }

  test("filter should add a predicate to the resulting set") {
    new TestSets {
      val i = intersect(positivesBelow10, evenNumbers)
      assert(contains(i, 0), "Positive even")
      assert(contains(i, 2), "Positive even")
      assert(contains(i, 4), "Positive even")
      assert(contains(i, 6), "Positive even")
      assert(contains(i, 8), "Positive even")
      assert(!contains(i, 5), "Positive odd")
    }
  }

  test("forall should validate a predicate against the search space") {
    new TestSets {
      assert(forall(positivesBelow10, {x: Int => x < 10}), "Positive less than 10")
      assert(!forall(positivesBelow10, {x: Int => x > 10}), "Some number above 11")
    }
  }

  test("exists should validate a predicate against one element of the search space") {
    new TestSets {
      assert(exists(positivesBelow10, {x: Int => x == 9}), "A number equal to 10")
      assert(exists(positivesBelow10, {x: Int => x < 10}), "Positive less than 10")
      assert(!exists(positivesBelow10, {x: Int => x > 10}), "Some number above 11")
    }
  }

  test("map should validate a predicate against one element of the search space") {
    new TestSets {
      val doubleOfPositivesBelow10 = map(positivesBelow10, {x: Int => x * 2})
      assert(exists(doubleOfPositivesBelow10, { x: Int => x == 18}), "A number equal to 18")
      assert(forall(doubleOfPositivesBelow10, evenNumbers), "Are all even")
      assert(!exists(doubleOfPositivesBelow10, oddNumbers), "Not odd")
    }
  }

}
