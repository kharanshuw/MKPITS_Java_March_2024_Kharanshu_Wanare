package java_program_string;

public class MyVarArgs {
	public void sum(int... a){
        int sumx=0;
        for(int i:a){
            sumx=sumx+i;
        }
        
        System.out.println(sumx);
    }

}
