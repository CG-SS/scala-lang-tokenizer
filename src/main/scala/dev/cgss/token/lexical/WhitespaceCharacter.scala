package dev.cgss.token.lexical

final case class WhitespaceCharacter(char: Char) extends LexicalToken

object WhitespaceCharacter {

  //  \u0020 | \u0009 | \u000D | \u000A.
  def apply(char: Char): WhitespaceCharacter = char match {
    case '\u0020' | '\u0009' | '\u000D' | '\u000A' => new WhitespaceCharacter(char)
    case _ =>
  }

}
