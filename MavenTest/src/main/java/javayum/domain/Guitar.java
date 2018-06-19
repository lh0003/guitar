package javayum.domain;

public class Guitar {
  private Integer id;
  private String serialNumber;
  private double price;
  //guitar和guitarSpec 是一对一关系
  private GuitarSpec spec;

  public Guitar() {
    super();
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public GuitarSpec getSpec() {
    return spec;
  }

  public void setSpec(GuitarSpec spec) {
    this.spec = spec;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}