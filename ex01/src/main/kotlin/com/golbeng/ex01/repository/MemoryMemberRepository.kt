package com.golbeng.ex01.repository

import com.golbeng.ex01.domain.Member
import kotlin.collections.Map

class MemoryMemberRepository : MemberRepository {

    val store:MutableMap<Long, Member> = HashMap<Long, Member>()
    var sequence:Long = 0

    fun clearStore() {
        store.clear()
        sequence = 0
    }

    override fun save(member: Member): Member {

        sequence++

        member.id = sequence
        store.put(member.id, member)

        return store.get(member.id)!!
    }

    override fun findById(id: Long): Member? {
        return store.get(id)
    }

    override fun findByName(name: String): Member? {
        for(element in store) {
            if (element.value.name == name) {
                return element.value
            }
        }

        return store
            .filter { it.value.name == name }
            .values
            .firstOrNull()
    }

    override fun findAll(): Iterable<Member> {
        return store.values.toList()
    }
}