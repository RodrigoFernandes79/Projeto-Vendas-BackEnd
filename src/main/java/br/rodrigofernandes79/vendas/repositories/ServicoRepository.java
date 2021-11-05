package br.rodrigofernandes79.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.rodrigofernandes79.vendas.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
