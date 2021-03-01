package com.devmeist3r.tour.repository

import com.devmeist3r.tour.model.Promocao
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface PromocaoRepository: PagingAndSortingRepository<Promocao, Long> {

}
