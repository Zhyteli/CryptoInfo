package com.zhytel.cryptoinfo.domain

class GetCoinInfoListUseCase(private val repository:CoinRepository) {
    operator fun invoke() = repository.getCoinInfoList()
}