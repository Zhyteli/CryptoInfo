package com.zhytel.cryptoinfo.data.mapper

import com.google.gson.Gson
import com.zhytel.cryptoinfo.data.database.CoinInfoDbModel
import com.zhytel.cryptoinfo.data.network.model.CoinInfoDto
import com.zhytel.cryptoinfo.data.network.model.CoinInfoJSContainerDto
import com.zhytel.cryptoinfo.data.network.model.CoinNameListDto
import com.zhytel.cryptoinfo.domain.entity.CoinInfo

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto) = CoinInfoDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastMarket = dto.lastMarket,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        imageUrl = dto.imageUrl
    )

    fun mapJSContainerToListCoinInfo(jsonContainer: CoinInfoJSContainerDto): List<CoinInfoDto> {
        val result = ArrayList<CoinInfoDto>()
        val jsonObject = jsonContainer.coinInfoJSContainer ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNameListDto): String {
        return namesListDto.names?.map { it.coinName?.name }?.joinToString(",")?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel) = CoinInfo(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastMarket = dbModel.lastMarket,
        lastUpdate = dbModel.lastUpdate,
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        imageUrl = dbModel.imageUrl
    )
}