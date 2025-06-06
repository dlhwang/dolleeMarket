package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.Catalog
import com.dollee.market.dolleeMarket.utills.NanoId
import jakarta.persistence.*

@Entity
@Table(name = "catalog")
class CatalogEntity (
    @Id
    @NanoId
    val id: String? = null,
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("parent_id")
    val parent: CatalogEntity? = null,

    @OneToMany(mappedBy = "parent")
    val children: List<CatalogEntity> = listOf(),

    @Embedded
    val description: Description,

    @Embedded
    val metadata: Metadata,

    val displayOrder: Int = 0,       // 노출 우선순위

) {
    fun toDomain(): Catalog {
        return Catalog(id!!, name, null!!) //todo
    }
}