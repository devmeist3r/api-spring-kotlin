package com.devmeist3r.tour.controller

import com.devmeist3r.tour.model.Promocao
import com.devmeist3r.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

  @Autowired
  lateinit var promocaoService: PromocaoService

  /**
   * Funcão para pegar promocao por id
   **/
  @GetMapping("/{id}")
  fun getById(@PathVariable id: Long) = this.promocaoService.getById(id)

  /**
   * Funcão para criar uma nova promocao
   **/
  @PostMapping()
  fun create(@RequestBody promocao: Promocao) {
    this.create(promocao)
  }

  /**
   * Funcão para excluir uma promocao
   **/
  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long) {
    this.delete(id)
  }

  /**
   * Funcão para alteracao uma promocao
   **/
  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody promocao: Promocao) {
    this.promocaoService.update(id, promocao)
  }

  /**
   * Funcão para listar todas as promocoes
   **/
  @GetMapping()
  fun getAll(@RequestParam(required = false, defaultValue = "") localFilter:
             String) = this.promocaoService.searchByLocal(localFilter)


}

