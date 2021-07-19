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

  def apply(char: Char): DelimiterCharacter = char match {
    case '`' => BacktickDelimiter()
    case '\'' => SingleQuoteDelimiter()
    case '"' => DoubleQuoteDelimiter()
    case '.' => DotDelimiter()
    case ';' => SemicolonDelimiter()
    case ',' => CommaDelimiter()
    case _ => throw LexicalTokenException(s"Could not parse DelimiterCharacter $char!")
  }

}
