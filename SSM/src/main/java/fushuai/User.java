package fushuai;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="fushuai-User")
public class User implements Serializable {
    /**
    * id
    */
    @ApiModelProperty(value="id")
    private Integer id;

    /**
    * username
    */
    @ApiModelProperty(value="username")
    private String username;

    /**
    * password
    */
    @ApiModelProperty(value="password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}