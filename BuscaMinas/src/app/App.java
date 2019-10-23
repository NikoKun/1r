package app;

public class App {
    public static void main(String[] args){
        int posX = 0;
        int posY = 0;

        int i = 0;
        int j = 0;


        int linies = Integer.parseInt(System.console().readLine("Digues el número de línias que vols: "));
        int bombes = Integer.parseInt(System.console().readLine("Digues el número de bombes: "));


        int taulell[][] = new int[linies][linies];
        String taulellCOPIA[][] = new String[linies][linies];

        while(i < bombes){
            posX = (int)Math.floor(Math.random()*linies);
            posY = (int)Math.floor(Math.random()*linies);

            if(taulell[posX][posY]!=-1){
                taulell[posX][posY] = -1;
                i++;
            }
        }



        // if (taulell[i][j]==-1){
        //     taulellCOPIA[i][j]= "B";
        // }
        // else if (taulell[i][j]==0){
        //     taulellCOPIA[i][j]= "▒▒";
        // }

        
        
        for(i=0; i<taulell[0].length; i++){
            System.out.print("\n");

            for(j=0; j<taulell.length; j++){
  

                System.out.print(taulellCOPIA[i][j]+ "\t");
            }
        }

        System.out.print("\n");





    
    }
}