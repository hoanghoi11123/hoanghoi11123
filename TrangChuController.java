package com.nguyentrihoang.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyentrihoang.entity.NhanVien;
import com.nguyentrihoang.entity.SanPham;



@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping
	@Transactional
	public String Default() {
		Session session=sessionFactory.getCurrentSession();
		
		

		SanPham sanPham=new SanPham();
		sanPham.setTenSanPham("ga ran");
		sanPham.setGiaSanPham("10.000 VND");
		
		SanPham sanPham1=new SanPham();
		sanPham1.setTenSanPham("ga luoc");
		sanPham1.setGiaSanPham("100.000 VND");
		
		SanPham sanPham2=new SanPham();
		sanPham2.setTenSanPham("ga chien");
		sanPham2.setGiaSanPham("1.000.000 VND");
		
		Set<SanPham> sanPhams=new HashSet<>();
		sanPhams.add(sanPham);
		sanPhams.add(sanPham1);
		sanPhams.add(sanPham2);
		
		NhanVien nhanVien=new NhanVien();
		nhanVien.setTenNhanVien("Hoang Tri");
		nhanVien.setTuoi(21);
		
		nhanVien.setSanPhams(sanPhams);
		session.save(nhanVien);
		
//		cach xoa (ham get truy van theo khoa chinh '3')
		/*NhanVien nguyenVanA=session.get(NhanVien.class, 3);
		session.delete(nguyenVanA);*/
		
		
//		cach update bang o sql        C3  chi theo khoa chinh la tham so sau ten bang		
		/*NhanVien hoi=session.get(NhanVien.class, 6);
		hoi.setTuoi(28);
		session.update(hoi);*/
		
//		cach update bang o sql        C2  theo id , co the co nhieu dieu kien
		/*NhanVien hoi=(NhanVien) session.createQuery("from NhanVien where idNhanVien=6").uniqueResult();
		hoi.setTuoi(29);
		session.update(hoi);*/
		
//		cach update bang o sql        C1 
		/*NhanVien hoi=new NhanVien("hoi",38);
		hoi.setIdNhanVien(6);
		hoi.setTuoi(30);
		session.update(hoi);
		*/
		
		
		
//		lay du lieu ra tu sql
		/* String sql="from NhanVien";                          
		List <NhanVien> list=session.createQuery(sql).getResultList();
		for(NhanVien nv:list) {
			System.out.println("Ten nhan vien : "+nv.getTenNhanVien());
		}
		*/
		return "trangchu";
	}
	
	
	
	
//	them nhan vien vao bang thong qua the form phuong thuc post
	/*@PostMapping
	@Transactional
	public String ThemNhanVien(@RequestParam String tennhanvien, @RequestParam int tuoi) {
		Session session=sessionFactory.getCurrentSession();
		NhanVien nhanvien=new NhanVien(tennhanvien,tuoi);
		session.save(nhanvien);
		return "trangchu";
	}
	*/
}
