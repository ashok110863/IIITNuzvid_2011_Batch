import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		} else {
			this.students = students;
		}
	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			return this.students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		if (index < 0 || index >= this.students.length || student == null) {
			throw new IllegalArgumentException();
		} else {
			this.students[index] = student;
		}
	}

	@Override
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			Student[] newArray = new Student[this.students.length + 1];
			newArray[0] = student;
			for (int i = 0; i < this.students.length; i++) {
				newArray[i + 1] = this.students[i];
			}
			this.students = newArray;
		}

	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			Student[] newArray = new Student[this.students.length + 1];
			newArray[this.students.length] = student;
			for (int i = 0; i < this.students.length; i++) {
				newArray[i] = this.students[i];
			}
			newArray[this.students.length]=student;
			this.students = newArray;
		}
	}

	@Override
	public void add(Student student, int index) {
		if (index < 0 || index >= this.students.length || student == null) {
			throw new IllegalArgumentException();
		} else {
			Student[] newArray = new Student[this.students.length + 1];
			for (int i = 0; i < index; i++) {
				newArray[i] = this.students[i];
			}
			newArray[index] = student;
			for (int i = index+1; i < this.students.length; i++) {
				newArray[i] = this.students[i];
			}
			this.students = newArray;
		}
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] arr = new Student[this.students.length - 1];
			for (int i = 0; i < index; i++) {
				arr[i] = this.students[i];
			}
			for (int i = index + 1; i < this.students.length; i++) {
				arr[i - 1] = this.students[i];
			}
			this.students = arr;
		}
	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int index = -1;
		for (int i = 0; i < this.students.length; i++) {
			if (student.equals(this.students[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new IllegalArgumentException("Student not exist");
		} else {
			Student[] arr = new Student[this.students.length - 1];
			for (int i = 0; i < index; i++) {
				arr[i] = this.students[i];
			}
			for (int i = index + 1; i < this.students.length; i++) {
				arr[i - 1] = this.students[i];
			}
			this.students = arr;
		}
	}

	@Override
	public void removeFromIndex(int index) {
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] arr = new Student[index + 1];
			for (int i = 0; i <= index; i++) {
				arr[i] = this.students[i];
			}
			this.students = arr;
		}
	}

	@Override
	public void removeFromElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int index = -1;
			for (int i = 0; i < this.students.length; i++) {
				if (student.equals(this.students[i])) {
					index = i;
					break;
				}
			}
			Student[] arr = new Student[index + 1];
			for (int i = 0; i <= index; i++) {
				arr[i] = this.students[i];
			}
			this.students = arr;
		}
	}

	@Override
	public void removeToIndex(int index) {
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			Student[] arr = new Student[this.students.length - index + 1];
			int idx = 0;
			for (int i = index; i <= this.students.length; i++) {
				arr[idx] = this.students[i];
				idx++;
			}
			this.students = arr;
		}
	}

	@Override
	public void removeToElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int index = -1;
			for (int i = 0; i < this.students.length; i++) {
				if (student.equals(this.students[i])) {
					index = i;
					break;
				}
			}
			int idx = 0;
			Student[] arr = new Student[this.students.length - index + 1];
			for (int i = index; i <= this.students.length; i++) {
				arr[idx] = this.students[i];
				idx++;
			}
			this.students = arr;
		}
	}

	@Override
	public void bubbleSort() {
		int n = this.students.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (this.students[j].compareTo(this.students[j + 1]) >0) {
					Student temp = this.students[j];
					this.students[j] = this.students[j + 1];
					this.students[j + 1] = temp;
				}

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if (date == null)
			throw new IllegalArgumentException();
		else {
			Student[] st = new Student[students.length];
			int count = 0;
			for (int i = 0; i < students.length; i++)
				if (students[i].getBirthDate().compareTo(date) == 0) {
					st[count] = students[i];
					count++;
				}
			Student[] ts = new Student[count];

			for (int i = 0; i < count; i++) {
				ts[i] = st[i];
			}
			return ts;
		}

	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null || lastDate==null){
			throw new IllegalArgumentException();
		}else{
			ArrayList<Student> arr=new ArrayList<Student>();
			for(int i=0;i<this.students.length;i++){
				if(this.students[i].getBirthDate().equals(firstDate) || this.students[i].getBirthDate().equals(lastDate) ){
					arr.add(this.students[i]);
				}else if(this.students[i].compareTo(firstDate)>0 && this.students[i].compareTo(lastDate)<0){
					arr.add(this.students[i]);
				}
			}
			return  (Student[]) arr.toArray();
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		ArrayList<Student> arr=new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++){
			arr.add(this.students[i]);
		}
		return (Student[]) arr.toArray();
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double d = 0;
		for (int i = 0; i < students.length; i++) {

			if (students[i].getAvgMark() > d) {
				d = students[i].getAvgMark();
			}
		}
		Student[] st = new Student[students.length];
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (d == students[i].getAvgMark()) {
				st[count] = students[i];
				count++;
			}
		}
		Student[] ts = new Student[count];
		for (int i = 0; i < count; i++) {
			ts[i] = st[i];
		}
		return ts;
	}

	@Override
	public Student getNextStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException();
		else
			for (int i = 0; i < students.length; i++) {
				if (student.getId() == students[i].getId())
					return students[i + 1];
			}
		return null;
	}
}
