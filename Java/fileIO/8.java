
//method to read serialized object (student) from file\\xyz

public Student readstudent() {
        Student student = null;
        try {
            FileInputStream fileobj=new FileInputStream("D:\\java2\\fileIO\\xyz.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileobj);
            student= (Student)(objStream.readObject());//method to read from serialized object must cast to that class
            objStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return student;
        
    }
}