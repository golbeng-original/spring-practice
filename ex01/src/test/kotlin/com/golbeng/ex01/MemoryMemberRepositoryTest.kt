package com.golbeng.ex01

import com.golbeng.ex01.domain.Member
import com.golbeng.ex01.repository.MemoryMemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {

    val repository:MemoryMemberRepository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun saveTest() {
        val member:Member = Member(1, "June")

        repository.save(member)

        val findedMemeber = repository.findById(1)

        Assertions.assertEquals(member, findedMemeber)
    }

    @Test
    fun findByNameTest() {
        val member1 = Member(1, "June")
        repository.save(member1)

        val member2 = Member(2, "Jo")
        repository.save(member2)

        val result = repository.findByName("June")

        Assertions.assertEquals(member1, result)
    }

    @Test
    fun findAllTest() {
        val member1 = Member(1, "June")
        repository.save(member1)

        val member2 = Member(2, "Jo")
        repository.save(member2)

        val result = repository.findAll()

        Assertions.assertEquals(result.count(), 2)
    }
}