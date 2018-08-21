package kittenstext

import Genders._
import RussianLanguageModel._

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Main {
  def main(args: Array[String]) {
    // начальное число животных в комнате от 2 до 4
    val startAnimalsCount = Random.nextInt(2) + 2
    val animals = ArrayBuffer.fill(startAnimalsCount)(generateRandomAnimal())
    print(s"В комнате находятся: ${animals.map(_.fullDescription).mkString(", ")}. ")

    // добавляется ещё одно животное
    animals += generateRandomAnimal()
    print(animals.last.addToScene())

    // две пары случайных животных в случайном порядке
    // играют и царапаются друг с другом
    val pair = getDifferentAnimals(animals)
    if (Random.nextBoolean()) {
      print(pair._1 playWith pair._2)
      print(pair._1 attack pair._2)
    } else {
      print(pair._1 attack pair._2)
      print(pair._1 playWith pair._2)
    }

    // удаление животного из комнаты
    val deathNumber = Random.nextInt(animals.length)
    println(animals.remove(deathNumber).removeFromScene())
  }

  def generateRandomAnimal(): Animal = {
    val kind = NounRoots(Random.nextInt(NounRoots.length))
    new Animal(
      kind, 
      ColorRoots(Random.nextInt(ColorRoots.length)),
      SizeRoots(Random.nextInt(SizeRoots.length)),
      if (kind == "котён") Masculine else Feminine
    )
  }

  def getDifferentAnimals(animals: ArrayBuffer[Animal]): (Animal, Animal) = {
    val a = randomElem(animals)
    var b = randomElem(animals)
    while (a == b) {
      b = randomElem(animals)
    }
    a -> b
  }

  def randomElem(list: ArrayBuffer[Animal]) = list(Random.nextInt(list.length))
}
