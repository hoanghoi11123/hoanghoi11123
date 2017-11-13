package com.nguyentrihoang.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idSanPham;
	
	String tenSanPham;
	String giaSanPham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idNhanVien")
	NhanVien nhanVien;
	
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(String giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	
}
