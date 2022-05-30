package com;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class FileInfo {
	
	@Id
	private int fid;
	
	private String fname;
	
	private long fsize;
	
	//@Type(type="yes_no")
	@Type(type = "org.hibernate.type.YesNoType")
	private boolean status;
	
	@Lob
	private byte[] filedata;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FileInfo [fid=" + fid + ", fname=" + fname + ", fsize=" + fsize + ", status=" + status + ", filedata="
				+ Arrays.toString(filedata) + "]";
	}

}
