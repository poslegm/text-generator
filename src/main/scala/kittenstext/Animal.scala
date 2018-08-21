package kittenstext 

import Genders._
import RussianLanguageModel._
import NounCases._

class Animal(val kind: String, val color: String, val size: String, val gender: Gender) {
  def fullDescription: String = {
    size + sizeAdjectiveEnd(gender, Nominative) + " " +
      color + colorAdjectiveEnd(gender, Nominative) + " " +
      kind + nounEnd(gender, Nominative)
  }

  private def colorDescription(animal: Animal, nounCase: NounCase): String = {
    animal.color + colorAdjectiveEnd(animal.gender, nounCase) + " " +
      animal.kind + nounEnd(animal.gender, nounCase)
  }

  def addToScene(): String = {
    fullDescription.capitalize + " заходит в комнату. "
  }

  def removeFromScene(): String = {
    fullDescription.capitalize + " выходит из комнаты. "
  }

  def attack(target: Animal): String = {
    fullDescription.capitalize + " царапает " +
      colorDescription(target, Accusative) + "! "
  }

  def playWith(target: Animal): String = {
    colorDescription(this, Nominative).capitalize +
      " весело играется с " + colorDescription(target, Ablative) + ". "
  }
}
