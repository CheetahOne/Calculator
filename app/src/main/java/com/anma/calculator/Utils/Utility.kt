package com.anma.calculator.Utils

import javax.inject.Inject

open class Utility{

    fun formatNumber(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }

}