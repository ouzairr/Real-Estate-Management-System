package individuals;

/**
 * @author ilyas
 */

import java.io.Serializable;

import main.Occupation;

public class  People implements Serializable {
	
    protected Occupation occupation;
	protected String FN;
	protected String LN;
	protected int age;
    protected char sex;
	public String toString() {
		return("Name: "+FN + LN + "Age: "+ age);
	}
        public People(String FN, String LN , int age, Occupation occupation, char sex){
        	this.LN = LN;
            this.FN = FN;
            this.age = age;
            this.occupation = occupation;
            this.sex= sex;
        }
        public People() {
        	
        }

        
        public void setAge(int age){
            this.age = age;
        }
        
        public void setFN(String FN){
            this.FN = FN;
        }
        public void setLN(String LN){
            this.LN = LN;
        }

        public int getAge(){
            return age;
        }
        public String getFN(){
            return FN;
        }
        public String getLN(){
            return LN;
        }
        public Occupation getOccupation(){
            return occupation;
        }
        public char getSex(){
            return sex;
        }
        public void setSex(char sex) {
        	this.sex = sex;
        }
        public void setOccupation(Occupation occupation) {
        	this.occupation = occupation;
        }

}


