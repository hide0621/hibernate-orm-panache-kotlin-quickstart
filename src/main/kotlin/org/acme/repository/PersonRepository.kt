package org.acme.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.acme.entity.Person
import org.acme.type.Status

/**
 * リポジトリクラス
 *
 * PanacheRepositoryを継承することで、CRUD操作を簡単に実装できる
 */
@ApplicationScoped
class PersonRepository: PanacheRepository<Person> {

    /**
     * TODO: メソッド名は後で変更する
     */

    fun finByName(name: String): Person? = find("name", name).firstResult()

    fun findAlive(): List<Person?> = list("status", "ALIVE")

    fun insertStef() {
        val stef = Person().apply {
            name = "Stef"
            birth = java.time.LocalDate.of(1990, 1, 1)
            status = Status.ALIVE
        }
        persist(stef)
    }

//    fun insert(person: Person){
//        persist(stef)
//    }

    fun updateStefToStefan() {
        val stef = find("name", "Stef").firstResult()
        stef?.apply {
            name = "Stefan"
            birth = java.time.LocalDate.of(2000, 1, 1)
            status = Status.ALIVE
        }
    }

    fun updateStefSatus() {
        val stef = find("name", "Stef").firstResult()
        stef?.status = Status.DEAD
        update("status", Status.DEAD)
    }

    fun deleteStefs() = delete("name", "Stef")
}