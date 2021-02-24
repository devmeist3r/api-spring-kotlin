package com.devmeist3r.tour.model

data class Promocao(
  val id: Long,
  val descricao: String,
  val local: String,
  val isAllInclusive: Boolean,
  val qtdDias: Int,
  val preco: Double
)
