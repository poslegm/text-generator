import RussianLanguageModel._
import Genders._

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Main {
	val Rand = new Random()

	def main(args: Array[String]) {
		// начальное число животных в комнате от 2 до 4
		val startAnimalsCount = Rand.nextInt(2) + 2
		val animals = ArrayBuffer.fill(startAnimalsCount)(generateRandomAnimal())
		print(
			"В комнате находятся: " + animals
					.map((a: Animal) => a.fullDescription).mkString(", ") + ". "
		)

		// добавляется ещё одно животное
		animals += generateRandomAnimal()
		print(animals.last.addToScene())

		// две пары случайных животных в случайном порядке
		// играют и царапаются друг с другом
		val pair = getDifferentAnimals(animals)
		if (Rand.nextBoolean()) {
			print(pair._1 playWith pair._2)
			print(pair._1 attack pair._2)
		} else {
			print(pair._1 attack pair._2)
			print(pair._1 playWith pair._2)
		}

		// удаление животного из комнаты
		val deathNumber = Rand.nextInt(animals.length)
		println(animals.remove(deathNumber).removeFromScene())
	}

	def generateRandomAnimal(): Animal = {
		val kind = NounRoots(Rand.nextInt(NounRoots.length))
		new Animal(
			kind, ColorRoots(Rand.nextInt(ColorRoots.length)),
			SizeRoots(Rand.nextInt(SizeRoots.length)),
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

	def randomElem(list: ArrayBuffer[Animal]) = list(Rand.nextInt(list.length))
}
