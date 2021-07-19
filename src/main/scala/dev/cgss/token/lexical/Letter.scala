package dev.cgss.token.lexical

trait Letter extends LexicalToken

final case class UpperCaseLetter(char: Char) extends Letter

final case class LowerCaseLetter(char: Char) extends Letter

final case class SpecialLetter(char: Char) extends Letter

object Letter {

  def apply(char: Char): Option[Letter] = char match {
    case upperCaseChar if char.isUpper => Some(UpperCaseLetter(upperCaseChar))
    case lowerCaseLetter if char.isLower => Some(LowerCaseLetter(lowerCaseLetter))
    case '\u0024' | '\u005F' => Some(SpecialLetter(char))
    case _ => None
  }

}
