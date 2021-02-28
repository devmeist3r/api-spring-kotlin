package com.devmeist3r.tour.repository

import com.devmeist3r.tour.model.Promocao
import org.springframework.data.repository.CrudRepository

interface PromocaoRepository: CrudRepository<Promocao, Long> {

}
