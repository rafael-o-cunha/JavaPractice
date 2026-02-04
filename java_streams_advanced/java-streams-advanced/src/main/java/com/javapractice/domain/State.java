package com.javapractice.domain;

import java.util.Objects;

import javax.swing.plaf.synth.Region;

import com.javapractice.domain.types.RegionType;

public class State {
	private String code;
	private String name;
	private RegionType region;
	
	public State(String code, String name, RegionType region) {
		super();
		this.code = code;
		this.name = name;
		this.region = region;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public RegionType getRegion() {
		return region;
	}
	
	public void setRegion(RegionType region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(code, other.code) && Objects.equals(name, other.name) && region == other.region;
	}

	@Override
	public String toString() {
		return "State [code=" + code + ", name=" + name + ", region=" + region.name() + "]";
	}

}
