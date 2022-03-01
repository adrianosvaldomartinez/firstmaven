package adriancompany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.databind.annotation.JsonSerialize;
// (no necesitamos importar directamente serializble ni extender nuestra clase como serializable)
// import java.io.Serializable;

public class App 
{    
    public String saymotocolor(String marca_){
     return marca_;
    }
   
    public class Car  {
    String color;
    String type;
  
    // no podemos usar un constructor para la clase, necesitamos usar setter y getter
    // si es que queremos usar el metodo de jackson ObjectMapper().writeValueAsString(miauto);
    
    //  public Car(String color, String tipo){
    //     this.color = color;
    //     this.type = tipo;
    //  }
  
    
  // Getter
  public String getColor() {
    return color;
  }
  public String getType() {
    return type;
  }

  // Setter
  public void setColor(String newColor) {
    this.color = newColor;
  }
  public void setType(String newType) {
    this.type = newType;
  }


    }



    public static void main( String[] args ) throws JsonProcessingException
    {
        System.out.println( "Hello World!" );
        
        // instanciamos la clase exterior
        App app = new App();
        System.out.println(app.saymotocolor("hiunday"));
        
        // instanaciamos la clase interior
    //    App.Car miauto = app.new Car("yellow", "renault");
        App.Car miauto = app.new Car();  
        miauto.setColor("rojo");
        miauto.setType("grande");

        System.out.println(miauto.color);

        // String auto = new ObjectMapper().writeValueAsString(miauto);

        ObjectMapper objectmapper = new ObjectMapper();
        // si no queriamos que tire un error por nno ser unn objeto serializable agrregamos la linea de abajo
        // objectmapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        String autostring= objectmapper.writeValueAsString(miauto);
        
        System.out.println(autostring);

    }
}
