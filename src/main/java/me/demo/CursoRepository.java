package me.demo;

import org.springframework.data.jpa.repository.JpaRepository;
interface CursoRepository extends JpaRepository<Curso,Long>{
    
}