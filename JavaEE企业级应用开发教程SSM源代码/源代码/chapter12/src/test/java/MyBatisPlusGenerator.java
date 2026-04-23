
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Arrays;
import java.util.List;


public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        // 指定自动生成的代码基于哪些数据表名
        List<String> tableNames = Arrays.asList("book");
        // 创建代码生成器对象
        FastAutoGenerator generator = create(tableNames);
        // 执行生成代码
        generator.execute();
    }
    private static FastAutoGenerator create(List<String> tableNames) {
        // 数据库连接地址
        String url = "jdbc:mysql://localhost:3306/mybatis";
        // 数据库用户名
        String name = "root";
        // 数据库密码
        String password = "root";
        FastAutoGenerator generator = FastAutoGenerator.create(url, name, password)
                 // 全局配置
                .globalConfig(builder -> {
                   // 获取生成的代码路径
                    String outputDir = System.getProperty("user.dir") +
                            "/src/main/java";
                    builder.outputDir(outputDir)
                            .dateType(DateType.ONLY_DATE)
                            // 生成的类注释中的作者名称
                            .author("hm");
                })
                // 生成的代码包路径配置
                .packageConfig(builder -> {
                    // 生成的包的公共路径
                    builder.parent("com.itheima");
                    // 在parent路径下面指定生成XML映射文件的包
                    builder.xml("mapper")
                            // 生成实例类的包
                            .entity("entity")
                            .controller("controller")
                            // 生成的Service的包
                            .service("service")
                            // 生成的Mampper的包
                            .mapper("mapper");
                })
                .strategyConfig(builder -> {
                   // 添加要生成的的数据库表
                    builder.addInclude(tableNames)
                    // 启用大写模式
                            .enableCapitalMode();
                     // 配置生成的实体类策略，不生成serialVersionID
                    builder.entityBuilder().disableSerialVersionUID()
                             // 如果数据库表名带下划线，按驼峰命名法
                            .columnNaming(NamingStrategy.underline_to_camel)
                            // 使用lombok
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            // 实例类每次生成的时候，覆盖旧的实体类
                            .enableFileOverride()
                            // 指定生成的实体类名称
                            .convertFileName(entityName -> entityName)
                            // 指定生成的Service接口名称
                            .serviceBuilder().convertServiceFileName(entityName ->
                                    entityName + "Service")
                             // 指定生成的ServiceImpl的名称
                            .convertServiceImplFileName(entityName ->
                                    entityName + "ServiceImpl")
                            // 指定生成的Controller的名称
                            .controllerBuilder().convertFileName(entityName ->
                                    entityName+ "Controller" );
                });
        return generator;
    }
}

