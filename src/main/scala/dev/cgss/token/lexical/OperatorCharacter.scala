package dev.cgss.token.lexical

case class OperatorCharacter(char: Char) extends LexicalToken

object OperatorCharacter {

  def apply(char: Char): OperatorCharacter = char match {
    case ' ' | '!' | '#' | '%' | '&' | '*' | '+' | '-' | '/' | ':'
         | '<' | '=' | '>' | '?' | '@' | '\\' | '^' | '|' | '~' => new OperatorCharacter(char)
    case _ => throw LexicalTokenException(s"Unknown OperatorCharacter $char!")
  }

}
