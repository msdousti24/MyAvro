package io.msdousti.myavro

import kotlinx.serialization.Serializable
import java.util.Currency

@Serializable
data class DomainEvent(
    val id: Int,
    val name: String,
    @Serializable(CurrencyAvroSerializer::class)
    val currency: Currency,
)
