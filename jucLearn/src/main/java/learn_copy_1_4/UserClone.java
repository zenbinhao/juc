package learn_copy_1_4;/*
 * @Author: zeng
 * @Data: 2022/1/4 13:59
 * @Description: TODO 八大基本类型的clone是深拷贝 byte char short int long double float boolean
 */

public class UserClone implements Cloneable{
    String name;
    AddressClone addressClone;

    public UserClone() {
    }

    public UserClone(String name, AddressClone addressClone) {
        this.name = name;
        this.addressClone = addressClone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressClone getAddressClone() {
        return addressClone;
    }

    public void setAddressClone(AddressClone addressClone) {
        this.addressClone = addressClone;
    }

    @Override
    public UserClone clone() throws CloneNotSupportedException {
        UserClone userClone = (UserClone)super.clone();
        userClone.name = new String(this.getName());
        userClone.addressClone = (AddressClone)this.addressClone.clone();
        return userClone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        UserClone user1 =new UserClone("曾斌昊",new AddressClone("茶陵"));
        UserClone user2 = user1.clone();
        System.out.println(user1==user2);
        System.out.println(user1.name);
        System.out.println(user2.name);
//        System.out.println(user1.name.equals(user2.name));
        System.out.println(user1.name==user2.name);
        System.out.println("user1:"+user1.name.hashCode()+"\nuser2:"+user2.name.hashCode());
        System.out.println(user1.addressClone==user2.addressClone);
        System.out.println(user1.addressClone.address);
        System.out.println(user2.addressClone.address);
        System.out.println("user1.address:"+user1.addressClone.address.hashCode());
        System.out.println("user2.address:"+user2.addressClone.address.hashCode());
        System.out.println(user1.addressClone.address==user2.addressClone.address);
//        System.out.println(user1.addressClone.address.equals(user2.addressClone.address));
    }
}


class AddressClone implements Cloneable{
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressClone() {
    }

    public AddressClone(String address) {
        this.address = address;
    }

    @Override
    protected AddressClone clone() throws CloneNotSupportedException {
        AddressClone addressClone = (AddressClone)super.clone();
        addressClone.address = new String(this.getAddress());
        return addressClone;
    }
}
