package program_on_string;

import java.lang.module.ResolutionException;

public class My_var_args {
    public void sum(int... a){
        int sumx=0;
        for(int i:a){
            sumx=sumx+i;
        }
        
        System.out.println(sumx);
    }

}
