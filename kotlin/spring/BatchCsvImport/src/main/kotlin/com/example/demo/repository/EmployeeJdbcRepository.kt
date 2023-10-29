package com.example.demo.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class EmployeeJdbcRepository {
    @Autowired
    var jdbc: JdbcTemplate? = null

    private val existsSql = "select exists (select * from employee where id = ?)"

    /** SQL実行 */
    fun exists(id: Int): Boolean? {
        return jdbc?.queryForObject(this.existsSql, Boolean::class.java, id)
    }
}
