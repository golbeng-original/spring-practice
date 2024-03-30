package com.golbeng.ex01.repository

import com.golbeng.ex01.domain.Member

interface MemberRepository {

    fun save(member:Member) : Member
    fun findById(id:Long): Member?
    fun findByName(name:String) : Member?
    fun findAll() : Iterable<Member>
}