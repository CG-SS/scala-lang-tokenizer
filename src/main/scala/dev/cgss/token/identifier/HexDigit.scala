package dev.cgss.token.identifier

import dev.cgss.token.lexical.{Digit, Letter, LexicalToken, LowerCaseLetter, SpecialLetter, UpperCaseLetter}

final case class HexDigit(lexicalTokenSeq: Seq[LexicalToken]) extends IdentifierToken

//hexDigit      ::= ‘0’ | … | ‘9’ | ‘A’ | … | ‘F’ | ‘a’ | … | ‘f’
object HexDigit {

  def apply(lexicalToken: LexicalToken): Option[HexDigit] = lexicalToken match {
    case Digit(_) => valid(lexicalToken)
    case letter: Letter => letter match {
      case LowerCaseLetter(char) => char match {
        case 'a' | 'b' | 'c' | 'd' | 'e' | 'f' => valid(lexicalToken)
        case _ => None
      }
      case SpecialLetter(_) => None
      case UpperCaseLetter(char) => char match {
        case 'A' | 'B' | 'C' | 'D' | 'E' | 'F' => valid(lexicalToken)
        case _ => None
      }
      case _ => None
    }
  }

  private def valid(lexicalToken: LexicalToken) = Some(new HexDigit(Seq(lexicalToken)))

}
