package com.arziman_off.pureclone.data


import com.arziman_off.pureclone.domain.Banner
import com.arziman_off.pureclone.domain.Tariff

object TariffGenerator {
    fun generateTariffs(): List<Tariff> {
        val tariffs = mutableListOf<Tariff>()
        tariffs.add(
            Tariff(
                tariffs.size,
                1,
                99,
                false,
                ""
            )
        )
        tariffs.add(
            Tariff(
                tariffs.size,
                3,
                199,
                true,
                "Хит"
            )
        )
        tariffs.add(
            Tariff(
                tariffs.size,
                7,
                399,
                true,
                "-42%"
            )
        )
        tariffs.add(
            Tariff(
                tariffs.size,
                30,
                1299,
                true,
                "-20%"
            )
        )
        return tariffs
    }
}
