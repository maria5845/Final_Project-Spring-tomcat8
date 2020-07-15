package com.jl3b.touche_nubes.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl3b.touche_nubes.member.mapper.MemberSQLMapper;
import com.jl3b.touche_nubes.member.mapper.NpkiSQLMapper;
import com.jl3b.touche_nubes.membervo.NpkiVo;
import com.jl3b.touche_nubes.membervo.ResiVo;
import com.jl3b.touche_nubes.membervo.TeacherVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	@Autowired
	private NpkiSQLMapper npkiSQLMapper;
	
	public void joinResiMember(ResiVo resiVo) {			
		if(npkiSQLMapper.selectNpki(resiVo.getNpki_key()) == null) {
			return;
		}else {
			memberSQLMapper.insertResi(resiVo);
		}
	}
	
	public String checkNpki(String npki_key) {
		return npkiSQLMapper.selectNpki(npki_key);
		
	}
	
	public ResiVo login(ResiVo resiVo) {
		return memberSQLMapper.selectResiByIdAndPw(resiVo);
	}
	
	public void joinTeacherMember(TeacherVo teacherVo) {
		
		if(npkiSQLMapper.selectNpki(teacherVo.getNpki_key()) == null) {
			return;
		}else {
			memberSQLMapper.insertTeacher(teacherVo);;
		}
	}
}
