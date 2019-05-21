package com.amyliascarlet.jsontest.test.benchmark.encode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;
import com.amyliascarlet.jsontest.test.entity.case2.Category;

public class CategoryEncode extends BenchmarkCase {

    private Object object;

    public CategoryEncode(){
        super("CategoryEncode");

        Category category = new Category();
        category.setId(1);
        category.setName("root");
        {
            Category child = new Category();
            child.setId(2);
            child.setName("child");
            category.getChildren().add(child);
            child.setParent(category);
        }

        object = category;
    }

    @Override
    public void execute(Codec codec) throws Exception {
        for (int i = 0; i < 10; ++i) {
            codec.encode(object);
        }
    }
}
