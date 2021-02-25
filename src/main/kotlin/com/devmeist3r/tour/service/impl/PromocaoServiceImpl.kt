package com.devmeist3r.tour.service.impl

import com.devmeist3r.tour.model.Promocao
import com.devmeist3r.tour.service.PromocaoService
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap


@Component
class PromocaoServiceImpl: PromocaoService {

  companion object {
    val initialPromocoes = arrayOf(
      Promocao(1, "Maravilhosa viagem", "Cancun", true, 7, 4200.99),
      Promocao(2, "Maravilhosa viagem", "Bahamas", true, 7, 4100.99),
      Promocao(3, "Maravilhosa viagem", "Porto Rico", true, 7, 4900.99),
      Promocao(4, "Maravilhosa viagem", "Panamá", true, 7, 4700.99),
    )
  }

  var promocoes =
    ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

  override fun create(promocao: Promocao) {
    promocoes[promocao.id] = promocao
  }

  override fun getById(id: Long): Promocao? {
    return promocoes[id]
  }

  override fun delete(id: Long) {
    promocoes.remove(id)
  }

  override fun update(id: Long, promocao: Promocao) {
    delete(id)
    create(promocao)
  }

  override fun searchByLocal(local: String): List<Promocao> {
    return promocoes.filter {
      it.value.local.contains(local, true)
    }.map (Map.Entry<Long, Promocao>::value).toList()
  }

}
