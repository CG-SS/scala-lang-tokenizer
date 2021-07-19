package dev.cgss.token.lexical

//  ‘`’ | ‘'’ | ‘"’ | ‘.’ | ‘;’ | ‘,’

abstract class DelimiterCharacter(c: Char) extends LexicalToken {
  override def char: Char = c
}

final case class BacktickDelimiter() extends DelimiterCharacter('`')

final case class SingleQuoteDelimiter() extends DelimiterCharacter('\'')

final case class DoubleQuoteDelimiter() extends DelimiterCharacter('"')

final case class DotDelimiter() extends DelimiterCharacter('.')

final case class SemicolonDelimiter() extends DelimiterCharacter(';')

final case class CommaDelimiter() extends DelimiterCharacter('`')

object DelimiterCharacter {

  def apply(char: Char): Option[DelimiterCharacter] = char match {
    case '`' => Some(BacktickDelimiter())
    case '\'' => Some(SingleQuoteDelimiter())
    case '"' => Some(DoubleQuoteDelimiter())
    case '.' => Some(DotDelimiter())
    case ';' => Some(SemicolonDelimiter())
    case ',' => Some(CommaDelimiter())
    case _ => None
  }

}
