import java.util.Random;

class Ex5{
    public static void main(String[] args) {
 
        String pos;
        int num;
        Random num1 = new Random();

        int pun1=0;
        int pun2=0;

        int i=0;

        for (i=0;i<6;i++){
        System.out.println("Tria parells (p) o senars (s):");
        pos = System.console().readLine();


        System.out.println("Quants dits treuràs? (Entre cap i 10)");
        num = Integer.parseInt(System.console().readLine());

        int numM =  num1.nextInt(10)+1;
        int numS = (num+numM);


        System.out.println("Tu has tret "+num+" dits i la màquina "+numM+" dits.");



        if(pos.equals("p")){
            if((numS%2)!=0){
            System.out.println(num+"+"+numM+" = "+numS+". El resultat és sanar, guanya la màquina!!!");
            pun2++;
            System.out.println(pun1+"-"+pun2);
            }

            else{
            System.out.println(num+"+"+numM+" = "+numS+". El resultat és parell, guanyes tú!!!");
            pun1++;
            System.out.println(pun1+"-"+pun2);
            }
        }

        
        else{

            if((numS%2)!=0){
            System.out.println(num+"+"+numM+" = "+numS+". El resultat és sanar, guanyes tú!!!");
            pun1++;
            System.out.println(pun1+"-"+pun2);
    
            }
    
            else{
            System.out.println(num+"+"+numM+" = "+numS+". El resultat és parell, guanya la màquina!!!");
            pun2++;
            System.out.println(pun1+"-"+pun2);
            }

            }
            
            if (pun2>2){
                System.out.println("Ha guanyat la màquina, la partida a quedat amb una puntuació de: "+pun1+" - "+pun2);
                break;
            }
    
    
            if (pun1>2){
                System.out.println("Has guanyat TUUUUUUU, la partida a quedat amb una puntuació de: "+pun1+" - "+pun2);
                break;

            }
        }
        

    }
}