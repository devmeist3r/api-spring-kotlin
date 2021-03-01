package com.devmeist3r.tour.controller

import com.devmeist3r.tour.model.ErrorMessage
import com.devmeist3r.tour.model.Promocao
import com.devmeist3r.tour.model.RespostaJSON
import com.devmeist3r.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.xml.ws.Response


@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

  @Autowired
  lateinit var promocaoService: PromocaoService

  /**
   * Funcão para pegar promocao por id
   **/
  @GetMapping("/{id}")
  fun getById(@PathVariable id: Long): ResponseEntity<Any> {
    val promocao = this.promocaoService.getById(id)

    return if (promocao != null)
      return ResponseEntity(promocao, HttpStatus.OK)
    else
      return ResponseEntity(
        ErrorMessage("Promocão não localizada", "promoção ${id} não localizada"),
        HttpStatus.NOT_FOUND
      )
  }

//  @GetMapping("/{id}")
//  fun getById(@PathVariable id: Long): ResponseEntity<Promocao?> {
//    var promocao = this.promocaoService.getById(id) ?:
//    throw PromocaoNotFoundException("promocao $id nao localizada")
//
//    return ResponseEntity(promocao, HttpStatus.OK)
//  }

  /**
   * Funcão para criar uma nova promocao
   **/
  @PostMapping()
  fun create(@RequestBody promocao: Promocao): ResponseEntity<RespostaJSON> {
    this.promocaoService.create(promocao)
    val respostaJSON = RespostaJSON("OK", Date())
    return ResponseEntity(respostaJSON, HttpStatus.CREATED)
  }

  /**
   * Funcão para excluir uma promocao
   **/
  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
    val promocao = this.promocaoService.getById(id)
    var status = HttpStatus.NOT_FOUND
    if (promocao != null) {
      status = HttpStatus.ACCEPTED
      this.promocaoService.delete(id)
    }
    return ResponseEntity(Unit, status)
  }

  /**
   * Funcão para alteracao uma promocao
   **/
  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody promocao: Promocao):
      ResponseEntity<Unit> {
    var status = HttpStatus.NOT_FOUND
    if (this.promocaoService.getById(id) != null) {
      this.promocaoService.update(id, promocao)
      status = HttpStatus.ACCEPTED
    }

    return ResponseEntity(Unit, status)
  }

  /**
   * Funcão para listar todas as promocoes
   **/
  @GetMapping()
  fun getAll(
    @RequestParam(required = false, defaultValue = "0") start: Int,
    @RequestParam(required = false, defaultValue = "3") size: Int,
  ): ResponseEntity<List<Promocao>> {
    val list = this.promocaoService.getAll(start, size)
    val status = if (list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
    return ResponseEntity(list, status)
  }

  @GetMapping("/count")
  fun count(): ResponseEntity<Map<String, Long>> =
    ResponseEntity.ok().body(mapOf("count" to this.promocaoService.count()))

  @GetMapping("/sorted")
  fun ordenados() = this.promocaoService.getAllSortedByLocal()
}

