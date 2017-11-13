package com.nguyentrihoang.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="NhanVien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idNhanVien;
	
	String tenNhanVien;
	int tuoi;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idNhanVien")
	Set<SanPham> sanPhams;
	
	
	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}
	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String tenNhanVien, int tuoi) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.tuoi = tuoi;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	
}
