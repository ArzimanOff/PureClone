package com.arziman_off.pureclone.data


import kotlin.random.Random

object CountOfLikesGenerator {
    fun generateCountOfLikes(): Int {
        return Random.nextInt(1, 100)
    }
}
