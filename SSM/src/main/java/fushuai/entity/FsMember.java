package fushuai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "fushuai-entity-FsMember")
public class FsMember implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String username;

    @ApiModelProperty(value = "")
    private String truename;

    @ApiModelProperty(value = "")
    private String password;

    @ApiModelProperty(value = "")
    private String city;

    @ApiModelProperty(value = "")
    private String address;

    @ApiModelProperty(value = "")
    private String postcode;

    @ApiModelProperty(value = "")
    private String carno;

    @ApiModelProperty(value = "")
    private String cardtype;

    @ApiModelProperty(value = "")
    private String tel;

    @ApiModelProperty(value = "")
    private String email;

    /**
     * 用户消费花的钱数
     */
    @ApiModelProperty(value = "用户消费花的钱数")
    private Integer money;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "FsMember{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", truename='" + truename + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", carno='" + carno + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", money=" + money +
                '}';
    }
}