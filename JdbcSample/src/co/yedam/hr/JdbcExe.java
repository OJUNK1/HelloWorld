package co.yedam.hr;

import java.util.List;

public class JdbcExe {
	public static void main(String[] args) {
		EmpVO emp = new EmpVO(1001, "황길동", "hwang@email2222", "대전시 22222", 1300);

		EmpDAO dao = new EmpDAO();
//		List<EmpVO> list = dao.empList();.
		EmpVO resultEmp = dao.getEmp(emp.getEmpId());
		if (resultEmp != null) {
			System.out.println("조회 성공");
            System.out.println("사원 이름: " + resultEmp.getEmpName());
            System.out.println("이메일: " + resultEmp.getEmail());
		} else {
			System.out.println("조회 실패");
		}

		System.out.println("end of prog.");
	}
}