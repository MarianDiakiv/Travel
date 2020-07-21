package ua.springweb.entity.enumeration;

public enum TeacherDegree {
JUNIOR("JUNIOR"),MIDDLE("MIDDLE"), SENIOR("SENIOR");

private String degree;

private TeacherDegree(String degree) {
	this.degree = degree;
}

public String getDegree() {
	return degree;
}

	
}
