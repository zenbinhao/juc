package learn_copy_1_3;
/*
 * @Author: zeng
 * @Data: 2022/1/3 17:27
 * @Description: TODO
 */


public class UserConstruct {

    private String userName;

    private AddressConstruct address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AddressConstruct getAddress() {
        return address;
    }

    public void setAddress(AddressConstruct address) {
        this.address = address;
    }

    public UserConstruct() {
    }

    public UserConstruct(String userName, AddressConstruct address) {
        this.userName = userName;
        this.address = address;
    }

    public static void main(String[] args) {
        AddressConstruct address = new AddressConstruct("小区1", "小区2"    );
        UserConstruct user = new UserConstruct("小李", address);
        // 调用构造函数进行深拷贝

        UserConstruct copyUser = new UserConstruct(user.getUserName(), new AddressConstruct(address.getAddress1(), address.getAddress2()));
        // 修改源对象的值
        user.getAddress().setAddress1("小区3");
        // false
        System.out.println(user == copyUser);
        //
        System.out.println(user.getUserName()==copyUser.getUserName());
        // false
        System.out.println(user.getAddress().getAddress1() == copyUser.getAddress().getAddress1());
        // true
        System.out.println(user.getAddress().getAddress2() == copyUser.getAddress().getAddress2());
        // false
        System.out.println(user.getAddress().getAddress1().equals(copyUser.getAddress().getAddress1()));
        // true
        System.out.println(user.getAddress().getAddress2().equals(copyUser.getAddress().getAddress2()));

    }
}

class AddressConstruct {

    private String address1;

    private String address2;

    public AddressConstruct() {
    }

    public AddressConstruct(String address1, String address2) {
        this.address1 = address1;
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}