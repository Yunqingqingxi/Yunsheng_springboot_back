package generator.domain.VO;

import lombok.Data;

@Data
public class EmpVo {
 int id;
 String name;
 String token;
 String userName;

 public EmpVo(Long id, String name, String token, String userName) {
  this.id = id.intValue(); // 类型转换
  this.name = name;
  this.token = token;
  this.userName = userName;
 }
}
