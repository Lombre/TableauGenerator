
package tableaugenerator;
import java.util.ArrayList;
import java.util.List;


public class SubFormulae {
    
    public String formulae = "";
    public List<SubFormulae> listChildFormulae = new ArrayList<SubFormulae>();
    public SubFormulae parentFormulae;
    public int[] positionFormulae = new int[2];
    public int depth = 0;
    
    public SubFormulae(String formulae, int[] positionFormulae, int depth, SubFormulae parentFormulae)
    {
        
    }        
    
    public void setListChildFormulae(List<SubFormulae> listSentChildFormulae)
    {
        listChildFormulae = listSentChildFormulae;
    }
    
    public boolean equals()
    {
        boolean equals = true;
        
        //Til senere
        
        return equals;
    }
    
}
