Reference link[https://www.jbpm.org/businessapps/gettingStarted.html]

## Generate package
1. Data model archetype **-model**
```
mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-model-archetype -DarchetypeVersion=7.74.1.Final -DgroupId=com.company -DartifactId=business-application-model -Dversion=1.0-SNAPSHOT -Dpackage=com.company.model
```

2. Business assets project archetype **-kjar**
    ```
    mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-kjar-archetype -DarchetypeVersion=7.74.1.Final -DgroupId=com.company -DartifactId=business-application-kjar -Dversion=1.0-SNAPSHOT -Dpackage=com.company
    ```
    **if Dynamic assets project archetype**
    ```
    mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-kjar-archetype -DarchetypeVersion=7.74.1.Final -DcaseProject=true -DgroupId=com.company -DartifactId=business-application-kjar -Dversion=1.0-SNAPSHOT -Dpackage=com.company
    ```

3. Service project archetype **-service**
    - **Business automation(bpm)**
    ```
    mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-service-spring-boot-archetype -DarchetypeVersion=7.74.1.Final -DgroupId=com.company -DartifactId=business-application-service -Dversion=1.0-SNAPSHOT -Dpackage=com.company.service -DappType=bpm
    ```
    - **Decision management(brm)**
    ```
    mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-service-spring-boot-archetype -DarchetypeVersion=7.74.1.Final -DgroupId=com.company -DartifactId=business-application-service -Dversion=1.0-SNAPSHOT -Dpackage=com.company.service -DappType=brm
    ```
    - **Business optimization(planner)**
    ```
    mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-service-spring-boot-archetype -DarchetypeVersion=7.74.1.Final -DgroupId=com.company -DartifactId=business-application-service -Dversion=1.0-SNAPSHOT -Dpackage=com.company.service -DappType=planner
    ```

## Run the package
1. Add following for JDK 21:
```
    dependency>
        <groupId>org.kie</groupId>
        <artifactId>kie-server-spring-boot-starter</artifactId>
        <version>${version.org.kie}</version>
    </dependency>
```
2. Add <parent> for jBPM 7.7.74:
```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.9</version>
    </parent>
```
3. Launch the app at http://localhost:8090
    for windows
    ```
    launch.bat clean install 
    launch-dev.bat clean install
    launch.bat clean install -Pmysql   with MySQL
    launch.bat clean install -Ppostgres    with PostgreSQL
    ```

## Import into Business Central
1. Import your business assets project into Business Central
    - Go into business assets project - business-application-kjar
    - Execute
    ```
    git init
    ``` 
    - Execute 
    ```
    git add -A
    ```
    - Execute 
    ```
    git commit -m "my business assets project"
    ```
    - Log in to Business Central and go to projects
    - Select import project and enter the following URL file:///{path to your business application}/business-application-kjar
    - Click import and confirm project to be imported

2. Geenrate assest at /business-central.......
3. Fetch the built asset:
    - Go to business-application-kjar
    ```
    git remote add origin ssh://wbadmin@localhost:8001/<MySpace>/<business-application-kjar>
    git pull origin master
    ```
    eg:
    ```
    git remote add origin ssh://wbadmin@localhost:8001/Business_Application/business-application-kjar
    git pull origin master
    ```
    - Go to business-application-service directory and launch the application
    ```
    ./launch.sh clean install for Linux/Unix
    ./launch.bat clean install for Windows
    ```
