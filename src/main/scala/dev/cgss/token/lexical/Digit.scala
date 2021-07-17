package dev.cgss.token.lexical

final case class Digit(char: Char) extends LexicalToken

object Digit {

  def apply(char: Char): Digit = char match {
    case '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => new Digit(char)
    case _ => throw LexicalTokenException(s"Unknown digit $char!")
  }

}
