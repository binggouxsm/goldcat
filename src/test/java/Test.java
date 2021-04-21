import com.eden.msutils.mybatis.generator.AutoGenerator;
import com.eden.msutils.mybatis.generator.config.*;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = "D:/project/goldcat";
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setXmlOutputDir(projectPath + "/src/test/resources");
        globalConfig.setAuthor("xsm");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);


        String url = "jdbc:mysql://localhost:3306/goldcat?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String useName ="goldcat";
        String password = "goldcat";
        DataSourceConfig dataSourceConfig = new DataSourceConfig(url,driverName,useName,password);

        Map<String,String> tableModule = new HashMap<>();
        tableModule.put("account","account");
//        tableModule.put("account_book","account");
//		tableModule.put("balance_history","account");
//
//        tableModule.put("record","record");
//
//        tableModule.put("dict_item","system");
//        tableModule.put("type","system");
//        tableModule.put("user_info","system");
//        tableModule.put("file_info","system");



        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.eden.finance.goldcat");
        packageConfig.setTableModule(tableModule);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.enable(TemplateType.ENTITY, TemplateType.XML);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setDiableServiceInterface(true);
        strategyConfig.setChainModel(true);
        strategyConfig.setBaseColumnList(true);

        AutoGenerator gen = new AutoGenerator();
        gen.setDataSourceConfig(dataSourceConfig).setGlobalConfig(globalConfig).setPackageConfig(packageConfig).setTemplateConfig(templateConfig).setStrategyConfig(strategyConfig).execute();

    }
}
