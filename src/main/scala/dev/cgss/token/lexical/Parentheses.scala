package dev.cgss.token.lexical

abstract class Parentheses(c: Char) extends LexicalToken {
  override def char: Char = c
}

final case class OpenParentheses() extends Parentheses('(')

final case class CloseParentheses() extends Parentheses(')')

final case class OpenSquareBrackets() extends Parentheses('[')

final case class CloseSquareBrackets() extends Parentheses(']')

final case class OpenCurlyBrackets() extends Parentheses('{')

final case class CloseCurlyBrackets() extends Parentheses('}')

object Parentheses {

  def apply(char: Char): Parentheses = char match {
    case '(' => OpenParentheses()
    case ')' => CloseParentheses()
    case '[' => OpenSquareBrackets()
    case ']' => CloseSquareBrackets()
    case '{' => OpenCurlyBrackets()
    case '}' => CloseCurlyBrackets()
    case _ => throw LexicalTokenException(s"Unknown parentheses $char!")
  }

}
