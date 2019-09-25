package ExercicisSenzills;

public class Ex5Questionari {
    public static void main(String[] args) {
        String nico;
        String edat;
        String blend;
        String rol;


        System.out.println("Quin és el meu nom?");
        nico = System.console().readLine(); 

        if (nico.equals("Nicolás")){
            System.out.println("Correcte");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Quina és la meva edat?");
            edat = System.console().readLine();
            System.out.println("-----------------------------------------------------------------------");
            

            if (edat.equals("18")){
                System.out.println("Correcte");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("El millor programa 3D?");
                blend = System.console().readLine();
                System.out.println("-----------------------------------------------------------------------");


                if (blend.equals("Blender")){
                    System.out.println("Correcte");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("El millor joc de rol?");
                    rol = System.console().readLine();
                    System.out.println("-----------------------------------------------------------------------");
                

                     if (rol.equals("Anima: Beyond Fantasy")){
                        System.out.println("-----------------------------------------------------------------------");
                            System.out.println("Correcte, tens els 4 punts!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("-----------------------------------------------------------------------");
                        }

                    else {
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("¡¡¡¡ERROR!!!!");   
                        System.out.println("Tens 3 punts"); 
                        System.out.println("-----------------------------------------------------------------------");        
                    }

                    }


                else {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("¡¡¡¡ERROR!!!!");   
                    System.out.println("Tens 2 punts");   
                    System.out.println("-----------------------------------------------------------------------");      
               
                }

                }


            else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("¡¡¡¡ERROR!!!!");   
                System.out.println("Tens 1 punts");   
                System.out.println("-----------------------------------------------------------------------");      
            }
            
            }   

        else {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("¡¡¡¡ERROR!!!!");   
            System.out.println("Tens 0 punts");       
            System.out.println("-----------------------------------------------------------------------");  
        }

     }
}