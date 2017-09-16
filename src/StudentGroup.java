import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
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
		if(students==null){
			throw new IllegalArgumentException();
		}
		else{
			this.students=students;
		}
	}

	@Override
	public Student getStudent(int index) {
		if(index<0 || index>=this.students.length){
			throw new IllegalArgumentException();
		}else{
			return this.students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		if(index<0 || index>=this.students.length ||student==null){
			throw new IllegalArgumentException();
		}else{
			this.students[index]=student;
		}
	}

	@Override
	public void addFirst(Student student) {
		if(student==null){
			throw new IllegalArgumentException();
		}else{
			Student[] newArray=new Student[this.students.length+1];
			newArray[0]=student;
			for(int i=0;i<this.students.length;i++){
				newArray[i+1]=this.students[i];
			}
			this.students=newArray;
		}
		
	}

	@Override
	public void addLast(Student student) {
		if(student==null){
			throw new IllegalArgumentException();
		}else{
		Student[] newArray=new Student[this.students.length+1];
		newArray[this.students.length]=student;
		for(int i=0;i<this.students.length;i++){
			newArray[i]=this.students[i];
		}
		this.students=newArray;
		}
	}

	@Override
	public void add(Student student, int index) {
		if(index<0 || index>=this.students.length ||student==null){
			throw new IllegalArgumentException();
		}else{
			Student[] newArray=new Student[this.students.length+1];
			for(int i=0;i<index;i++){
				newArray[i]=this.students[i];
			}
			newArray[index]=student;
			for(int i=index;i<this.students.length;i++){
				newArray[i]=this.students[i];
			}
			this.students=newArray;
		}
	}

	@Override
	public void remove(int index) {
		if(index<0||index>=this.students.length){
			throw new IllegalArgumentException();
		}else{
			Student[]  arr=new  Student[this.students.length-1];
			for(int i=0;i<index;i++){
				arr[i]=this.students[i];
			}
			for(int i=index+1;i<this.students.length;i++){
				arr[i-1]=this.students[i];
			}
			this.students=arr;
		}
	}

	@Override
	public void remove(Student student) {
		if(student==null){
			throw new IllegalArgumentException();
		}
		int  index=-1;
		for(int i=0;i<this.students.length;i++){
			if(student.equals(this.students[i])){
				index=i;
				break;
			}
		}
		if(index==-1){
			throw new IllegalArgumentException("Student not exist");
		}else{
			Student[]  arr=new  Student[this.students.length-1];
			for(int i=0;i<index;i++){
				arr[i]=this.students[i];
			}
			for(int i=index+1;i<this.students.length;i++){
				arr[i-1]=this.students[i];
			}
			this.students=arr;
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
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
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
