package fushuai.entity;

import java.util.List;

public class Member {
    private int id;
    private String userName;
    private String trueName;
    private String passWord;
    private String city;
    private String address;
    private String postcode;
    private String carNo;
    private String carType;
    private String tel;
    private String email;
    private String memberType;
    private List<String> roles;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
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
    //public  void  setMember(Map<String,Object> map){
    //       this.id= (int) map.get("id");
    //       this.userName= (String) map.get("userName");
    //       this.trueName= (String) map.get("trueName");
    //       this.passWord= (String) map.get("passWord");
    //       this.city= (String) map.get("city");
    //       this.address= (String) map.get("address");
    //       this.postcode= (String) map.get("postcode");
    //       this.carNO= (String) map.get("carNO");
    //       this.carType= (String) map.get("carType");
    //       this.tel= (String) map.get("tel");
    //       this.email= (String) map.get("email");
    //       this.memberType= String.valueOf(Integer.parseInt(map.get("memberType").toString()));
    //}

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", carNo='" + carNo + '\'' +
                ", carType='" + carType + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", memberType='" + memberType + '\'' +
                ", roles=" + roles +
                '}';
    }
}
