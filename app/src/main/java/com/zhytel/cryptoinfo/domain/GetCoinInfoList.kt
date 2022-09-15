package com.zhytel.cryptoinfo.domain

class GetCoinInfoList(private val repository:CoinRepository) {
    operator fun invoke() = repository.getCoinInfoList()
}