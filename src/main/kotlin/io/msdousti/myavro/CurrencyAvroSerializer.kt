package io.msdousti.myavro

import com.github.avrokotlin.avro4k.decoder.ExtendedDecoder
import com.github.avrokotlin.avro4k.encoder.ExtendedEncoder
import com.github.avrokotlin.avro4k.schema.AvroDescriptor
import com.github.avrokotlin.avro4k.schema.NamingStrategy
import com.github.avrokotlin.avro4k.serializer.AvroSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.modules.SerializersModule
import org.apache.avro.LogicalType
import org.apache.avro.Schema
import org.apache.avro.SchemaBuilder
import java.util.Currency
import kotlin.reflect.jvm.jvmName

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Currency::class)
class CurrencyAvroSerializer : AvroSerializer<Currency>() {

    val currencyLogicalType: LogicalType = object : LogicalType(Currency::class.jvmName) {}

    override val descriptor: SerialDescriptor = object : AvroDescriptor(Currency::class.jvmName, PrimitiveKind.STRING) {
        override fun schema(
            annos: List<Annotation>,
            serializersModule: SerializersModule,
            namingStrategy: NamingStrategy,
        ): Schema {
            val schema: Schema = SchemaBuilder.builder().stringType()
            currencyLogicalType.addToSchema(schema)
            return schema
        }
    }

    override fun encodeAvroValue(schema: Schema, encoder: ExtendedEncoder, obj: Currency) {
        return encoder.encodeString(obj.currencyCode)
    }

    override fun decodeAvroValue(schema: Schema, decoder: ExtendedDecoder): Currency {
        return Currency.getInstance(decoder.decodeString())
    }
}
