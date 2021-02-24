package com.devmeist3r.tour

import com.devmeist3r.tour.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class TourApplication {
  // Metodo estatico
  companion object {
    val initialPromocoes = arrayOf(
      Promocao(1, "Maravilhosa viagem", "Cancun", true, 7, 4200.99),
      Promocao(2, "Maravilhosa viagem", "Bahamas", true, 7, 4100.99),
      Promocao(3, "Maravilhosa viagem", "Porto Rico", true, 7, 4900.99),
      Promocao(4, "Maravilhosa viagem", "Panamá", true, 7, 4700.99),
    )
  }

  @Bean
  fun promocoes() =
    ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

}

fun main(args: Array<String>) {
  runApplication<TourApplication>(*args)
}

// hashMap
