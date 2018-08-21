package kittenstext

import NounCases._
import Genders._

object RussianLanguageModel {
  val NounRoots = Array("котён", "кошк")
  val SizeRoots = Array("маленьк", "юрк", "гигантск")
  val ColorRoots = Array("пятнист", "полосат", "пушист", "чёрн", "сер")

  // мужской род для слова "котёнок", женский - для "кошка"
  def nounEnd(gender: Gender, nounCase: NounCase): String = {
    nounCase match {
      case Nominative    => if (gender == Masculine) "ок" else "а"
      case Genitive      => if (gender == Masculine) "ка" else "ы"
      case Dative        => if (gender == Masculine) "ку" else "е"
      case Accusative    => if (gender == Masculine) "ка" else "у"
      case Ablative      => if (gender == Masculine) "ком" else "ой"
      case Prepositional => if (gender == Masculine) "ке" else "е"
    }
  }

  def colorAdjectiveEnd(gender: Gender, nounCase: NounCase): String = {
    nounCase match {
      case Nominative    => if (gender == Masculine) "ый" else "ая"
      case Genitive      => if (gender == Masculine) "ого" else "ой"
      case Dative        => if (gender == Masculine) "ому" else "ой"
      case Accusative    => if (gender == Masculine) "ого" else "ую"
      case Ablative      => if (gender == Masculine) "ым" else "ой"
      case Prepositional => if (gender == Masculine) "ом" else "ой"
    }
  }

  def sizeAdjectiveEnd(gender: Gender, nounCase: NounCase): String = {
    nounCase match {
      case Nominative    => if (gender == Masculine) "ий" else "ая"
      case Genitive      => if (gender == Masculine) "ого" else "ой"
      case Dative        => if (gender == Masculine) "ому" else "ой"
      case Accusative    => if (gender == Masculine) "ого" else "ую"
      case Ablative      => if (gender == Masculine) "им" else "ой"
      case Prepositional => if (gender == Masculine) "ом" else "ой"
    }
  }
}
