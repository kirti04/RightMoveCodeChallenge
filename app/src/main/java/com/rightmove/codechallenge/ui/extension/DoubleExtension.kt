package com.rightmove.codechallenge.ui.extension

import java.math.RoundingMode
import java.text.DecimalFormat

val Double.formattedString: String
    get() = DecimalFormat().apply {
        roundingMode = RoundingMode.HALF_EVEN
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }.format(this)
