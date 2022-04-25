package wk10;

import java.util.ArrayList;
import java.util.Collections;

public class Applicant {
	public String name;
	public String phone;
	public String email;
	public String address;
	public String zipcode;
	public String region;
	public ArrayList<String> programmingLanguages = new ArrayList<>();
	public Double gpa;
	public String major;
	public String university;

	public Applicant(String lastName, String firstName, String phone,
			String email, String address, String zipcode, String region,
			String programmingLanguages, String gpa, String major,
			String university) {
		this.name = firstName + " " + lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.region = region;
		Collections.addAll(this.programmingLanguages,
				programmingLanguages.split(" "));
		this.gpa = Double.parseDouble(gpa);
		this.major = major;
		this.university = university;
	}

}
