package com.dremio.planalyzer;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProfileModelGenerator {
    public static void main(String[] args) throws IOException {
        convertJsonToJavaClass(new File("samples/fm-v13.json").toURI().toURL(), new File("src/main/java"), "com.dremio.planalyzer.model", "Profile");
    }

    public static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName)
            throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isUsePrimitives() {
                return true;
            }

            @Override
            public boolean isUseLongIntegers() {
                return true;
            }

            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

        jcodeModel.build(outputJavaClassDirectory);
    }

}
