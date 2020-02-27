package formes.formesG;

import java.text.DecimalFormat;

public interface Formes {

    static final DecimalFormat df = new DecimalFormat("#.##");


//-------------------------------------------------------------------------------------

    public void calcular();

    public void printa();
}