package com.devmeist3r.tour.controller

import com.devmeist3r.tour.model.Cliente
import com.devmeist3r.tour.model.SimpleObject
import com.devmeist3r.tour.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class JsonController {

  @GetMapping("/json")
  fun getJson() = SimpleObject()

  @GetMapping("/cliente")
  fun getCliente(): Cliente {
    var telefone = Telefone("61", "12345-6789", "fixo")
    var cliente = Cliente(1, "Leo", Date(), telefone)
    return cliente
  }

}
