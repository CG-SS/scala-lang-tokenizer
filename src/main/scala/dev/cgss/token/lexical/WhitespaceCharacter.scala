package dev.cgss.token.lexical

final case class WhitespaceCharacter(char: Char) extends LexicalToken

object WhitespaceCharacter {

  //  \u0020 | \u0009 | \u000D | \u000A.
  def apply(char: Char): Option[WhitespaceCharacter] = char match {
    case '\u0020' | '\u0009' | '\u000D' | '\u000A' => Some(new WhitespaceCharacter(char))
    case _ => None
  }

}
