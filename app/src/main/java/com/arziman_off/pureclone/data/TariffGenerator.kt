package com.arziman_off.pureclone.data


import com.arziman_off.pureclone.domain.Banner
import com.arziman_off.pureclone.domain.Tariff

object TariffGenerator {
    fun generateTariffs(): List<Tariff> {
        val tariffs = mutableListOf<Tariff>()
        for (i in 1..3) {
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
        }
        return tariffs
    }
}
