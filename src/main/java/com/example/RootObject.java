package com.example;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)

public class RootObject {
	@Override
	public String toString() {
		System.out.println("id=" + id + ", t=" + t + ", e=" + e + ", l=" + l + "]");
		return " ";
	}

	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String t;

	public String getT() {
		return this.t;
	}

	public void setT(String t) {
		this.t = t;
	}

	private String e;

	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	private String l;

	public String getL() {
		return this.l;
	}

	public void setL(String l) {
		this.l = l;
	}
	
	private String lt_dts;

	public String getLtDts() {
		return this.lt_dts;
	}

	public void setLtDts(String lt_dts) {
		this.lt_dts = lt_dts;
	}

	/*private String l_fix;

	public String getLFix() {
		return this.l_fix;
	}

	public void setLFix(String l_fix) {
		this.l_fix = l_fix;
	}

	private String l_cur;

	public String getLCur() {
		return this.l_cur;
	}

	public void setLCur(String l_cur) {
		this.l_cur = l_cur;
	}

	private String s;

	public String getS() {
		return this.s;
	}

	public void setS(String s) {
		this.s = s;
	}

	private String ltt;

	public String getLtt() {
		return this.ltt;
	}

	public void setLtt(String ltt) {
		this.ltt = ltt;
	}

	private String lt;

	public String getLt() {
		return this.lt;
	}

	public void setLt(String lt) {
		this.lt = lt;
	}


	private String c;

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	private String c_fix;

	public String getCFix() {
		return this.c_fix;
	}

	public void setCFix(String c_fix) {
		this.c_fix = c_fix;
	}

	private String cp;

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	private String cp_fix;

	public String getCpFix() {
		return this.cp_fix;
	}

	public void setCpFix(String cp_fix) {
		this.cp_fix = cp_fix;
	}

	private String ccol;

	public String getCcol() {
		return this.ccol;
	}

	public void setCcol(String ccol) {
		this.ccol = ccol;
	}

	private String pcls_fix;

	public String getPclsFix() {
		return this.pcls_fix;
	}

	public void setPclsFix(String pcls_fix) {
		this.pcls_fix = pcls_fix;
	}*/
}
