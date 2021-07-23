package dev.cgss.token.identifier

import dev.cgss.token.lexical.LexicalToken

/*
op       ::=  opchar {opchar}
varid    ::=  lower idrest
boundvarid ::=  varid
| ‘`’ varid ‘`’
plainid  ::=  upper idrest
|  varid
|  op
id       ::=  plainid
|  ‘`’ { charNoBackQuoteOrNewline | escapeSeq } ‘`’
idrest   ::=  {letter | digit} [‘_’ op]
escapeSeq     ::= UnicodeEscape | charEscapeSeq
UnicodeEscape ::= ‘\’ ‘u’ {‘u’} hexDigit hexDigit hexDigit hexDigit
hexDigit      ::= ‘0’ | … | ‘9’ | ‘A’ | … | ‘F’ | ‘a’ | … | ‘f’
*/

trait IdentifierToken{
  def lexicalTokenSeq: Seq[LexicalToken]
}

object IdentifierToken {

  def apply(lexicalTokenSeq: Seq[LexicalToken]): IdentifierToken = ???

}
