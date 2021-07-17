package dev.cgss.token.lexical

import dev.cgss.token.TokenizerException

final case class LexicalTokenException(msg: String) extends TokenizerException(msg)
