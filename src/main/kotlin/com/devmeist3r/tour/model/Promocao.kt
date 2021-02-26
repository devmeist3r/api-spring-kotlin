package com.devmeist3r.tour.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Promocao(
  @Id
  val id: Long = 1,
  val descricao: String = "",
  val local: String = "",
  val isAllInclusive: Boolean = false,
  val qtdDias: Int = 1,
  val preco: Double = 0.0
)
