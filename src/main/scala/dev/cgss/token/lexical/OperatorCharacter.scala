package dev.cgss.token.lexical

case class OperatorCharacter(char: Char) extends LexicalToken

object OperatorCharacter {

  def apply(char: Char): Option[OperatorCharacter] = char match {
    case ' ' | '!' | '#' | '%' | '&' | '*' | '+' | '-' | '/' | ':'
         | '<' | '=' | '>' | '?' | '@' | '\\' | '^' | '|' | '~' => Some(new OperatorCharacter(char))
    case _ => None
  }

}
