package ${basePackageName}.${projectName}.model;

import java.io.Serializable;

public class ${modelClassSimpleName} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list propertyList as property>
    private ${property.resultType} ${property.name};
</#list>

<#list propertyList as property>
    public ${property.resultType} get${property.name?cap_first}() {
        return ${property.name};
    }

    public void set${property.name?cap_first}(${property.resultType} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#list>
}
