package com.devmeist3r.tour.controller

import com.devmeist3r.tour.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {

  @Autowired
  lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

  /**
   * Funcão para pegar promocao por id
   **/
  @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod
    .GET))
  fun getById(@PathVariable id: Long) = promocoes[id]

  /**
   * Funcão para criar uma nova promocao
   **/
  @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod
    .POST))
  fun create(@RequestBody promocao: Promocao) {
    promocoes[promocao.id] = promocao
  }

  /**
   * Funcão para excluir uma promocao
   **/
  @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod
    .DELETE))
  fun delete(@PathVariable id: Long) {
    promocoes.remove(id)
  }

  /**
   * Funcão para alteracao uma promocao
   **/
  @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod
    .PUT))
  fun update(@PathVariable id: Long, @RequestBody promocao: Promocao) {
    promocoes.remove(id)
    promocoes[id] = promocao
  }

  /**
   * Funcão para listar todas as promocoes
   **/
  @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.GET))
  fun getAll(@RequestParam(required = false, defaultValue = "") localFilter:
             String) =
    promocoes.filter {
      it.value.local.contains(localFilter, true)
    }.map (Map.Entry<Long, Promocao>::value).toList()


}

//  /**
//   * Funcão de teste
//   **/
//  @RequestMapping(value = ["/sayHello"], method = arrayOf(RequestMethod.GET))
//  fun sayHello(): String {
//    return "Hello World"
//  }
