//method to write object from student to file

public void writeStudentOnfile(Student student) {
        File file = new File("D:\\java2\\fileIO\\xyz.txt");
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));

            buffer.write(String.valueOf(student.getGpaString()));
            buffer.write(String.valueOf(student.getIdString()));
            buffer.write(String.valueOf(student.getNameString()));
            buffer.write(String.valueOf(student.getRollnoString()));
            System.out.println("successful");
            buffer.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }