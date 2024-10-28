package org.acme.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.acme.type.Status
import java.time.LocalDate


/**
 * エンティティクラス
 *
 * @Entityアノテーションを付与することで、JPAのエンティティとして認識される
 */
@Entity
class Person {

    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    lateinit var birth: LocalDate
    lateinit var status: Status
}