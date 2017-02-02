package Titan;

import java.util.ArrayList;
import java.util.List;



public class Subject {
    private List<Integer> hits = new ArrayList<Integer>();
    private List<String> names = new ArrayList<String>();
    
    public void setHitsList(Card a, Card b,Card c,Card d, Card e){
        hits.add(a.getHealth()); hits.add(b.getHealth()); hits.add(c.getHealth()); hits.add(d.getHealth()); 
        hits.add(e.getHealth());
    }
    
    public void updateHitsList(Card a, Card b,Card c,Card d, Card e){
        hits.add(hits.get(0)-a.getHealth()); 
        hits.add(hits.get(1)-b.getHealth()); 
        hits.add(hits.get(2)-c.getHealth()); 
        hits.add(hits.get(3)-d.getHealth()); 
        hits.add(hits.get(4)-e.getHealth()); 
        
    }
    
    public void updateNamesList(Card a, Card b,Card c,Card d, Card e){
        names.add(a.getName()); names.add(b.getName()); names.add(c.getName()); 
        names.add(d.getName()); names.add(e.getName()); 
    
    }
    
    
    public void setNameList(Card a, Card b, Card c, Card d, Card e){
    	names.add(a.getName()); names.add(b.getName()); names.add(c.getName()); 
        names.add(d.getName()); names.add(e.getName()); 
    }
    
    public String returnBiggest(){
        int temp = 0;
        int element = 0;
        for(int i = 0; i <5; i++){
            if(!names.get(i).equals("No card"))
            {if(hits.get(i) > temp){temp = hits.get(i); element = i;}}
        }
        
        return names.get(element); 
    }
    
    /**
     ability(){
     * subj.setHitsList(Player.getField[0...4]);
     * subj.setNamesList(Player.getField[0...4]);
     * subj.updateHitsList(Player.getField[0...4]);
     * subj.updateNamesList(Player.getField[0...4]);
     * cardToHeal = subj.returnBiggest(); 
     * }
     
     
     */
}
