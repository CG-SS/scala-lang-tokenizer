package dev.cgss.token.identifier

import dev.cgss.token.lexical.{LexicalToken, LowerCaseLetter, OperatorCharacter}

sealed class UnicodeEscape(val hexDigit1: HexDigit, val hexDigit2: HexDigit, val hexDigit3: HexDigit, val hexDigit4: HexDigit) extends IdentifierToken

final case class ExtendedUnicodeEscape(
                                        h1: HexDigit,
                                        h2: HexDigit,
                                        h3: HexDigit,
                                        h4: HexDigit
                                      ) extends UnicodeEscape(h1, h2, h3, h4)

final case class DefaultUnicodeEscape(
                                       h1: HexDigit,
                                       h2: HexDigit,
                                       h3: HexDigit,
                                       h4: HexDigit
                                     ) extends UnicodeEscape(h1, h2, h3, h4)

// UnicodeEscape ::= ‘\’ ‘u’ {‘u’} hexDigit hexDigit hexDigit hexDigit
object UnicodeEscape {

  def apply(lexicalTokenSeq: Seq[LexicalToken]): Option[UnicodeEscape] = lexicalTokenSeq match {
    case Seq(OperatorCharacter(operatorChar), LowerCaseLetter(letter), l1@_, l2@_, l3@_, l4@_)
      if operatorChar == '\\' && letter == 'u' => {
      val hexDigit1 = HexDigit(l1)
      val hexDigit2 = HexDigit(l2)
      val hexDigit3 = HexDigit(l3)
      val hexDigit4 = HexDigit(l4)

      if (hexDigit1.isEmpty || hexDigit2.isEmpty || hexDigit3.isEmpty || hexDigit4.isEmpty) {
        None
      } else {
        Some(DefaultUnicodeEscape(hexDigit1.get, hexDigit2.get, hexDigit3.get, hexDigit4.get))
      }
    }
    case Seq(OperatorCharacter(operatorChar), LowerCaseLetter(letter), LowerCaseLetter(optLetter), l1@_, l2@_, l3@_, l4@_)
      if operatorChar == '\\' && letter == 'u' && optLetter == 'u' => {
      val hexDigit1 = HexDigit(l1)
      val hexDigit2 = HexDigit(l2)
      val hexDigit3 = HexDigit(l3)
      val hexDigit4 = HexDigit(l4)

      if (hexDigit1.isEmpty || hexDigit2.isEmpty || hexDigit3.isEmpty || hexDigit4.isEmpty) {
        None
      } else {
        Some(ExtendedUnicodeEscape(hexDigit1.get, hexDigit2.get, hexDigit3.get, hexDigit4.get))
      }
    }
    case _ => None
  }

}
