CREACION DEL PROYECTO
$ mvn archetype:create -DgroupId=examples -DartifactId=servlets-jsp -DpackageName=examples.servlets -DarchetypeArtifactId=maven-archetype-webapp

CORRER EL PROYECTO
Se puede correr con jetty o tomcat
+Con jetty ejecutar
	mvn jetty:run
+Con tomcat
	Definir CATALINA_HOME a donde esta el tomcat
	Meter esta entrada al archivo tomcat-users.xml
		<role rolename="manager"/>
  		<role rolename="standard"/>
  		<user username="admin" password="" roles="standard,manager"/>
  		Iniciar tomcat normalmente
  	Correr para mover el war a tomcat, arrancarlo
  		mvn tomcat:deploy
  		mvn tomcat:start
  	Para pararlo
  		mvn tomcat:stop
  	Para pararlo y desdeployarlo
  		mvn tomcat:undeploy
	Tambien se puede usar tomcat:redeploy para evitarse tantos pasos
	Para más información de tomcat 
		$ mvn help:describe -Dplugin=tomcat

DESCRIPCION
