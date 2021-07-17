package dev.cgss.token.lexical

trait Letter extends LexicalToken

final case class UpperCaseLetter(char: Char) extends Letter

final case class LowerCaseLetter(char: Char) extends Letter

final case class SpecialLetter(char: Char) extends Letter

object Letter {

  def apply(char: Char): Letter = char match {
    case upperCaseChar if char.isUpper => UpperCaseLetter(upperCaseChar)
    case lowerCaseLetter if char.isLower => LowerCaseLetter(lowerCaseLetter)
    case '\u0024' | '\u005F' => SpecialLetter(char)
    case _ => throw LexicalTokenException(s"Unknown letter $char!")
  }

}
