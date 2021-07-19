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

  def apply(char: Char): Option[Parentheses] = char match {
    case '(' => Some(OpenParentheses())
    case ')' => Some(CloseParentheses())
    case '[' => Some(OpenSquareBrackets())
    case ']' => Some(CloseSquareBrackets())
    case '{' => Some(OpenCurlyBrackets())
    case '}' => Some(CloseCurlyBrackets())
    case _ => None
  }

}
