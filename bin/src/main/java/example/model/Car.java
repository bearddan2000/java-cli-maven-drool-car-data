package example.model;

public class Car {
  private double price;
  private int year;
  private String make, model;
/*
  public Car(double a, int b, String c, String d){
    price=a;
    year=b;
    make=c;
    model=d;
  }
*/
  public void setPrice(double value){price=value;}
  public void setYear(int value){year=value;}
  public void setMake(String value){make=value;}
  public void setModel(String value){model=value;}

  public double getPrice(){return price;}
  public int getYear(){return year;}
  public String getMake(){return make;}
  public String getModel(){return model;}

  @Override
  public String toString(){
    return String.format("[OUTPUT] price=%.2f, year=%d, make=%s, model=%s", price, year, make, model);
  }
}
