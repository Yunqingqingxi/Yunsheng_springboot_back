package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import generator.Common.PageCode;
import generator.Common.R;
import generator.domain.Category;
import generator.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PutMapping
    public R updateCategory(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    @GetMapping("/page")
    public R<PageCode> page(int page, int pageSize, String name, Long type) {
        Page<Category> pgaeinfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(type != 0, Category::getType, type);
        lambdaQueryWrapper.like(name != null, Category::getName, name);
        lambdaQueryWrapper.orderByDesc(Category::getSort);
        Page<Category> page1 = categoryService.page(pgaeinfo, lambdaQueryWrapper);
        Long total = page1.getTotal();
        List<Category> records = page1.getRecords();
        return R.success(new PageCode(total, records));
    }

    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable int status, @RequestBody List<Long> ids) {
        List<Category> categories = categoryService.listByIds(ids);
        categories.forEach(category -> category.setStatus(status));
        return R.success("修改成功");
    }

    @DeleteMapping
    public R<String> delete(@RequestBody List<Long> ids) {
        categoryService.removeByIds(ids);
        return R.success("删除成功");
    }

    @GetMapping("/list/{type}")
    public R<PageCode> list(@PathVariable int type) {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Category::getType, type);
        List<Category> list = categoryService.list(lambdaQueryWrapper);
        Long total = categoryService.count();
        List<Category> records = list.stream().filter(category -> category.getType() == type).collect(Collectors.toList());
        return R.success(new PageCode(total, records));

    }

    @PostMapping
    public R<String> save(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("新增分类成功");

    }


}
