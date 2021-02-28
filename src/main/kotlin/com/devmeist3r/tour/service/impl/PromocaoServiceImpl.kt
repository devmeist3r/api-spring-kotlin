package com.devmeist3r.tour.service.impl

import com.devmeist3r.tour.model.Promocao
import com.devmeist3r.tour.repository.PromocaoRepository
import com.devmeist3r.tour.service.PromocaoService
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap


@Component
class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

//  companion object {
//    val initialPromocoes = arrayOf(
//      Promocao(1, "Maravilhosa viagem", "Cancun", true, 7, 4200.99),
//      Promocao(2, "Maravilhosa viagem", "Bahamas", true, 7, 4100.99),
//      Promocao(3, "Maravilhosa viagem", "Porto Rico", true, 7, 4900.99),
//      Promocao(4, "Maravilhosa viagem", "Panamá", true, 7, 4700.99),
//    )
//  }
//
//  var promocoes =
//    ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

  override fun create(promocao: Promocao) {
    this.promocaoRepository.save(promocao)
  }

  override fun getById(id: Long): Promocao? {
    return this.promocaoRepository.findById(id).orElseGet(null)
  }

  override fun delete(id: Long) {
    this.promocaoRepository.deleteById(id)
  }

  override fun update(id: Long, promocao: Promocao) {
    this.create(promocao)
  }

  override fun searchByLocal(local: String): List<Promocao> = listOf()

  override fun getAll(): List<Promocao> {
    return this.promocaoRepository.findAll().toList()
  }

  override fun count(): Long {
    return this.promocaoRepository.count()
  }

}
