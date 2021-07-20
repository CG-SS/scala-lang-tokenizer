package dev.cgss.token

import scala.language.implicitConversions

package object lexical {

  implicit def enrichString(string: String): RichString = new RichString(string)

}

package lexical {

  private[lexical] class RichString(string: String) {
    def toLexicalTokens: Seq[LexicalToken] = LexicalToken(string)
  }

}
