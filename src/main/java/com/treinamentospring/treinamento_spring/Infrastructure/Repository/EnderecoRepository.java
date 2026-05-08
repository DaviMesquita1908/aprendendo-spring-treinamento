package com.treinamentospring.treinamento_spring.Infrastructure.Repository;

import com.treinamentospring.treinamento_spring.Infrastructure.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
