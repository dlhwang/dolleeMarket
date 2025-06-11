package com.dollee.market.dolleeMarket.utills

import org.hibernate.annotations.IdGeneratorType

@IdGeneratorType(NanoIdGenerator::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class NanoId 
