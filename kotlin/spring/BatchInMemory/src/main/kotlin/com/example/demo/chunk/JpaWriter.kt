package com.example.demo.chunk

import com.example.demo.domain.Employee
import com.example.demo.repository.EmployeeRepository
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component("JpaWriter")
class JpaWriter: ItemWriter<Employee> {
    @Autowired
    private lateinit var repository: EmployeeRepository

    @Transactional
    override fun write(chunk: Chunk<out Employee>) {
        repository.saveAllAndFlush(chunk.items)
    }
}
