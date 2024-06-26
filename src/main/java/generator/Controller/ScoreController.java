
package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import generator.Common.R;
import generator.Common.ThreadUtil;
import generator.domain.Student;
import generator.domain.VO.Score;
import generator.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ScoreController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public R<List<Student>> list() {
        List<Student> list = studentService.list();
        return R.success(list);
    }

    @PutMapping("/add")
    public R<String> add(@RequestBody Student student) {
        studentService.save(student);
        return R.success("添加成功");
    }

    @DeleteMapping("/del/{id}")
    public R<String> del(@PathVariable Long id) {
        Long studentid = id;
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentId, studentid);
        Student one = studentService.getOne(queryWrapper);
        System.out.println(one);

        studentService.remove(queryWrapper);
        return R.success("删除成功");
    }

    @GetMapping("/listscore")
    public R listScore() {
        int A = 0, B = 0, C = 0, D = 0;
        List<Student> list = studentService.list();
        for (Student student : list) {
            int s = Integer.parseInt(student.getStudentScore());
            if (s >= 90) {
                A++;
            }
            if (s >= 75 && s < 90) {
                B++;
            }
            if (s >= 60 && s < 75) {
                C++;
            }
            if (s < 60) {
                D++;
            }
        }
        Score score = new Score();
        score.setA(A);
        score.setB(B);
        score.setC(C);
        score.setD(D);
        return R.success(score);
    }

    @DeleteMapping("/loginout")
    public R loginout() {
        ThreadUtil.remove();
        return R.success("退出成功");
    }

}
