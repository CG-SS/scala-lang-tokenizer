package dev.cgss.token.lexical

trait LexicalToken {
  def char: Char
}

object LexicalToken {

  def apply(string: String): Seq[LexicalToken] = string
    .flatten(c =>
      Seq(
        DelimiterCharacter(c),
        Digit(c),
        Letter(c),
        OperatorCharacter(c),
        Parentheses(c),
        WhitespaceCharacter(c)
      )
    )
    .filter(_.isDefined)
    .map(_.get)

}
