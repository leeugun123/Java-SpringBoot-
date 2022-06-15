package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

import java.util.*;

import javax.annotation.PostConstruct;

@RestController//어노테이션
public class UserProfileController {

	
	private Map<String,UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		
		userMap = new HashMap<String,UserProfile>();
		
		userMap.put("1",new UserProfile("1","홍길동","111-1111","서울시 강남구 대치1동"));
		userMap.put("2",new UserProfile("2","홍길자","111-1112","서울시 강남구 대치2동"));
		userMap.put("3",new UserProfile("3","홍길순","111-1113","서울시 강남구 대치3동"));
		
	}
	
	
	//path를 이용해 id식별자를 이용하여 api를 호출
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id")String id) {
		return userMap.get(id);
		//요청한 id를 return 함 
		//json 형태로 자동으로 매핑해줌
	}
	
	
	//리스트 전체를 전달하는 구현
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		
		return new ArrayList<UserProfile>(userMap.values());
		//arraylist 형태로 리턴
		
	}
	
	//http 프로토콜은 put,get,post,delete 4가지 방식이 존재
	
	
	//데이터를 생성하는 api
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address) {
		//추가할 사용자의 이름 전화번호 주소를 parameter로 전달
		
		UserProfile userProfile = new UserProfile(id,name,phone,address);
		userMap.put(id, userProfile);
		
		
	}//오류 발생
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address) {
		
		UserProfile userProfile = userMap.get(id);
		userProfile.setName(name);
		userProfile.setPhone(phone);
		userProfile.setAddress(address);
		
	}//수정 post mapping은 구현됨
	
	//삭제하는 api
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}
	
	
	
	 
}
