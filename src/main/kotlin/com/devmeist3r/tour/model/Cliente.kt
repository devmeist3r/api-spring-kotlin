package com.devmeist3r.tour.model

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Cliente(
  @JsonProperty("matricula")
  val id: Long,
  val nome: String,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - " +
      "hh:mm:ss")
  val dataNascimento: Date,
  var telefone: Telefone?
)

@JsonIgnoreProperties("tipo")
data class Telefone(
  val ddd: String = "",
  val numero: String = "",
  val tipo: String = ""
//  @JsonIgnore val tipo: String = ""
)
