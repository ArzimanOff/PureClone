package com.arziman_off.pureclone.data


import kotlin.random.Random

object CountOfTemptationsGenerator {
    fun generateCountOfTemptations(): Int {
        return Random.nextInt(1, 30)
    }
}
