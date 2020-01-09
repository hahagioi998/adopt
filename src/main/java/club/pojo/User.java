package club.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:18
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String telephone;
    private String Email;
    private String address;
    private String pic;
    private Integer state=0;

    List<Comment> commentList;
    List<AdoptAnimal> animalList;

}