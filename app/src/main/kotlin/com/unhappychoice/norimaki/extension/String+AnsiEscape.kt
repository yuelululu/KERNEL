
package com.unhappychoice.norimaki.extension

fun String.removeAnsiEscapeCode(): String = replace("\\033\\[\\d+?[A-T]".toRegex(), "")

fun String.replaceAnsiColorCodeToHtml(): String =
    split("(?=\\033\\[(\\d)+?m)".toRegex())
        .map { it.convertAnsiColorCodeToHtmlTag() }
        .joinToString("")
