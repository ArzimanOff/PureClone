package com.arziman_off.pureclone.data


import com.arziman_off.pureclone.domain.Banner

object BannersListGenerator {
    fun generateBanners(count: Int): List<Banner> {
        val banners = mutableListOf<Banner>()
        for (i in 1..count) {
            banners.add(
                Banner(
                    banners.size,
                    "Баннер №$i"
                )
            )
        }
        return banners
    }
}
