//write a method which write student onbject into file by using object streme method
    public void writeStudent(Student student) {
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("D:\\java2\\fileIO\\xyz.txt"));//outputstreme is class witch help to write object in file
            objectOutputStream.writeObject(student);//writeobject method to write object to file 
            System.out.println("successfully stores");
            objectOutputStream.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }