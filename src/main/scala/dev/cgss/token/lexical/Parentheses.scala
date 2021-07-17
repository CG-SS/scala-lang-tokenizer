package dev.cgss.token.lexical

final case class Parentheses(char: Char) extends LexicalToken

object Parentheses {

  def apply(char: Char): Parentheses = char match {
    case '(' | ')' | '[' | ']' | '{' | '}' => new Parentheses(char)
    case _ => throw LexicalTokenException(s"Unknown parentheses $char!")
  }

}
